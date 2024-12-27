package test.main;

import java.util.HashMap;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * HashMap<key type, value type>
		 * 
		 * key type은 일반적으로 String type을 가장 많이 사용함
		 * value type은 담고 싶은 데이터의 type을 고려해서 저장하면 됨
		 * value type을 object로 지정하면 어떤 데이타타입이던지 다 담을 수 있음
		 * 순서가 없는 데이터를 다룰 때 사용하면 됨
		 * dto클래스 대신에 사용하기도 함
		 */
		HashMap<String, Object> map=new HashMap<>();
		map.put("num",1);
		map.put("name", "김구라");
		map.put("isMan", true);

		//value의 generic 클래스가 Object 이기 때문에 object 타입이 리턴된다.
		int num=(int)map.get("num");//원래 타입으로 캐스팅이 필요
		String name =(String)map.get("name");
		boolean isMan = (boolean)map.get("isMan");

		//동일한 key 값으로 다시 담으면 수정
		map.put("name", "이정호" );
		//특정 key 값으로 담긴 내용 삭제
		map.remove("isMan");
		//모두 삭제
		map.clear();
	}
}
