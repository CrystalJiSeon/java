package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		//인터페이스도 익명 클래스를 활용해서 구현 후 참조값을 얻어낼 수 있다
		Remocon r1= new Remocon() {
			
			@Override
			
			public void up() {
				System.out.println("채널 올려");
			}
			
			@Override
			public void down() {
				System.out.println("채널 내려");
				
			}//리모콘 타입 객체는 동작을 2개 가지고 있다.
			//2개의 동작을 객체에 담아서 전달하고,메소드 안에서는 해당 동작을 사용한다
		}; //Remocon만 입력하고 Ctrl Space하면 알아서 생성해줌
		useRemocon(r1);
		useRemocon(new Remocon() {
			
			@Override
			public void up() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void down() {
				// TODO Auto-generated method stub
				
			}
		});
		/*{

			@Override
			public void up() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void down() {
				// TODO Auto-generated method stub
				
			}
			
		};//{}는 익명클래스 : 자동으로 implements Remocond이 됨 
		//(리모콘이 인터페이스가 아니고 클래스였으면 자동으로 extends Remocon이 됨
		//    ->추상메소드를 override 할 의무가 생겨서 빨간 밑줄 쳐진거 해결해주면 됨)
		///*/
		 
	}

	public static void useRemocon(Remocon r1) {
		r1.up();
		r1.down();
	}
}
