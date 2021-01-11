package com.fiuni.sd.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:settings.properties")
public class Setting {
	
	public static final String cache_Name = "system-api-cache";
	
	@Value("${page.size}")
	private int pageSize;

	@Value("${page.max.value}")
	private int maxPageSize;

	@Value("${cache.name}")
	private String cacheName;

	@Value("${cache.server.address")
	private String cacheAddress;

	public int getPage_size() {
		return pageSize;
	}

	public int getMaxPageSize() {
		return maxPageSize;
	}
}
