package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener{
	//필요한 필드 정의하기
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table;
	//생성자
	public MemberFrame(String title) {
		super(title);
		//레이아웃 설정
		setLayout(new BorderLayout());
		//JLabel 2개
		JLabel label2= new JLabel("이름");
		JLabel label3= new JLabel("주소");
		//JTextField 1개
		inputName = new JTextField(10);
		inputAddr = new JTextField(10);
		//JButton
		JButton addBtn=new JButton("추가");
		JButton deleteBtn=new JButton("삭제");
		//패널에 UI 배치(add는 패널의 메소드)
		JPanel panel =new JPanel();
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		//패널의 배경색 설정
		panel.setBackground(Color.orange);
		//패널을 프레임의 위쪽에 배치
		add(panel, BorderLayout.NORTH);
		
		//버튼에 액션 리스너 등록
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		//버튼에 액션 command 설정
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		//회원 목록을 출력할 테이블-> 필드로 뽑는다 ->여기 있던 JTable table에 대해 앞의 JTable을 지워준다
		table=new JTable();
		//테이블의 칼럼명을 배열로 미리 준비한다
		String[] colNames= {"번호", "이름", "주소"};
		//테이블에 연결할 모델 객체
		model =new DefaultTableModel(); //생성자에서 생성된 이 객체의 참조값이 다른 메소드에서도 필요한 상황 -> 이 값을 지역 변수가 아닌 필드로 옮기기
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0);
		
		//모델을 테이블에 연결
		table.setModel(model);
		//스크롤이 가능하도록 테이블을 JScrollPane에 감싼다
		JScrollPane scroll=new JScrollPane(table);
		//JScrollPnae을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
		
		//프레임 객체가 생성되는 시점에 DB에 있는 내용을 읽어와서 출력할 수 있게 해준다.
		//JTable에 출력할 sample row 데이터
		//Object[] row= {1, "글린다", "오즈"};
		//테이블에 연결된 모델에 row 추가하기
		//model.addRow(row);
	
		
		printMember();
		//테이블에 출력할 회원 목록 얻어오기
		//MemberDao dao = new MemberDao();
		//List<MemberDto> list= dao.getList();
		//반복문 돌면서
		//for (MemberDto tmp:list ) {
			//MemberDto 객체에 담긴 회원정보를 이용해서 Object[] 에 담은 다음
			//Object[] rowData = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			//테이블에 연결된 모델에 추가하기
			//model.addRow(rowData);
		//}
		
		
		//칼럼의 제목 글자 조정
		table.getTableHeader().setFont(new Font("Sans-serif", Font.BOLD, 18));
		table.setFont(new Font("Sans-serif", Font.PLAIN,16));//데이터 글자 크기 14
		table.setRowHeight(25);//각 행의 높이를 조정
		
	}//생성자 : 프레임 객체가 생성되는 시점에 만들어짐 
	
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원 정보 관리");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//가독성 좋게+부모자식이라 JFrame.생략하고 
		f.setBounds(100,100,800,500);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command를 읽어온다
		String command=e.getActionCommand();
		if(command.equals("add")) {//java 에서는 문자열 비교를 .equals()메소드를 이용해서 비교해야 한다.  (자바스크립트에서는 command =="add")
			//입력한 이름과 주소를 읽어 온다
			String name=inputName.getText();//this. 이 생략되어 있는데 JTextField의 참조값이 필드에 저장되어 있어서 생략됨
			String addr=inputAddr.getText();//this. 이 생략되어 있는데 JTextField의 참조값이 필드에 저장되어 있어서 생략됨
			//입력한 이름과 주소를 MEmebrDto 객체에 담는다
			MemberDto dto=new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			//MemberDao 객체를 생성해서
			MemberDao dao=new MemberDao();
			//insert() 메소드를 이용해서 회원 정보를 DB에 저장한다
			dao.insert(dto);
			
			
		}else if(command.equals("delete")) {
			int selectedRow=table.getSelectedRow();
			if(selectedRow==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택하세요");//자바 frame 창에서 알림을 띄우기 this는 알림을 띄울 컴포넌트(멤버프레임)의 참조값, 알림 메시지를 전달.
				return;// 메소드를 여기서 끝내기
			}
			int num= (int)model.getValueAt(selectedRow, 0);
			new MemberDao().delete(num);
		}
		
		printMember();

		
	}
	
	//회원 목록을 JTable에 출력하는 메소드
	public void printMember() {
		//기존에 출력된 내용을 초기화한 후에
		model.setRowCount(0);
		
		//테이블에 출력할 회원 목록 얻어오기
		MemberDao dao = new MemberDao();
		List<MemberDto> list= dao.getList();
		//반복문 돌면서
		for (MemberDto tmp:list ) {
			//MemberDto 객체에 담긴 회원정보를 이용해서 Object[] 에 담은 다음
			Object[] rowData = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			//테이블에 연결된 모델에 추가하기 -> 모델을 필드로 만들기
			model.addRow(rowData);
		}
	}
	
}