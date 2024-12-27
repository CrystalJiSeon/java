package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.util.DBConnector;

public class MainClass08 {
	public static void main(String[] args) {
		//부서 목록을 아주 쉽게 얻어낼수 있다 (날로 먹을수 있다)
		List<DeptDto> list=getList();
		for(DeptDto tmp:list) {
			System.out.printf("부서번호:%d, 부서이름:%s, 지역:%s \r\n", 
					tmp.getDeptno(), tmp.getDname(), tmp.getLoc());
		}
	}
	
	//미리 준비된 메소드가 있다고 가정하면 
	public static List<DeptDto> getList(){
		
		//리턴해줄 객체를 미리 생성하기
		List<DeptDto> list=new ArrayList<>();
		
		//여기에 어떻게 코딩하면 회원 목록(List<DeptDto>) 를 리턴해줄수 있을까? 코딩해 보세요.
		//필요한 객체를 담을 지역변수 미리 준비
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn=new DBConnector().getConn();
			String sql="""
				SELECT deptno, dname, loc
				from dept
			""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int deptno=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				//select 된 row 하나의 정보를 DeptDto 객체에 담는다.
				DeptDto dto=new DeptDto();
				dto.setDeptno(deptno);
				dto.setDname(dname);
				dto.setLoc(loc);
			
				//부서의 정보가 담긴 DeptDto 객체를 ArrayList 객체에 누적 시킨다.
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
