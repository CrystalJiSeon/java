package test.mypac;

/*
 * 이미 존재하는 부모 클래스인 Phone 클래스를 extends(상속) 받아서 자식 클래스인 MobilePhone 클래스 정의하기
 * 확장해서 가져오는것을 상속이라고 부름
 * 부모의 기능을 모두 사용할 수 있을 뿐더러, 
 * 부모가 가진 메소드를 가져와서 내 상황에 맞게 재정의하여 수정할 수가 있음 -> 상속을 사용하는 주된 이유
 */
public class MobilePhone extends Phone {
	//생성자
	public MobilePhone() {
		System.out.println("MobilePhone 생성자 호출");
	}
	//이동중에 전화를 걸어요
	public void mobileCall() {
		System.out.println("이동중에 전화를 걸어요");
	}
	//사진 찍는 메소드
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍어요");
	}
	
}
