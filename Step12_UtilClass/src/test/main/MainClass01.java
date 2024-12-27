package test.main;

import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		//java에서 배열은 용도가 한정되어 있다. item을 담을 수 있는 공간을 늘리거나 줄일 수 없다.
		
		//문자열(String) type을 담을 수 있는 방 5개 짜리 배열 객체 생성
		String[] names =new String[5];
		names[0]= "name1";
		names[1]= "name2";
		names[2]="name3";
		ArrayList<String> friends = new ArrayList<>();
		//이름 3개를 순서대로 담아 보기
		friends.add(0, "name1");
		friends.add(1, "name2");
		friends.add(2, "name3");
		//0번방의 아이템을 불러와서 item이라는 변수에 담기
		String item = friends.get(0);
		//1번 방의 아이템을 삭제
		friends.remove(1);
		//0번 방에 "acorn" 끼워넣기
		friends.add(0, "acorn");
		//저장된 아이템의 갯수(size)를 size라는 지역 변수에 담기
		int size = friends.size();
		//저장된 모든 아이템 전체 삭제
		//friends.removeAll(friends);
		friends.clear();
	}
}
