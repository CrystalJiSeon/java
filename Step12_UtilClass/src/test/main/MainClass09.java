package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		//1. 세명의 회원정보(번호,이름,주소)를 해쉬맵 객체를 생성해서 담아보세요
		//HashMap 객체 하나당 한명의 회원정보를 담으니깐 총 3개의 Hashmap 객체가 생성돼야 함.
		Map<String, Object> mem1 = new HashMap<>();
		mem1.put("num",1);
		mem1.put("name", "하나");
		mem1.put("addr", "서울");
		HashMap<String, Object> mem2 = new HashMap<>();
		mem2.put("num",2);
		mem2.put("name", "두울");
		mem2.put("addr", "경기");
		HashMap<String, Object> mem3 = new HashMap<>();
		mem3.put("num",3);
		mem3.put("name", "사미");
		mem3.put("addr", "대구");
		
		//2. 위에서 생성한 HashMap 객체를 담을 ArrayList 객체를 생성해보세요
		ArrayList<Map<String, Object>> members = new ArrayList<>();
		//3. ArryList 객체에 Hashmap 객체 3개를 담아보세요
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		//4. 반복문 돌면서 ArrayList에 담긴 회원정보를 콘솔창에 보기 좋게 출력해보세요.
		for (Map<String, Object> tmp : members) {
			String info=String.format("번호: %d, 이름:%s, 주소:%s", tmp.get("num"), tmp.get("name"), tmp.get("addr"));
			System.out.println(info);
		}
		
	}
}
