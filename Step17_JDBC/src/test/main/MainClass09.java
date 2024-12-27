package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.EmpDeptDto;
import test.util.DBConnector;

public class MainClass09 {
	public static void main(String[] args) {
		//부서 목록을 아주 쉽게 얻어낼수 있다 (날로 먹을수 있다)
		List<EmpDeptDto> list=getList();
		for(EmpDeptDto tmp:list) {
			System.out.printf("사원번호:%d, 사원이름:%s, 부서번호:%d, 부서 이름:%s \r\n", 
					tmp.getEmpno(), tmp.getEname(), tmp.getDeptno(), tmp.getDname());
		}
	}
	
	//미리 준비된 메소드가 있다고 가정하면 
	public static List<EmpDeptDto> getList(){
		
		//리턴해줄 객체를 미리 생성하기
		List<EmpDeptDto> list=new ArrayList<>();
		
		//여기에 어떻게 코딩하면 회원 목록(List<DeptDto>) 를 리턴해줄수 있을까? 코딩해 보세요.
		//필요한 객체를 담을 지역변수 미리 준비
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn=new DBConnector().getConn();
			String sql="""
				SELECT empno, ename, deptno, dname
				from emp
				join dept using (deptno)
			""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int deptno=rs.getInt("deptno");
				String dname=rs.getString("dname");//dname 대신 별칭을 줬다면 여기도 별칭으로 바뀌어야 함
				//select 된 row 하나의 정보를 DeptDto 객체에 담는다.
				EmpDeptDto dto=new EmpDeptDto();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setDeptno(deptno);
				dto.setDname(dname);
			
				//부서의 정보가 담긴 DeptDto 객체를 ArrayList 객체에 누적 시킨다.
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
