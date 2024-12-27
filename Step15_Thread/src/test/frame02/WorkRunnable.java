package test.frame02;
/*
 * 새로운 스레드 만드는 방법2
 * 1. Runnable 인터페이스를 구현한 클래스를 정의하기
 * 2. run()메소드를 강제 오버라이드하기
 * 3. Thread 클래스로 객체를 생성하면서 해당 클래스로 만든 객체를 생성자의 인자로 전달하기
 * 4. Thread 클래스로 만든 객체의 start() 메소드를 호출해서 스레드를 시작시키기 * 
 */
public class WorkRunnable implements Runnable{//1.

	@Override
	public void run() {
		System.out.println("10초 소요 작업의 시작");
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("작업 종료");
	}

}
