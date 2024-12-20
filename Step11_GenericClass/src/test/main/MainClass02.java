package test.main;

import test.mypac.Apple;
import test.mypac.Pear;

public class MainClass02 {
	public static void main(String[] args) {
		
		
		/*
		 * key 값을 어떤 타입으로 설정할지?
		 * value값을 어떤 타입으로 설정할지?
		 * 위 두개를 결정해서 2가지 generic 클래스를 지정해야 함.
		 */
		//우리가 직접 generic 클래스를 쓸 일은 없지만 이미 만들어진걸 적절하게 사용할줄 알아야 한다.
		//Integer라는 포장을 씌워줘야지 int를 쓰면 int가 기본 데이터 타입이라서 에러가 난다.
		Pear<String, Integer> p1= new Pear<>("one", 100);
		String k1=p1.getKey();
		Integer v1=p1.getValue();
		
		Pear<String, Apple> p2= new Pear<>("two", new Apple());
		String k2=p2.getKey();
		Apple v2= p2.getValue();
		
	}
}
