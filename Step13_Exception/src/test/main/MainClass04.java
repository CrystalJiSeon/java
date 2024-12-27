package test.main;

public class MainClass04 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("메인메소드가 시작되었습니다");
		

			Thread.sleep(1000*5);//스레드(실행의 흐름)를 일정시간 지연 시키기(mili second 단위로 숫자를 전달하면 됨)
		
		System.out.println("메인메소드가 종료되었습니다.");
		
	}
}
