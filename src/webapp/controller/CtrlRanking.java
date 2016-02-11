package webapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webapp.exception.RateLimitExceededException;
import webapp.service.SummonerRanking;

@Controller
@RequestMapping("ranking")
public class CtrlRanking {

	public static final String WINRATE_STANDING = "/winrateStanding";
	public static final String KDA_STANDING = "/KDAStanding";
	
	@Autowired
    @Qualifier("serviceSummonerRanking")
    private SummonerRanking serviceSummonerRanking;
	
	@RequestMapping(value = WINRATE_STANDING, method = RequestMethod.GET)
	public ModelAndView standing() throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException {	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("teamList", serviceSummonerRanking.orderChampionByWinrate());
		return new ModelAndView("standingWinrate", model);

	}
	
	@RequestMapping(value = KDA_STANDING, method = RequestMethod.GET)
	public ModelAndView winrate() throws UnsupportedOperationException, ParseException, IOException, RateLimitExceededException {	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("teamList", serviceSummonerRanking.orderChampionByKDA());
		return new ModelAndView("standingKDA", model);

	}
}
