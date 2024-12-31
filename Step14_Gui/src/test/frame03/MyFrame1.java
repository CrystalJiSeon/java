package test.frame03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParsePosition;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.html.parser.Parser;

public class MyFrame1 extends JFrame {
	//myframe의 필드에 선언하면 어디서든 가져다 쓸 수 있다
	int count=0;
	//생성자
	public MyFrame1() {
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
		JButton countBtn=new JButton("0"); 
		//프레임의 add()메소드를 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치됨
		add(countBtn);
		//버튼에 전달할 addActionListener라는 인터페이스 타입 
		//어떤클래스에 implements 하기/
		
		
		//final int count=0; 여기 선언하면 지역 변수 생성자가 생성되면 사라짐
		
		ActionListener listener=new ActionListener() {
			//필드 : 이 객체 안에서만 사용할 수 있다.
			int count=0;
			@Override
			public void actionPerformed(ActionEvent e) {
				// button에 어떤 액션이 일어나면 이 메소드가 자동으로 호출된다는 의미
				//이 안에다가 코딩하면 버튼을 누를때마다 호출되는 동작을 작성할 수 있다.
				System.out.println("버튼을 눌렀습니다");
				//카운트를 1증가 시키고
				count++;
				//정수를 문자열로 변경한 다음 setText()메소드에 전달함
				countBtn.setText(Integer.toString(count));
			}
			
		};
		countBtn.addActionListener(listener);
		
		//화면상에 실제 보이도록 하기
		setVisible(true);
	}
	//main 메소드
	public static void main(String[] args) {
		new MyFrame1();
	}
}