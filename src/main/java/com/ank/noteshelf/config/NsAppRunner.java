package com.ank.noteshelf.config;

import static com.ank.noteshelf.resource.NsCommonConstant.CACHE_APP_CONFIG;
import static com.ank.noteshelf.resource.NsCommonConstant.GCP_CREDENTIALS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ank.noteshelf.resource.NsMessageConstant;
import com.ank.noteshelf.response.AppConfigResponse;
import com.ank.noteshelf.service.impl.AppConfigServiceImpl;

/**
 * This class will load additional data during application boot up like Cache
 * Configurations.
 */
@Component
@Order(value = 0)
public class NsAppRunner implements CommandLineRunner {

    @Autowired
    AppConfigServiceImpl appConfigService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private YAMLConfig myConfig;

    @Bean
    public CacheManager cacheManager() {
	/*
	 * Note: This is by no means a sophisticated CacheManager; it comes with no
	 * cache configuration options. However, it may be useful for testing or simple
	 * caching scenarios. For advanced local caching needs, consider {@link
	 * org.springframework.cache.jcache.JCacheCacheManager}, {@link
	 * org.springframework.cache.ehcache.EhCacheCacheManager}, {@link
	 * org.springframework.cache.caffeine.CaffeineCacheManager}.
	 */
	return new ConcurrentMapCacheManager(CACHE_APP_CONFIG);
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {

	// update this to add all the configurations.
	AppConfigResponse appConfigResponse = appConfigService.getConfigurationByName(GCP_CREDENTIALS);
	if (appConfigResponse != null) {

	    try {
		cacheManager.getCache(CACHE_APP_CONFIG).put(appConfigResponse.getConfigurationName(),
			appConfigResponse.getConfigurationValue());
	    } catch (Exception e) {
		logger.error(NsMessageConstant.LOAD_DATA_EXCEPTION);
	    }

	}
	logger.info("Configuration Name: " + myConfig.getName());
    }

}
