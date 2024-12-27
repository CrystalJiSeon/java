package test.main;

public class QuizMain {
	
/*
 * run 했을 때 콘솔창에 1,2,3... 경과시간을 출력하다가 종료되는 코드
 * hint = >Thread.sleep(1000);
 */
	public static void main(String[] args) throws InterruptedException {
		for(int i=0; i<10; i++) {
			int second = i+1;
			Thread.sleep(1000);
			System.out.println(second+"초");
		}
		Thread.sleep(1000);
		System.out.println("10초가 지났습니다. 종료되었습니다");
	}
}
