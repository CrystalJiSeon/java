package test.frame03;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {
	//생성자
	public MyFrame2(String title) {
		super(title);
		setLayout(new FlowLayout());

		
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
			new Thread(()->{//여기가 run 메소드 안에서 할 작업을 코딩하면 되는 곳
				System.out.println("10 소요 작업");
				try {
					Thread.sleep(1000*10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("작업 종료됨");
			}).start();
		});
	}
	//run 했을 때 실행의 흐림이 시작되는 메인 메소드
	public static void main(String[] args) {
		var frame=new MyFrame2("나의 프레임");
		//MyFrame 객체 안에서 this.으로 호출했던 메소드를
		//객체 외부에서는 참조값에 .을 찍어서 호출할 수 있다.
		frame.setBounds(100,100, 300,300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
