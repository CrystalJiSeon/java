package test.frame01;
/*
 * 새로운 스레드를 만드는 방법
 * 1. Thread 클래스를 상속 받은 클래스를 정의함 extends Thread
 * 2. run()메소드를 오버라이드
 * 3. run()메소드 안에서 새로운 스레드에서 작업할 내용을 코딩
 * 4. 만든 클래스로 객체를 생성하고 해당 객체의 start()메소드를 호출하면 새로운 스레드가 시작됨
 * 		new WorkThread().start();
 */
public class WorkThread extends Thread {//1.
	@Override
	public void run() {
		//새로운 스레드에서 해야할 작업을 run() 메소드 안에서 시작한다.
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
