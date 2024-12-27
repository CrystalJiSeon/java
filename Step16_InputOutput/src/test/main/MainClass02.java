package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("메인 메소드 시작");
		//1byte 처리 스트림
		InputStream kbd=System.in;
		
		//2byte 처리 스트림(65536가지를 표현 가능) 한글 처리 가능한 객체
		InputStreamReader isr = new InputStreamReader(kbd);
		//위에거를 var isr=InputStreamReader(kbd);라고 해도 됨
		System.out.println("입력: ");
		try {
			//InputStreamReader 객체로 입력한 문자의 코드 값 읽어내기
			int code=isr.read();
			System.out.println("code:"+code);
			char ch=(char)code;
			System.out.println("ch:"+ch);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
