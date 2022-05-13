package com.example.lighthouseSpringDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.lighthouseSpringDemo.model.UserInfo;
import com.example.lighthouseSpringDemo.repository.UserInfoRepository;

@Controller
public class RegisterController {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@GetMapping("/register")
	public String getRegisterView() {
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView register(//
			@RequestParam("username") String username, //
			@RequestParam("password") String password, //
			@RequestParam("password_again") String passwordAgain, //
			ModelAndView mv) {

		if (!password.equals(passwordAgain)) {
			
			mv.setViewName("fail");
			
		} else {
			
			UserInfo userInfo = UserInfo.builder()//
					.name(username)//
					.password(password)//
					.build();

			userInfoRepository.save(userInfo);

			mv.addObject("username", username);
			mv.setViewName("success");

		}

		return mv;
	}
}
