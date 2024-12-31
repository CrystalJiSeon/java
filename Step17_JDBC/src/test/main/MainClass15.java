package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass15 {
	public static void main(String[] args) {
		/*
		 * MemberDao 객체를 이용해서 1번 회원의 이름을 "김구라", 주소를 "노량진"으로 수정하기
		 * 단) 성공 여부를 콘솔창에 출력하기
		 */
	
		MemberDto dto=new MemberDto();
		dto.setName("김구라");
		dto.setAddr("노량진");
		dto.setNum(1);
		
		MemberDao dao=new MemberDao();
		boolean isSuccess = dao.update(dto);
		if(isSuccess) {
			System.out.println("정보가 수정되었습니다.");
		}else {
			System.out.println("정보를 수정할 수 없습니다.");
		}
	}
}
