package test.frame03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParsePosition;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.html.parser.Parser;

public class MyFrame3 extends JFrame implements ActionListener {
	//myframe의 필드에 선언하면 어디서든 가져다 쓸 수 있다, 객체내에서 공유할 자원들을 담아 두는 곳
	int count=0;
	JButton countBtn;
	//생성자
	public MyFrame3() {
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
		this.countBtn=new JButton("0"); 
		//프레임의 add()메소드를 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치됨
		add(countBtn);
		//버튼에 전달할 addActionListener라는 인터페이스 타입 
		//어떤클래스에 implements 하기/
		
		//final int count=0; 여기 선언하면 지역 변수 생성자가 생성되면 사라짐

		//countBtn.addActionListener(this); this를 쓰면 ActionListener 타입이 아니기 때문에 에러가 난다. 
		//this가 가리키는 것은 MyFrame3 클래스 또는 JFrame 클래스 또는 Object이기도 하다.
		//this를 써서 구현해보기(JFrame에서 implement 하고 MyFrame에 오류난거 해결)
		countBtn.addActionListener(this);
		//이제 하단에서 override 된 내용이 버튼을 누를 때마다 실행된다는 의미
		
		//화면상에 실제 보이도록 하기
		setVisible(true);
	}
	//main 메소드
	public static void main(String[] args) {
		new MyFrame3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼을 눌렀네?");
		count++;
		countBtn.setText(Integer.toString(count));
		
	}
}