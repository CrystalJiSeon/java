package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass16 {
	public static void main(String[] args) {
	/*
	 *MemberDao 객체를 이용해서 1번 회원의 정보를 삭제하기
	 *단, 성공 여부를 콘솔창에 출력하세요 
	 */
	
		
		MemberDao dao=new MemberDao(); //대신에 var dao라고 선언할 수도 있다(타입 추론이 가능해서)
		boolean isSuccess = dao.delete(1);//대신에 var isSuccess라고 선언할 수도 있다(타입 추론이 가능해서)
		if(isSuccess) {
			System.out.println("회원정보를 삭제했습니다");
		}else {
			System.out.println("회원정보를 삭제할 수 없습니다.");
		}
	
	}
}
