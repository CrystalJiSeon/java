package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass07 {
	public static void main(String[] args) {
		System.out.println("main() 메소드가 \"시작\"되었습니다");
		System.out.println("main() 메소드가 \\시작\\되었습니다");
		
		//MyFolder/memo.txt 파일에 저장할 문자열을 출력하기
		String msg="난 자바의 신이 될 것이다";
		//1. 메모 파일을 만들기
		//File f= new File("C:\\Users\\acorn\\Desktop\\playground\\MyFolder\\memo.txt");
		File f=new File("C:/Users/acorn/Desktop/playground/MyFolder/memo.txt");
		try {
			if(!f.exists()) {//만일 해당 파일이 존재하지 않으면
				f.createNewFile();//새로 만들어라
				System.out.println("memo.txt 파일을 만들었습니다");
			}
			//2. 문자열을 파일에 저장하기
			//new FileWriter(File 객체, append mode 여부)
			
			var fw= new FileWriter(f, true);
			fw.append(msg);
			fw.append("\r\n");//개행기호
			fw.flush();//실제출력
			fw.close();//마무리
			System.out.println("메모장 파일에 문자열을 기록했습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
