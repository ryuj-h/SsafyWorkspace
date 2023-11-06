package com.ssafy.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/*@SpringBootTest(
	properties = {
			"userid=ssafy",
			"userpwd=1234"
	}
)*/

@SpringBootTest(
		properties = {
				"\n" + 
				"spring.config.location=classpath:application.properties"
		})


@Slf4j
class Board6SpringbootApplicationTests {
	
	@Value("${userid}")
	private String userId;
	
	@Value("${userpwd}")
	private String userPwd;
	
	@Test
	@DisplayName("###### 프로퍼티 읽기 테스트 ######")
	void contextLoads() {
		log.debug("userid,userPwd : {}, {}", userId,userPwd);
	}

}
