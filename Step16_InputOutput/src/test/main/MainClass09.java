package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * C:Users/acorn/Desktop/playground/MyFolder/memo.txt 파일에 저장된 문자열을 읽어와서
 * 콘솔창에 출력하는 예제
 */
public class MainClass09 {
	public static void main(String[] args) {
		File f=new File("C:/Users/acorn/Desktop/playground/MyFolder/memo.txt");
		
		try {
			//파일로부터 문자열을 읽어들일 수 있는 객체 생성
			var fr=new FileReader(f);
			//문자열을 바로 읽어들일 수 있는
			var br= new BufferedReader(fr);
			//무한루프 돌면서
			while(true) {
				String line=br.readLine();
				//더이상 읽어올 문자열이 없으면 반복문 탈출
				//만일 더이상 읽을 게 없다면
				if(line==null) {
					break;
				}
				//읽어낸 문자열을 한줄씩 콘솔창에 출력
				System.out.println(line);
			}
		}catch(IOException ie){
			ie.printStackTrace()
		;}
			
		}
		
		
}

