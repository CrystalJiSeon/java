package test.main;

import java.util.ArrayList;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		//1. MemberDto 객체를 담을 수 있는 어레이리스트 객체를 생성해서 참조값을 members라는 지역변수에 담기
			ArrayList<MemberDto> members = new ArrayList<>();
		
		//2. 3명의 회원정보를 memberDto 객체에 각각 담기(memberdto 객체가 3개 필요)
			MemberDto m1 = new MemberDto(1, "하나", "서울");
			MemberDto m2 = new MemberDto(2, "두리", "경기");
			MemberDto m3 = new MemberDto(3, "사미", "부산");
			
			
		//3. 위에서 생성된 memberDto 객체의 참조값을 arraylist객체에 모두 담기
			members.add(m1);
			members.add(m2);
			members.add(m3);
			
			
		//4. 반복문을 이용해서 members에 들어있는 회원정보 출력하기
		
			for (MemberDto tmp: members) {
				String info = String.format("번호:%d, 이름:%s, 주소:%s", tmp.getNum(), tmp.getName(), tmp.getAddr());
				System.out.println(info);
			}
			
		//테스트 메소드 호출 : 매개변수에 전달할 스트링 타입의 개수가 유동적이다.
			test();
			test("kim");
			test("kim", "lee", "park");
			
	}
	//테스트
	public static void test(String... msgs) {
		//String...은 String[]type이다
		String[] a=msgs; 
	}
	
}
