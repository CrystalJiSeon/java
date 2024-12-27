package test.main;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		//인삿말을 담을 ArrayList 객체를 생성해서 참조값을 greets라는 지역변수에 대입하기
		ArrayList<String> greets = new ArrayList<>();
		
		//greets에 들어 있는 참조값을 이용해서 인사말 3개를 임의로 담기
		greets.add(0, "안녕");
		greets.add(1, "반가워");
		greets.add("Hello");
		//확장 for 문을 이용해서 모든 인사말을 콘솔창에 순서대로 출력해보세요
		for (String tmp: greets) {
			System.out.println(tmp);
		}
	
		System.out.println("------------");
		
		Consumer<String> con = new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				// 매개 변수에 전달되는 item을 가지고 어떤 작업을 할지 여기에 코딩하면 됨
				System.out.println(t);
			}
		};
		
		/*
		 * ArrayList 객체의 forEach()메소드를 호출하면서 Consumertype 객체를 전달하면 
		 * 전달된 객체의 accept()메소드를 호출하면서
		 * ArrayList 객체에 저장된 item을 순서대로 매개 변수에 전달.
		 */
		greets.forEach(con);
	
	}
}
