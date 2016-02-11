package webapp.repository;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import webapp.exception.RateLimitExceededException;
import webapp.model.Summoner;
import webapp.service.BeanCreator;
import webapp.service.HtmlDownloader;

@Component
public class SummonerRepository {

	@Autowired
    @Qualifier("serviceHtmlDownloader")
	private HtmlDownloader serviceHtmlDownloader;
	
	@Autowired
    @Qualifier("serviceBeanCreator")
	private BeanCreator serviceBeanCreator;

	@Autowired
	private Environment env;
	
	@Cacheable("summoner")
	public Summoner getSummonerBasicInfoByName(String username) throws ParseException, IOException, RateLimitExceededException{
		String url = "https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/" + username + "?api_key=" + env.getProperty("key");
		Summoner summoner = serviceBeanCreator.createSummoner(username, serviceHtmlDownloader.getRequestContent(url));
		return summoner;
	}
}
