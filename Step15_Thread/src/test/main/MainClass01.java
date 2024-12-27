package test.main;

public class MainClass01 {
	public static void main(String[] args) { //실행의 흐름을 스레드라고 하고, run 했을 때 실행되는 흐름은 main 스레드라고 함.
		System.out.println("메인 메소드가 시작되었습니다");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test();
		System.out.println("메인 메소드가 종료됩니다");
	}
	
	public static void test() {
		System.out.println("test() 메소드 호출됨");
	}
}
