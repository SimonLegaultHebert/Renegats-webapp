package webapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import webapp.exception.RateLimitExceededException;
import webapp.model.Champion;
import webapp.model.Stats;
import webapp.service.BeanCreator;
import webapp.service.HtmlDownloader;
import webapp.util.ChampionMapSorter;

@Component
public class ChampionRepository {

	@Autowired
    @Qualifier("serviceHtmlDownloader")
	private HtmlDownloader serviceHtmlDownloader;
	
	@Autowired
    @Qualifier("serviceBeanCreator")
	private BeanCreator serviceBeanCreator;

	@Autowired
	private Environment env;
	
	//TODO find a way to update DATA
	@Cacheable("championList")
	public LinkedHashMap<Champion, Stats> getChampionListBySummonerID(int ID) throws ParseException, IOException, RateLimitExceededException{
		String url = "https://na.api.pvp.net/api/lol/na/v1.3/stats/by-summoner/" + ID + "/ranked?api_key=" + env.getProperty("key");
		LinkedHashMap<Champion, Stats> championMap = serviceBeanCreator.createChampionList(serviceHtmlDownloader.getRequestContent(url));
		championMap = ChampionMapSorter.sort(championMap);		
		return championMap;
	}
	
	@Cacheable("champion")
	public Champion getChampionInfoByID(int ID) throws ParseException, IOException, RateLimitExceededException{
		String url = "https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion/" + ID + "?api_key=" + env.getProperty("key");
		Champion champion = serviceBeanCreator.createChampionInfo(ID, serviceHtmlDownloader.getRequestContent(url));
		return champion;		
	}
}
