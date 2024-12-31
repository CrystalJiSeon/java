package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass10 {
	public static void main(String[] args) {
		//추가할 회원 정보라고 가정하자
		String name="이름1";
		String addr="노량진";
		
		//추가할 회원정보를 MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//미리 준비된 메소드를 이용해서 DB에 저장하고 성공여부를 리턴받기
		boolean isSuccess=insert(dto);
		if(isSuccess) {
			System.out.println("저장했습니다");
		}else {
			System.out.println("저장하지 못했습니다");
		}
		
	}
	//매개변수에 전달된 MemberDto 객체에 담긴 name과 addr을 DB에 저장하고
	//작업의 성공여부를 리턴하는 메소드
	public static boolean insert(MemberDto dto) { //리턴 값이 boolean이라서 boolean 값이 나오기 전까지는 에러가 난 상태
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
						Insert into member
						(num, name, addr)
						values(member_seq.Nextval, ?, ?)
					""";
			//미완성의 sql 문을 전달하면서 PreparedStatement객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
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
