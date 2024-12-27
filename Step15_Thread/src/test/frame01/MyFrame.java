package test.frame01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	//생성자
	public MyFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		//this.setBounds(100,100,300,300); //얘 대신에 맨 아래처럼 쓸 수 있다.
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);//얘도 맨 아래처럼 쓸 수 있음
		/*
		 * type 추론이 가능하다면 지역 변수의 type 선언 대신에 var로 변수를 선언할 수 있다.
		 * java 10에서 추가된 문법이고, 진부한 코딩을 줄이기 위한 문법이라고 함.
		 * 다만, 아직도 실무에서는 1.8버전을 쓰는 곳이 많으니까 주의하기.
		 * 지역변수에만 사용가능하고 필드에는 사용 불가, 인터페이스는 type 추론이 불가함.
		 * null로 초기화가 불가능함.
		 */
		
		var num=10;
		var name="kim";
		var isRun=true;
		
		
		var startBtn=new JButton("작업시작");
		add(startBtn);
		var startBtn2=new JButton("작업시작2");
		add(startBtn2);
		startBtn.addActionListener((e)->{
			System.out.println("10 소요 작업");
			try {
				Thread.sleep(1000*10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("작업 종료됨");
		});
		startBtn2.addActionListener((e)->{
			//WorkThread 클래스로 객체를 생성해서 참조값을 얻어낸 다음
			WorkThread t=new WorkThread();
			//start() 메소드를 호출해서 새로운 스레드가 시작되도록 한다.
			//그럼 start() 메소드를 통해 run()메소드가 호출되면서 자연스럽게 실행된다.
			t.start();
		});
	}
	//run 했을 때 실행의 흐림이 시작되는 메인 메소드
	public static void main(String[] args) {
		var frame=new MyFrame("나의 프레임");
		//MyFrame 객체 안에서 this.으로 호출했던 메소드를
		//객체 외부에서는 참조값에 .을 찍어서 호출할 수 있다.
		frame.setBounds(100,100, 300,300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
