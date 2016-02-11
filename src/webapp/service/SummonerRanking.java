package webapp.service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import webapp.exception.RateLimitExceededException;
import webapp.model.Champion;
import webapp.model.Stats;
import webapp.model.Summoner;
import webapp.util.SummonerKDAComparator;
import webapp.util.SummonerWinrateComparator;

@Service("serviceSummonerRanking")
public class SummonerRanking {
	
	@Autowired
    @Qualifier("serviceSummonerSearch")
    private SummonerSearch serviceSummonerSearch;
	
	@Autowired
	private Environment env;
	
	public List<Summoner> orderChampionByWinrate() throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		ArrayList<Summoner> teamList = createTeamList();
		Collections.sort(teamList, new SummonerWinrateComparator());
		return teamList;
	}

	public List<Summoner> orderChampionByKDA() throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		ArrayList<Summoner> teamList = createTeamList();
		Collections.sort(teamList, new SummonerKDAComparator());
		return teamList;
	}
	
	private ArrayList<Summoner> createTeamList() throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException{
		ArrayList<Summoner> teamList = new ArrayList<Summoner>();
		String[] summonerList = env.getProperty("summoners").split(", ");
		for(String username : summonerList){
			Summoner summoner = serviceSummonerSearch.searchSummonerSummaryStats(username);
			teamList.add(summoner);
		}	
	
		return teamList;
	}
}
