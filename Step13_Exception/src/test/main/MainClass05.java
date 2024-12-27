package test.main;

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("메인메소드가 시작되었습니다");
		
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//스레드(실행의 흐름)를 일정시간 지연 시키기(mili second 단위로 숫자를 전달하면 됨)
		
		System.out.println("메인메소드가 종료되었습니다.");
		
	}
}
