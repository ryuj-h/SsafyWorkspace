package com.ssafy.ws.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	private DataSource ds;
	
	
//	@Autowired	생략가능
	public MemberDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public Member login(Member member) throws SQLException {
		//1. sql 작성
		String sql = "select member_id, name\r\n" + 
				"from member\r\n"
				+ "where member_id=? and password=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//2. DB 연결
			conn = ds.getConnection();
			
			//3. 쿼리실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();
			
			//4. 조회 결과 파싱 후 반환
			if(rs.next()){
				Member memberInfo = new Member();
				memberInfo.setMemberId(rs.getString("member_id"));
				memberInfo.setName(rs.getString("name"));
				return memberInfo;
			}
			return null;
			
		} finally {
			//5. 자원 반납
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}
}
