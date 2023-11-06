package com.ssafy.term10.service;
import java.util.Map;

import com.ssafy.term10.model.dto.Attendance;


public interface AttendanceService {

	int idCheck(String userId) throws Exception;
	void joinMember(Attendance memberDto) throws Exception;
	Attendance loginMember(Map<String, String> map) throws Exception;
	
}
