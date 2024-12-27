package test.frame03;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame0 extends JFrame {
	//생성자
	public MyFrame0() {
		//프레임 제목
		this.setTitle("나의 프레임");
		//프레임 위치와 크기 설정 setBounds(x, y, width, height)
		setBounds(100,100,500,500);
		//종료 버튼을 눌렀을 때 프로세스 전체가 종료되도록 하기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//레이아웃 메니저 객체 생성
		FlowLayout layout =new FlowLayout(FlowLayout.LEFT);
		//프레임의 레이아웃 메니저 설정
		setLayout(layout);
		//JButton 객체 생성
		JButton btn1=new JButton("버튼1"); 
		//프레임의 add()메소드를 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치됨
		add(btn1);
		//화면상에 실제 보이도록 하기
		setVisible(true);
	}
	//main 메소드
	public static void main(String[] args) {
		new MyFrame0();
	}
}