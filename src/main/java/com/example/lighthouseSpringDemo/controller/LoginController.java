package com.example.lighthouseSpringDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.lighthouseSpringDemo.model.UserInfo;
import com.example.lighthouseSpringDemo.repository.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@GetMapping("/login")
	public String getLoginView() {

		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelAndView mv) {

		mv.addObject("username", username);

		UserInfo userInfo = userInfoRepository.findByName(username);
		log.info("userInfo: {}",userInfo);

		if (userInfo != null && password.equals(userInfo.getPassword())) {
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
