package webapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.exception.RateLimitExceededException;
import webapp.model.Summoner;
import webapp.service.SummonerSearch;

@Controller
@RequestMapping("summoners")
public class CtrlSummoner {
 
	public static final String VIEW_SEARCH = "/search";
	
	@Autowired
    @Qualifier("serviceSummonerSearch")
    private SummonerSearch serviceSummonerSearch;
	
	@RequestMapping(value = VIEW_SEARCH, method = RequestMethod.GET)
	public ModelAndView summoner(@RequestParam(value = "username") String username) throws UnsupportedOperationException, IOException, ParseException, RateLimitExceededException {
		Map<String, Object> model = new HashMap<String, Object>();
		Summoner summoner = serviceSummonerSearch.searchAllSummonerInfo(username);	
		model.put("summoner", summoner);
		model.put("mostPlayedChampions", summoner.getMostPlayedChampions());
		
		return new ModelAndView("summoner", model);
	}
}