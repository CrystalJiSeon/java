package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass11 {
	public static void main(String[] args) {
		try {
			//파일로부터 byte 알갱이를 읽어들일 객체 생성
			var fis= new FileInputStream("C:\\Users\\acorn\\Desktop\\playground\\MyFolder\\0.png");
			
			//byte 알갱이를 파일에 출력할 객체 생성
			var fos= new FileOutputStream("C:\\Users\\acorn\\Desktop\\playground\\MyFolder\\copied.png");
			
			//반복문 돌면서
			while(true) {
				//1 바이트(숫자)를 읽어들여서 10진수로 반환함
				int readedByte= fis.read();//byte 타입으로 표현하게 되면 -128부터 127까지 표현할 수 있음. 이게 바이트 알갱이를 표현하기 딱 좋은 데이터 타입임.
				System.out.println(readedByte);
				if(readedByte==-1)break;//if 문 다음에 실행할 코드가 오직 한줄이면 중괄호 안에 코드할 필요 없음
				//읽어들인 1바이트 출력
				fos.write(readedByte);
				fos.flush();
			}
			System.out.println("파일을 카피했습니다");
			//마무리 작업 : 파일을 연 다음에는 닫아줘야 메모리 누수가 일어나지 않는다
			
			fos.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
