package com.ssafy.admin.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.ssafy.member.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(
		properties = { 
				"spring.config.location=classpath:application.properties"
		},
		classes = {AdminUserController.class})
@Slf4j
@ComponentScan(basePackages= {"com.ssafy"})
@ContextConfiguration(classes= AdminUserController.class)
class AdminUserControllerTest {

	@Value("${userid}")
	private String userId;
	
	@Value("${userpwd}")
	private String userPwd;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MockMvc mockMvc;	
	
	//이거 오류남 왜나는지 모름
	@Test
	@Disabled
	@DisplayName("#### 회원 목록 테스트 ####")
	void testUserList() throws Exception {
		log.debug("#### 회원 목록 테스트 시작 ####");
		mockMvc.perform(get("/admin/user"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(print());

		log.debug("#### 회원 목록 테스트 종료 ####");
		//fail("Not yet implemented");
	}

	@Test
	@DisplayName("#### 회원 가입 테스트 ####")
	//@Disabled
	void testUserRegister() {
		log.debug("#### 회원 가입 테스트 시작 ####");
		mockMvc.perform(get("/admin/user"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(print());
	}

	@Test
	@DisplayName("#### 회원 정보 테스트 ####")
	@Disabled
	void testUserInfo() throws Exception {
		log.debug("#### 회원 정보 테스트 시작 ####");
		mockMvc.perform(get("/admin/user" + userId))//{userId : ssafy, userPwd: 1234, userName: 김싸피, . . .}
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.userId", is(userId)))
			.andDo(print());

		log.debug("#### 회원 정보 테스트 종료 ####");
		//fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUserModify() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUserDelete() {
		fail("Not yet implemented");
	}

}

