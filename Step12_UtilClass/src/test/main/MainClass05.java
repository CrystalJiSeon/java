package test.main;


import java.util.ArrayList;
import java.util.List;

import test.mypac.Member;//패키지명 잘 보고 import 하기

public class MainClass05 {
	public static void main(String[] args) {
		//1. member 객체를 담을수있는 어레이리스트 객체를 생성해서 참조값을 members 라는 List type 지역변수에 담아 보세요.
		List<Member> members = new ArrayList<Member>();
		//2.3명의 회원정보를 멤버 객체에 각각 담으세요(멤버 객체 3개가 생성)
		Member mem1 = new Member(1, "하나", "서울");
		Member mem2 = new Member(2, "두리", "경기");
		Member mem3 = new Member(3, "사미", "부산");
			
		//3. 위 멤버 객체의 참조값을 List 객체에 모두 담기
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		/*
		 * 4. members 리스트 객체에 담긴 애용을 이용해서 회원 목록을 아래와 같은 형식으로 반복문을 돌면서 출력하기
		 * 번호: 1, 이름: 김구라, 주소: 노량진
		 * 번호: 2, 이름:해골, 주소 : 행신동
		 *  
		 */
		members.forEach((tmp)->{System.out.println("번호: "+tmp.num + ",  이름:" + tmp.name + ",  주소: "+ tmp.addr);});
		
		/*
		 * for (Member tmp:members){
		 *	//String 클래스의 format()이라는 static 메소드를 이용해서 원하는 문자열 형식을 만든 다음
		 * 	String info = String.format("번호:%d, 이름:%s, 주소: %s", tmp.num, tmp.name,tmp.addr);
		 *	//콘솔창에 출력하기
		 *  System.out.println(info);
		 * }
		 */
			
			
			
	}
}
