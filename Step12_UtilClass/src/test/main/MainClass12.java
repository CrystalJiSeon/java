package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass12 {
	public static void main(String[] args) {
		Map<String, String> map1 = new HashMap<>();
		map1.put("house", "집");
		map1.put("phone", "전화기");
		map1.put("watch", "시계");
		
		Map<String, String> map2= Map.of("house", "집", "phone", "전화기", "watch", "시계");
		
		// map2.put("mouse", "쥐");//추가 불가
		// map2.remove("watch"); // 삭제 불가
	}
}
