package webapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import webapp.exception.RateLimitExceededException;

/**
 * Create HTML content from an URL.
 * @author Leg
 *
 */
@Service("serviceHtmlDownloader")
public class HtmlDownloader {
	
	private static int numberOfRequest = 0;
	
	private HttpClient httpClient = HttpClientBuilder.create().build();
	
	public String getRequestContent(String url) throws UnsupportedOperationException, IOException, RateLimitExceededException{
		
		//TODO remove the thread sleep after getting a new API key
		numberOfRequest = numberOfRequest + 1;
		System.out.println(numberOfRequest);
		if(numberOfRequest == 10){
			try {
				System.out.println("SLEEP");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			numberOfRequest = 0;
		}
		
		HttpGet request = new HttpGet(url);
		HttpResponse response = httpClient.execute(request);

		String content = EntityUtils.toString(response.getEntity(), "UTF-8");
		if(content.contains("\"status_code\": 429")){
			throw new RateLimitExceededException("Api rate limit exceeded");
		}
		System.out.println("REQUEST CONTENT : " + content);
		
		return content;
	}
}
