package test.main;

import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("나눌 수 입력:");
		String inputNum1=scan.nextLine();
		
		System.out.println("나누어지는 수 입력");
		String inputNum2=scan.nextLine();
		try {
			//문자열 형태의 숫자를 실제 정수로 변경하기
			int num1=Integer.parseInt(inputNum1);
			int num2=Integer.parseInt(inputNum2);
			//계산하기
			int result = num2/num1;//몫
			int result2= num2%num1;//나머지
			System.out.println(num2+"를 "+num1+"으로 나눈 몫 : "+result);
			System.out.println(num2+"를 "+num1+"으로 나눈 나머지 : "+result2);
		}catch(Exception e) {
			//Exception은 모든 예외의 부모 type이기 때문에 어떤 예외가 발생해도 이부분이 실행된다
			System.out.println("예외가 발생했습니다.");
			System.out.println("예외 메세지: "+e.getMessage());
		}finally {
			//예외 발생 유무와 관계 없이 무조건 실행되는 부부분
			//이곳은 예외가 발생하건 안하건 반드시 실행이 보장되는 부분으로, 중요한 마무리 작업을 주로 여기서 수행한다.
			System.out.println("중요한 마무리 작업을 하는 중입니다.");
		}
		System.out.println("main 메소드가 정상 종료됩니다");
	}
}
