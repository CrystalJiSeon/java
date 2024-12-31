package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass13 {
	public static void main(String[] args) {
		//select 할 회원 번호
		int num = 4;
		
		//미리 준비된 메소드를 이용해서 회원번호를 전달하고 해당하는 회원 정보를 DB에서리턴받기
		MemberDto dto=getData(num);
		if(dto!=null) {
			System.out.printf("번호:%d, 이름:%s, 주소:%s" , dto.getNum(),dto.getName(), dto.getAddr());
		}else {
			System.out.printf("요청한 %d 회원의 정보를 찾을 수 없습니다", num);
		}
	}
	//매개변수로 전달되는 번호에 해당하는 회원 정보를 select 해서 MemberDto 객체에 담아서 리턴해주는 메소드
	public static MemberDto getData(int num) {
		//memberdto 객체를 담을 변수를 미리 선언
		MemberDto dto=null;
		
		//필요한 객체를 담을 지역변수 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//Connection 객체의 참조값 얻어내기
			conn=new DBConnector().getConn();
			//실행할 미완성의 sql 문
			String sql= """
						select name, addr 
						from member
						where num=?
					""";
			//미완성의 sql 문을 전달하면서 PreparedStatement객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			//만일 select 된 row가 있다면 if 안으로 들어가서 실행, 없으면 바깥으로 빠져서 null return
			if(rs.next()) {
				//MemberDto 객체를 생성해서
				dto=new MemberDto();
				//select 된 정보를 담는다
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {}
		}
		return dto;
	}
	
}
