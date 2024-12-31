package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass11 {
	public static void main(String[] args) {
		//수정할 회원 정보라고 가정하자
		String name="이름3";
		String addr="다른 주소";
		int num = 1;
		
		//수정할 회원정보를 MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setNum(num);
		//미리 준비된 메소드를 이용해서 DB에 저장하고 성공여부를 리턴받기
		boolean isSuccess=update(dto);
		if(isSuccess) {
			System.out.println("수정했습니다");
		}else {
			System.out.println("수정하지 못했습니다");
		}
	}
	/*
	 * 수정할 회원의 정보(번호, 이름, 주소)가 MemberDto 객체에 담겨서 전달되는 메소드
	 * 성공여부가 리턴되는 메소드
	 */
	public static boolean update(MemberDto dto) {
		//필요한 객체를 담을 지역변수 미리 만들기
				Connection conn=null;
				PreparedStatement pstmt=null;
				//변경된 row 갯수를 저장할 변수를 0을 대입하여 미리 만들어두기
				int rowCount=0;
				try {
					//Connection 객체의 참조값 얻어내기
					conn=new DBConnector().getConn();
					//실행할 미완성의 sql 문
					String sql= """
								Update member
								set name=?, addr=?
								where num=?
							""";
					//미완성의 sql 문을 전달하면서 PreparedStatement객체의 참조값 얻어내기
					pstmt = conn.prepareStatement(sql);
					//?에 값 바인딩하기
					pstmt.setString(1, dto.getName());
					pstmt.setString(2, dto.getAddr());
					pstmt.setInt(3,	dto.getNum());
					//sql문 실행하고 추가(Insert)되거나, 변경(Update)되거나, 삭제(Delete)된 row의 갯수(int 값)를 리턴 받음
					rowCount= pstmt.executeUpdate();
				}catch(SQLException se) {
					se.printStackTrace();
				}finally {
					try {
						if(pstmt!=null)pstmt.close();
						if(conn!=null)conn.close();
					}catch(Exception e) {}
				}
				//rowCount 변수에 들어 있는 값을 확인해서 작업의 성공 여부를 리턴해줌
				if(rowCount>0) {
					return true;
				}else {
					return false;
				}	
				
				
		
	}
}
