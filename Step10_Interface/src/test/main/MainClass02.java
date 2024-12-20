package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		//다형성 확인
		MyRemocon r1=new MyRemocon();
		Remocon r2=r1;
		Object r3=r1;
		
		useRemocon(r1);
		useRemocon(r2);
		//useRemocon(r3); 이건 에러남 부모는 자식을 받아주지만 자식은 부모를 잘 받아주지 않음
		//casting 해서 전달하면 메소드를 호출할 수 있다.
		useRemocon((Remocon)r3);
	}
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
