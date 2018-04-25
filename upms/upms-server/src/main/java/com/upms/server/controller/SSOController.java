package com.upms.server.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.upms.rpc.api.UpmsApiService;

@RestController
@RequestMapping("/user")
public class SSOController {
    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20881")
	private UpmsApiService		mUpmsApiService;



	@RequestMapping
	public Map<String, Object> user() {
		return mUpmsApiService.getUser();
	}



	@PostMapping("/login")
	public void login(String username, String password) {
		mUpmsApiService.login(username, password);
	}

}
