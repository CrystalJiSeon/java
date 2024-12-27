package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizMain2 {
	public static void main(String[] args) {
		//1. 로또 번호 담을 HashSet 객체 생성해서 set1이라는 지역 변수에 담기
		Set<Integer> set1 = new HashSet<>();
		//2. while 문을 이용해서 랜덤한 로또 번호를 set1에 반복적으로 담아 보세요.
		//while문 탈출 조건은 set1.size()가 6이 되면 탈출되도록 해보기
		Random ranlot = new Random();
		while (true) {
			for(int i=0; i<set1.size(); i++) {
				//1~45 사이의 랜덤한 숫자를 얻어서
				int nums =ranlot.nextInt(45)+1;
				//Set 객체에 담는다
				set1.add(nums);	
			}
			//만일 Set의 크기가 6이면 
			if (set1.size()==6) {
				break;//반복문 탈출
				
			}
		}
		
		//3. set1에 담긴 번호를 오름 차순으로 정렬해서 콘솔창에 모두 출력해보세요
		List<Integer> number = new ArrayList<>(set1);
		Collections.sort(number);
		for(Integer tmp:number) {
			System.out.println(tmp);
		}
		
		
	}
}
