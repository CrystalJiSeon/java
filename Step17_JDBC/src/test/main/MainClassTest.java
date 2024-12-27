package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClassTest {
	public static void main(String[] args) {
		
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "TIGER");
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			
			String sql="""
					Select deptno, dname, loc
					from dept
					""";
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int deptno =rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc= rs.getString("loc");
				System.out.println(deptno+"|"+dname+"|"+loc);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------------------------------");
		//2. 사원번호, 사원이름, 부서번호, 부서명을 사원번호에 대해 내림차순 정렬하기
		try {
				String sql="""
						Select empno,ename, deptno, dname
						from emp
						join dept using (deptno)
						order by empno DESC
						""";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					int empno=rs.getInt("empno");
					String ename= rs.getString("ename");
					int deptno=rs.getInt("deptno");
					String dname=rs.getString("dname");
					System.out.println(deptno+"|"+ename+"|"+deptno+"|"+dname);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
