package test.main;

import java.io.IOException;
import java.io.InputStream;

/*
 * 입력,출력(input, output)
 * -어떤 대상으로부터 데이터를 메모리로 읽어들이는 것을 입력
 * -프로그래밍 언어의 관점에서 메모리라는 것은 변수나 필드나 객체로 생각하면 편함
 * -데이터는 2진수로 이루어졌지만 2진수 8개의 묶음인 1바이트 단위로 생각하면 편함
 * -1바이트는 총 256가지의 값을 표현 가능
 * -1바이트를 10진수로 환산하면 0~255 사이의 숫자 중 하나
 * - 입력과 출력을 통해서 이동하는 데이터는 byte(byte 알갱이) 하나하나가 이동한다고 생각하면 됨
 */
public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("메인 메소드 시작합니다");
		//키보드와 연결된 InputStream 타입의 참조값을 kbd라는 지역변수에 담고
		//InputStream 객체는 1바이트 단위 처리 스트림이다.
		//영문자, 대소문자, 숫자, 특수문자만 처리할 수 있고
		//한글은 처리가 불가능하다.		
		InputStream kbd = System.in;
		
		try {
			//입력한 키의 코드 값 읽어오기
			int code=kbd.read();
			System.out.println("code:"+code);
			//code 값으 대응되는 문자 얻어내기
			char ch=(char)code;
			System.out.println("ch"+ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
