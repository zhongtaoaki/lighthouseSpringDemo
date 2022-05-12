package com.example.lighthouseSpringDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lighthouseSpringDemo.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

	UserInfo findByName(String name);
	
}
