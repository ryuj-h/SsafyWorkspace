package com.ssafy.term10.service;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.term10.model.dto.Attendance;

@Mapper
public interface AttendanceMapper {

	int idCheck(String userId) throws SQLException;
	void joinMember(Attendance memberDto) throws SQLException;
	Attendance loginMember(Map<String, String> map) throws SQLException;
	
}
