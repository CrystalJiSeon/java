package test.mypac;

//@으로 시작하는 표시들은 어노테이션이라고 한다
@FunctionalInterface//추상 메소드를 1개만 만들도록 강제하는 역할을 함 그래서 ()->{}형태로 사용할 수 있도록 보장함
public interface Calc {
	//어떤 연산을 할지는 개발자가 알아서 정하기
	public double execute(double num1, double num2);
	// public void test(); 이 밑에 줄을 만들면 Calc에 오류 뜸
}
