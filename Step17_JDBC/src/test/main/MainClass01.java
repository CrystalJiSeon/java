package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * 자바로 오라클에 scott/TIGER 계정으로 접속해서 
		 * 모든 사원의 사원 번호, 사원이름, 직업, 급여를 사원이름의 내림차순 정렬로 Select 한 후
		 * 콘솔창에 출력하기 
		 */
		//이걸 하려면 오라클 DB에 접속할 수 있는 jar 파일이 필요함
		//DB 연결객체를 담을 지역 변수 만들기
		Connection conn=null;
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 의 정보 @아이피주소:port번호:db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "TIGER");
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역 변수 미리 만들기
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try {
			//실행할 sql 문을 미리 준비하기//따옴표 세개는 백틱과 동일한 기능이라고 생각하면 됨//단 여기서 셀렉트 문 마지막에 세미콜론 붙이면 안됨//옛날 버전에서는 ""엔터 +""엔터+""로 작성했음
			String sql="""
					Select empno, ename, job, sal
					from emp
					order by empno ASC
					""";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt= conn.prepareStatement(sql);
			//Select 문 실행하고 결과값을 resultset으로 얻어내기//Select가 아니면 ResultSet을 만들 필요가 없다.
			rs=pstmt.executeQuery();
			//반복문 돌면서
			while(rs.next()) {
				int empno =rs.getInt("empno");
				String ename=rs.getString("ename");
				String job= rs.getString("job");
				double sal = rs.getDouble("sal");
				System.out.println(empno+"|"+ename+"|"+job+"|"+sal);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
