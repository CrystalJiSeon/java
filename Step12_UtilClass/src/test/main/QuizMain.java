package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizMain {
	public static void main(String[] args) {
		//1. 정수를 담을 수 있는 어레이 리스트 객체를 생성해서 nums 라는 지역변수에 담기
			ArrayList<Integer> nums = new ArrayList<>();
		//2. 반복문 10번 돌면서 1~100 사이의 랜덤한 정수를 각각 얻어내서 1에서 생성한 nums 객체에 순서대로 담기
			//랜덤한 정수를 얻어낼 객체
			Random ran = new Random();
			//반복문을 10번돌도록 구성
			for (int i=0; i<10;i++) {
				//1~100 사이의 랜덤한 정수 얻기
				int ranNum= ran.nextInt(100)+1;
				nums.add(ranNum);
			}
		
		//3. nums에 저장된 숫자에서 중복된 숫자가 제거된 새로운 ArrayList 객체를 얻어내 보기
			/*Set<Integer> set= new HashSet<>();
			//set 객체에 숫자를 넣으면 중복이 제거된다
			nums.forEach((item)->{set.add(item);});
			//중복이 제거된 Set를 이용해서 다시 arraylist 객체 생성
			List<Integer> result=new ArrayList<>(set);*/
			Set<Integer> set= new HashSet<>(nums);
			List<Integer> result=new ArrayList<>(set);
		//4. 새로운 배열에 숫자를 오름차순으로 정렬해보기
			Collections.sort(result);
		//5. 새로운 배열에 저장된 숫자를 순서대로 콘솔창에 출력해보기
			result.forEach((item)->{System.out.println(item);});
	}
}
