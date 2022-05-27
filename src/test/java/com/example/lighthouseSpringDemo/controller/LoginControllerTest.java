package com.example.lighthouseSpringDemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.lighthouseSpringDemo.model.UserInfo;
import com.example.lighthouseSpringDemo.repository.UserInfoRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserInfoRepository userInfoRepository;

	@Test
	public void getLoginView_success() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders//
				.get("/login")//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)//
				.andExpect(view().name("login"));
	}

	@Test
	public void login_success() throws Exception {

		String username = "admin";
		String password = "admin";
		UserInfo userInfo = UserInfo.builder()//
				.name(username)//
				.password("123")//
				.build();

		when(userInfoRepository.findByName(username)).thenReturn(userInfo);

		RequestBuilder request = MockMvcRequestBuilders//
				.post("/login")//
				.param("username", username)//
				.param("password", password)//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)//
				.andExpect(view().name("success"));

	}

}
