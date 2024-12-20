package test.main;

import test.mypac.Calc;

public class MainClass05 {
	public static void main(String[] args) {
		Calc c1 =new Calc() {
			
			@Override
			public double execute(double num1, double num2) {
				// TODO Auto-generated method stub
				return 0;//더블 타입을 리턴해주기로 했는데 안 해주면 오류남
			}
		};
		//Calc c2 = ()->{};이렇게 쓰면 오류나는게 매개변수랑 리턴값이 없어서 오류남
		Calc c2 = (double a, double b)->{
			return 0;
		};
		//매개변수의 타입은 생략 가능하다
		Calc c3= (a, b)->{
			//return 예약어 이전에 coding 된 내용이 없음
			return 0;
		};
		//return 예약어 이전에 coding 된 내용이 없으면 {}생략 가능
		Calc c4=(a, b)->0;// 리턴할 값만 명시하면 되기 때문에 return 예약어도 사용하지 않음
		
		//매개변수에 전달된 두 숫자를 더한 값을 리턴하는 동작
		Calc plus = (a, b)->a+b;//이런 한줄짜리 간단한 코드를 람다 함수라고 얘기함
		//매개변수에 전달된 두 숫자를 뺀 값을 리턴하는 동작
		Calc minus = (a, b)->a-b;
		//매개변수에 전달된 두 숫자를 곱한 값을 리턴하는 동작
		Calc multiple = (a,b)->a*b;
		//매개변수에 전달된 두 숫자를 나눈 값을 리턴하는 동작
		Calc divide = (a, b)->a/b;
		
		double result1=plus.execute(10,10);//20
		double result2=minus.execute(10,10);//0
		double result3=multiple.execute(10, 10);//100
		double result4=divide.execute(10, 10);//1
		
	}
}
