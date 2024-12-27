package test.frame05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	JTextArea ta=new JTextArea();
	//생성자
	public MyFrame() {
		//프레임 제목
		this.setTitle("나의 프레임");
		//프레임 위치와 크기 설정 setBounds(x, y, width, height)
		setBounds(100,100,500,500);
		//종료 버튼을 눌렀을 때 프로세스 전체가 종료되도록 하기
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//레이아웃 메니저 객체 생성
		BorderLayout layout =new BorderLayout();
		//프레임의 레이아웃 메니저 설정
		setLayout(layout);
		
		//TextField 와 Button을 배치할 패널객체
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.red);
		//TextField와 Button을 생성해서
		JTextField inputMsg= new JTextField(30);
		JButton sendBtn=new JButton("전송");
		//Panel에 추가
		topPanel.add(inputMsg);
		topPanel.add(sendBtn);
		//프레임의 위쪽에 패널 추가
		add(topPanel, BorderLayout.NORTH);
		
		
		ta=new JTextArea();
		//textarea를 스크롤 패널에 감싼다
		JScrollPane scroll = new JScrollPane(ta);
		//프레임의 가운데에 TextArea 추가
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		ta.setFont(font);
		add(scroll, BorderLayout.CENTER);
		sendBtn.addActionListener((event)->{
			//TextField 에 입력한 문자열을 읽어온다.
			String msg=inputMsg.getText();
			//미리 준비된 메소드를 호출하면서 입력한 문자열을 등록함
			request(msg);			
		});
		
		//화면상에 실제 보이도록 하기
		setVisible(true);
		
	}
	//매개변수에 전달되는 주소로 요청하는 메소드
	public void request(String requesturl) {
        try {
            // 요청 보낼 URL 설정
            URL url = new URL("https://acornacademy.co.kr"); // 예제 URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // HTTP 요청 메서드 설정
            connection.setRequestMethod("GET");

            // 헤더 설정 (필요에 따라 추가)
            connection.setRequestProperty("Accept", "application/json");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            //응답한 문자열을 누적시킬 객체 
            StringBuilder response = new StringBuilder();
            //만일 정상적인 응답이라면 
            if (responseCode == HttpURLConnection.HTTP_OK) {
            	//응답하는 내용을 읽어들일 객체 
            	BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));           
                //반복문 돌면서
            	while (true) {
                	//한줄씩 읽어들이고 
                	String line=br.readLine();
                	//만일 다 읽었다면 
                	if(line==null) {
                		break; //반복문 탈출
                	}
                	//읽은 문자열 한줄을 누적시킨다.
                    response.append(line+"\r\n");
                }
               
            } else {
                System.out.println("Request failed. Response Code: " + responseCode);
            }
            //누적된 문자열을 출력하기 
           // System.out.println(response.toString());
            //누적된 문자열을 TextArea에 출력하기
            ta.setText(response.toString());
            // 연결 해제
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	//main 메소드
	public static void main(String[] args) {
		new MyFrame();
	}
}