package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("메인 메소드 시작");
		//1byte 처리 스트림
		InputStream kbd=System.in;
		//2byte 처리 스트림
		var isr=new InputStreamReader(kbd);
		//bufferedreader의 생성자로 inputstreamreader 객체를 전달해서 객체 생성
		var br =new BufferedReader(isr);
		System.out.println("입력:");
		try {
			String line=br.readLine();
			System.out.println("line:"+line);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
