package webapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import webapp.model.Champion;
import webapp.model.RankedDivision;
import webapp.model.Stats;
import webapp.model.Summoner;

import com.google.gson.Gson;

/**
 * Create the beans from Json.
 * @author Leg
 *
 */
@Service("serviceBeanCreator")
public class BeanCreator {

	public static final String CHAMPION_KEY = "champions";
	public static final String NAME_KEY = "name";
	public static final String TITLE_KEY = "title";
	public static final String TIER_KEY = "tier";
	public static final String DIVISION_KEY = "division";
	public static final String ENTRIES_KEY = "entries";
	
	private Gson gson = new Gson();
	private JSONParser parser = new JSONParser();
	
	public Summoner createSummoner(String summonerName, String content) throws ParseException{	
		Summoner summoner = null;
		JSONObject src = (JSONObject) parser.parse(content);
	    JSONObject srcPostTraitement = (JSONObject) src.get(summonerName);
		summoner = gson.fromJson(srcPostTraitement.toString(), Summoner.class);
		return summoner;
	}
	
	public LinkedHashMap<Champion, Stats> createChampionList(String content) throws ParseException{
		LinkedHashMap<Champion, Stats> championMap = new LinkedHashMap<Champion, Stats>();
		JSONObject src = (JSONObject) parser.parse(content);
		JSONArray jsonArray = (JSONArray) src.get(CHAMPION_KEY);
		
		for(Object object : jsonArray){
			JSONObject jsonObject = (JSONObject)object;
			Champion champion = new Champion();
			champion.setId(Integer.valueOf(jsonObject.get("id").toString()));
			Stats stats = gson.fromJson(jsonObject.get("stats").toString(), Stats.class);
			championMap.put(champion, stats);
		}
		return championMap;		
	}
	
	public Champion createChampionInfo(int ID, String content) throws ParseException{
		Champion champion = new Champion();
		champion.setId(ID);
		JSONObject src = (JSONObject) parser.parse(content);
		champion.setName(src.get(NAME_KEY).toString());
		champion.setTitle(src.get(TITLE_KEY).toString());
		champion.setImage(replaceSpecialCharacters(champion.getName()));
		return champion;
	}

	private String replaceSpecialCharacters(String championName){
		championName = championName.replaceAll(" |\\.", "");
		return championName;
	}
	
	public RankedDivision createRankedDivision(int summonerID, String content) throws ParseException{
		JSONObject src = (JSONObject) parser.parse(content);
		JSONArray jsonArray = (JSONArray) src.get(String.valueOf(summonerID));
		JSONObject obj = (JSONObject) jsonArray.get(0);
		JSONArray jsonArray2 = (JSONArray) obj.get(ENTRIES_KEY);
		JSONObject obj2 = (JSONObject) jsonArray2.get(0);
	
		RankedDivision rankedDivision = new RankedDivision();
		rankedDivision.setDivision(obj2.get("division").toString());
		rankedDivision.setTier(obj.get("tier").toString());
		return rankedDivision;
	}
}
