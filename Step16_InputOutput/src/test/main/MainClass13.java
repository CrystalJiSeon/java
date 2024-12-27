package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass13 {
	public static void main(String[] args) {
		//try-with-resources 문법
		/* try (){} 형태로 만들어서 소괄호 안에 널체크하고 닫아야 하는 애들을 모두 넣어주면 자동으로 됨
		 * null 체크와 close()호출이 자동화됨
		 */
		try(
			//파일로부터 byte 알갱이를 읽어들일 객체 생성
			var fis= new FileInputStream("C:\\Users\\acorn\\Desktop\\playground\\MyFolder\\0.png");//대입
			//byte 알갱이를 파일에 출력할 객체 생성
			var fos= new FileOutputStream("C:\\Users\\acorn\\Desktop\\playground\\MyFolder\\copied.png");//대입
		){
		
			//byte 알갱이 여러개를 한번에 담을 배열 미리 준비하기
			byte[] buffer=new byte[1024]; // 한번에 1kilobyte를 읽을 수 있는 배열
			
			//반복문 돌면서
			while(true) {
				//byte[] 배열을 전달해서 byte 알갱이를 한번에 1024개씩 읽어들인다.
				int readedCount=fis.read(buffer);//읽어들인 개수가 리턴됨
				System.out.println(readedCount+"바이트를 읽었습니다");
				if(readedCount==-1)break;//더이상 읽을 데이터가 없으면 반복문 탈출
				//byte[]배열에 저장된 byte 알갱이를 0번 인덱스로부터 읽은 개수 만큼만 출력하기
				fos.write(buffer, 0, readedCount);//배열, 시작인덱스, 읽은 숫자를 전달하는 write 메소드를 사용한다.
				//write(byte[] b)를 사용하면 나머지 null값이 들어있는 배열까지 읽어버려서 앞에서 잘 읽어들인 파일이 깨질 수가 있다.
				
			}
			System.out.println("파일을 카피했습니다");
			//마무리 작업 : 파일을 연 다음에는 닫아줘야 메모리 누수가 일어나지 않는다
			//만약에 위에서 작업이 진행되다 exception이 진행되는지 아닌지 여부에 관계 없이 마무리 작업을 finally에 보내주는 것이 좋다
			
			fos.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
