package com.ssafy.hello.dao;

import org.springframework.stereotype.Component;

@Component
public class HelloDaoImpl implements HelloDao {

	@Override
	public String greeting() {
		// TODO Auto-generated method stub
		return "안녕난 dao야";
	}

}
