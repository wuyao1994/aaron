package com.awesome.controller;

import com.awesome.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class AccountController {

	@Autowired
	private AccountService accountService;



	@RequestMapping
	public Map<String, Object> user() {
		return accountService.getUser();
	}



	@PostMapping("/login")
	public void login(String username, String password) {
		accountService.login(username, password);
	}

}
