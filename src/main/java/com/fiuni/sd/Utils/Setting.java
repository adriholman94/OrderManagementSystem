package com.fiuni.sd.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:settings.properties")
public class Setting {
	
	public static final String cacheName = "system-api-cache";
	
	@Value("${page.size}")
	private int page_size;

	public int getPage_size() {
		return page_size;
	}
}
