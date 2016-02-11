package webapp.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.ehcache.config.CacheConfiguration;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@EnableWebMvc //mvc:annotation-driven
@Configuration
@EnableCaching
@PropertySource("/WEB-INF/config/config.properties")
@ComponentScan({"webapp.controller", "webapp.service", "webapp.repository"})
public class SpringWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	   return new PropertySourcesPlaceholderConfigurer();
	}
	
//	@Bean
//	public EhCacheCacheManager getEhCacheManager(){
//	        return  new EhCacheCacheManager(getEhCacheFactory().getObject());
//	}
//	@Bean
//	public EhCacheManagerFactoryBean getEhCacheFactory(){
//		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
//		factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//		factoryBean.setShared(true);
//		return factoryBean;
//	}
	
	@Bean
	 public CacheManager cacheManager() {
			SimpleCacheManager cacheManager = new SimpleCacheManager();
		   List<Cache> caches = new ArrayList<Cache>();
		   caches.add(new ConcurrentMapCache("champion"));
		   caches.add(new ConcurrentMapCache("summoner"));
		   caches.add(new ConcurrentMapCache("championList"));
		   cacheManager.setCaches(caches);
		   return cacheManager;
	 }
}

