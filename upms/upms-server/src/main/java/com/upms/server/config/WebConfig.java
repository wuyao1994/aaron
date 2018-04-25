package com.upms.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@RestController
public class WebConfig extends WebMvcConfigurerAdapter {
	@Value("classpath:/static/index.html")
	private Resource				indexHtml;

	private static final String[]	STATIC_RESOURCES	= { "/**/*.css", "/**/*.js", "/**/*.jpg", "/**/*.png",
			"/**/*.svg",																						// 图片
			"/**/*.eot", "/**/*.ttf", "/**/*.woff"																// 字体文件
	};



	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}



	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.setOrder(-1).addResourceHandler(STATIC_RESOURCES).addResourceLocations("classpath:/static/");
	}



	@GetMapping
	public Object index() {
		return ResponseEntity.ok().body(indexHtml);
	}
}
