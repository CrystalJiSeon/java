package test.mypac;

public class MyRemocon implements Remocon{//인터페이스는 implements 해야 한다
//굳이 만들 필요가 없었던 클래스
//이너 클래스로 사용하는 방법 ->Main Class 03
	
	
	@Override
	public void up() {
		System.out.println("볼륨을 올려요!");
	}

	@Override
	public void down() {
		System.out.println("볼륨을 내려요!");
	} 

}
