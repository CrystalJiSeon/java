package test.main;

import java.util.ArrayList;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type을 저장할 수 있는 ArrayList 객체를 생성해서
		//참조값을 arrayList 인터페이스 type 지역 변수 cars에 담기
		ArrayList<Car> cars = new ArrayList<>(); 
		//2. Car 객체(3개)를 생성해서 ArrayList 객체에 저장하기
		Car car1 = new Car("기아");
		Car car2 = new Car("벤츠");
		cars.add(car1);
		cars.add(car2);
		cars.add(new Car("현대"));
		
		//3. 일반 for 문을 이용해서 array List 객체에 저장된 모든 Car 객체의 drive()메소드를 순서대로 호출하기
		for (int i=0; i<cars.size(); i++) {
			Car tmp= cars.get(i);
			tmp.drive();
		}
		//4. 확장 for 문을 이용해서 array list 객체에 저장된 모든 car 객체의 drive 메소드를 순서대로 호출하기
		for(Car tmp:cars) {
			tmp.drive();
		}
		//5. arraylist 객체의 forEach()메소드를 이용해서 arraylist 객체에 저장된 모든 car 객체의 drive()메소드를 순서대로 호출하기
		cars.forEach((tmp->{tmp.drive();}));	
	}
	
}
