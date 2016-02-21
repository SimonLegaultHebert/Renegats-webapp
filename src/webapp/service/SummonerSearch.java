package webapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import webapp.exception.RateLimitExceededException;
import webapp.model.Champion;
import webapp.model.RankedDivision;
import webapp.model.Stats;
import webapp.model.Summoner;
import webapp.repository.ChampionRepository;
import webapp.repository.SummonerRepository;
import webapp.util.ChampionMapSorter;

/**
 * Search the summoner's info from the RIOT API.
 * @author Leg
 *
 */
@Service("serviceSummonerSearch")
public class SummonerSearch {
	
	public static final int MOST_PLAYED_CHAMPIONS_NUMBER = 8;
	
	@Autowired
    @Qualifier("serviceHtmlDownloader")
	private HtmlDownloader serviceHtmlDownloader;
	
	@Autowired
    @Qualifier("serviceBeanCreator")
	private BeanCreator serviceBeanCreator;

	@Autowired
	private ChampionRepository championRepository;
	
	@Autowired
	private SummonerRepository summonerRepository;
	
	@Autowired
	private Environment env;
	
	/**
	 * Search the Summoner's summary statistics, the most played champions list and the ranked division.
	 * @param username
	 * @return
	 * @throws RateLimitExceededException 
	 */
	public Summoner searchAllSummonerInfo(String username) throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		Summoner summoner = searchSummonerBasicInfo(removeSpecialCharacters(username));
		LinkedHashMap<Champion, Stats> championMap = searchChampionList(summoner);
		calculateSummonerSummaryStats(summoner, championMap);
		RankedDivision rankedDivision = searchRankedDivision(summoner);
		summoner.setRankedDivision(rankedDivision);	

		summoner.setMostPlayedChampions(searchMostPlayedChampionList(championMap));
				
		return summoner;
	}
	
	/**
	 * Search the Summoner's summary statistics.
	 * @param username
	 * @return
	 * @throws RateLimitExceededException 
	 */
	public Summoner searchSummonerSummaryStats(String username) throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		Summoner summoner = searchSummonerBasicInfo(removeSpecialCharacters(username));
		LinkedHashMap<Champion, Stats> championMap = searchChampionList(summoner);
		calculateSummonerSummaryStats(summoner, championMap);
		return summoner;
	}
	
	/**
	 * Calculate the summary statistics for a specific Summoner.
	 * @param summoner
	 * @param championList
	 */
	private void calculateSummonerSummaryStats(Summoner summoner, LinkedHashMap<Champion, Stats> championMap){
		//The ID 0 champion represent the summoner's summary stats
		Set<Champion> championKey = championMap.keySet();
		Stats summaryStats = championMap.get(championKey.iterator().next());
		summaryStats.calculateAverageValues();
		summoner.setSummaryStats(summaryStats);
	}
	
	/**
	 * Search the ID, name and profile's icon info. (Summoner)
	 * @param username
	 * @return
	 * @throws RateLimitExceededException 
	 */
	private Summoner searchSummonerBasicInfo(String username) throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		Summoner summoner = summonerRepository.getSummonerBasicInfoByName(username);
		return summoner;
	}

	/**
	 * Search the champion list from the Summoner's ID.
	 * @param summoner
	 * @return
	 * @throws RateLimitExceededException 
	 */
	private LinkedHashMap<Champion, Stats> searchChampionList(Summoner summoner) throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		LinkedHashMap<Champion, Stats> championMap = championRepository.getChampionListBySummonerID(summoner.getId());
		return championMap;
	}
	
	/**
	 * Search the most played champions from the list and set their name and title. (Champion)
	 * @param championList
	 * @return
	 * @throws RateLimitExceededException 
	 */
	private LinkedHashMap<Champion, Stats> searchMostPlayedChampionList(LinkedHashMap<Champion, Stats> championMap) throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		LinkedHashMap<Champion, Stats> mostPlayedChampions = new LinkedHashMap<Champion, Stats>();			
		try{
			 Set<Champion> keySet = championMap.keySet();
			 Iterator<Champion> it = keySet.iterator();
			 it.next();
			 int i = 1;
			 while(it.hasNext() && i < MOST_PLAYED_CHAMPIONS_NUMBER){
				 Champion champion = it.next(); 
				 Stats stats = championMap.get(champion);
				 champion = championRepository.getChampionInfoByID(champion.getId());
				 stats.calculateAverageValues();
				 mostPlayedChampions.put(champion, stats);
				 i = i + 1;
			 }
			
		}catch (IndexOutOfBoundsException e){
			System.out.println("Chaosson exception");
		}
	
		return mostPlayedChampions;	
	}
	
	
	/**
	 * Search the ranked division from the Summoner's ID.
	 * @param summoner
	 * @return
	 * @throws RateLimitExceededException 
	 */
	private RankedDivision searchRankedDivision(Summoner summoner) throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		String url = "https://na.api.pvp.net/api/lol/na/v2.5/league/by-summoner/" + summoner.getId() + "/entry?api_key=" + env.getProperty("key");
		RankedDivision rankedDivision = serviceBeanCreator.createRankedDivision(summoner.getId(), serviceHtmlDownloader.getRequestContent(url));
		return rankedDivision;
	}

	private String removeSpecialCharacters(String str){
		str = str.toLowerCase();
		return str.replaceAll(" ", "");
	}
}
