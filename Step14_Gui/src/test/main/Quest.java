package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Quest extends JFrame{
	String msg;
	JTextField tf=new JTextField(20);
	public Quest() {
		this.setTitle("내 프레임");
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.orange);
		JButton sendBtn=new JButton("전송");
		JTextField tf=new JTextField(20);
		topPanel.add(tf);
		topPanel.add(sendBtn);
		add(topPanel, BorderLayout.NORTH);
		JTextArea ta=new JTextArea();
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		ta.setFont(font);
		add(ta, BorderLayout.CENTER);
		sendBtn.addActionListener((event)->{
			String msg=tf.getText();
			Scanner scan = new Scanner(System.in);
	
		});
		setVisible(true);
		
	}
	
	public void Form() {
		try {
            // 요청 보낼 URL 설정
            URL url = new URL(tf.getText()); // 예제 URL
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
            System.out.println(response.toString());
            
            // 연결 해제
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("종료 합니다");
	}
	
	
	
	public static void main(String[] args) {
		new Quest();
	}
	
	
}

