package com.example.lighthouseSpringDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.lighthouseSpringDemo.model.UserInfo;
import com.example.lighthouseSpringDemo.repository.UserInfoRepository;

@Controller
public class UserController {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@GetMapping("/user")
	public ModelAndView getUser(ModelAndView mv) {
		
		List<UserInfo> users = new ArrayList<>();
		users = userInfoRepository.findAll();
		
		mv.addObject("users", users);
		mv.setViewName("userList");
		
		return mv;
	}
}
