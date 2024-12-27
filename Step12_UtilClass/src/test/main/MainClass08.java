package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass08 {
	public static void main(String[] args) {
		//hashmap 객체를 생성해서 map 인터페이스 타입 변수에 담기
		Map<String, String> dic = new HashMap<>();
		//key:value의 쌍을 사전형태(dictionary)라고도 함
		dic.put("house", "집");
		dic.put("phone", "전화기");
		dic.put("watch", "시계");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("단어입력:");
		String word=scan.nextLine();
		
		//단어에 해당하는 뜻 얻어내기
		String mean=dic.get(word);
		if (mean==null) {
			System.out.println("찾는 단어가 없습니다.");
		}else {
		//출력하기
		System.out.println(word+"의 뜻은 " +mean+"입니다.");
		}
		
		
	}
}
