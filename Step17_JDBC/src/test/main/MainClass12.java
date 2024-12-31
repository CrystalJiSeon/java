package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass12 {
	public static void main(String[] args) {
		//삭제할 회원 정보
		int num = 2;
		
	
		//미리 준비된 메소드를 이용해서 DB에 저장하고 성공여부를 리턴받기
		boolean isSuccess=delete(num);
		if(isSuccess) {
			System.out.println("수정했습니다");
		}else {
			System.out.println("수정하지 못했습니다");
		}
	}
	
	//매개변수로 전달되는 회원의 번호를 이용해서 회원 한명의 정보를 삭제하고 성공여부를 리턴하는 메소드
	public static boolean delete(int num) {
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
						delete from member
						where num=?
					""";
			//미완성의 sql 문을 전달하면서 PreparedStatement객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setInt(1,	num);
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
