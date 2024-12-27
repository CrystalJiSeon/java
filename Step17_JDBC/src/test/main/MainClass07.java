package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.EmpDto;
import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass07 {
	public static void main(String[] args) {
		//사원 목록을 아주 쉽게 얻어낼수 있다 (날로 먹을수 있다)
		List<EmpDto> list=getList();
		for(EmpDto tmp:list) {
			System.out.printf("이름:%s, 번호:%d, 직무:%s, 급여:%f \r\n", 
					tmp.getEname(), tmp.getEmpno(), tmp.getJob(), tmp.getSal());
		}
	}
	
	//미리 준비된 메소드가 있다고 가정하면 
	public static List<EmpDto> getList(){
		
		//리턴해줄 객체를 미리 생성하기
		List<EmpDto> list=new ArrayList<>();
		
		//여기에 어떻게 코딩하면 회원 목록(List<MemberDto>) 를 리턴해줄수 있을까? 코딩해 보세요.
		//필요한 객체를 담을 지역변수 미리 준비
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn=new DBConnector().getConn();
			String sql="""
				SELECT ename, empno, job, sal
				from emp
			""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String ename=rs.getString("ename");
				int empno=rs.getInt("empno");
				String job=rs.getString("job");
				double sal=rs.getDouble("sal");
				//select 된 row 하나의 정보를 MemberDto 객체에 담는다.
				EmpDto dto=new EmpDto();
				dto.setEname(ename);
				dto.setEmpno(empno);
				dto.setJob(job);
				dto.setSal(sal);
				//사원 한명의 정보가 담긴 MemberDto 객체를 ArrayList 객체에 누적 시킨다.
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}


