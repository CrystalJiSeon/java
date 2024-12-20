package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		Drill d1 = new Drill() {
			
			@Override
			public void hole() {
				System.err.println("책상에 구멍뚫기");
			}
		};//객체에 동작이 하나 포장되어 있다.
		useDrill(d1);
		
		Drill d2= ()->{
			System.out.println("의자에 구멍뚫기");
			
		};//자바스크립트에서 화살표 함수랑 비슷하게 생겼는데 -를 = 대신 쓴 드릴 타입의 메소드, 단 메소드에 동작이 1개여야 한다
		useDrill(d2);
		useDrill(()->{
			System.out.println("지면 뚫기");
		});//즉석에서 드릴 타입 객체 만드는 방법, 모양은 메소드지만 드릴 타입의 객체임(단, 인터페이스의 메소드가 오직 1개일때만)
	}
	
	public static void useDrill(Drill d) {//그 동작이 포함된 객체를 메소드를 호출하면서 전달한다
		d.hole();
		d.hole();//메소드 안에서는 객체에 포장된 1개의 동작을 사용한다 //언어의 한계 -> 이걸 해결하려고 만들어진 이상한 문법 ()->{};
	}
}
