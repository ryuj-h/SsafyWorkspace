package com.ssafy.term10.service;




import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.term10.model.dto.Attendance;


@Service
public class AttendanceServiceImpl implements AttendanceService {
	
//	@Autowired
//	private SqlSession sqlSession;
	
	private AttendanceMapper attendanceMapper;

	public AttendanceServiceImpl(AttendanceMapper attendanceMapper) {
		super();
		this.attendanceMapper = attendanceMapper;
	}

	@Override
	public int idCheck(String userId) throws Exception {
//		return sqlSession.getMapper(MemberMapper.class).idCheck(userId);
		return attendanceMapper.idCheck(userId);
	}

	@Override
	public void joinMember(Attendance Attandance) throws Exception {
//		sqlSession.getMapper(MemberMapper.class).joinMember(Attandance);
		attendanceMapper.joinMember(Attandance);
	}

	@Override
	public Attendance loginMember(Map<String, String> map) throws Exception {
//		return sqlSession.getMapper(MemberMapper.class).loginMember(map);
		return attendanceMapper.loginMember(map);
	}

}
