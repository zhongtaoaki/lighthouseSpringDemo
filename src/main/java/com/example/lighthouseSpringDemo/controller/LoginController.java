package com.example.lighthouseSpringDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@GetMapping("/login")
	public String getLoginView() {

		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelAndView mv) {

		mv.addObject("username", username);

		if (username.equals("admin") && password.equals("admin")) {
			mv.setViewName("success");
		} else {
			mv.setViewName("fail");
		}

		return mv;
	}

	@GetMapping("/success")
	public String getSuccessView() {
		return "success";
	}
}
