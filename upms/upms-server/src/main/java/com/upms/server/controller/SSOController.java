package com.upms.server.controller;

import java.util.Map;

import com.upms.dao.model.ShiroUser;
import com.upms.dao.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.upms.rpc.api.UpmsApiService;

import static org.apache.shiro.SecurityUtils.getSubject;

@RestController
@RequestMapping("/user")
public class SSOController {
    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880",
			timeout = 1200000
    )
	private UpmsApiService		mUpmsApiService;



	@RequestMapping
	public Map<String, Object> user() {
		Map<String, Object> res = Maps.newHashMap();
		if (getSubject().isAuthenticated() || getSubject().isRemembered()) {
			ShiroUser user = (ShiroUser) getSubject().getPrincipal();
			mUpmsApiService.setShiroUserExtraInfo(user);
			res.put("user", user);
			res.put("menu", user.getMenus());
			return res;
		} else {
			res.put("user", null);
			res.put("menu", null);
			return res;
		}

	}



	@PostMapping("/login")
	public void login(String username, String password) {
		mUpmsApiService.login(username, password);
	}

}
