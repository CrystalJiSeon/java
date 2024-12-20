package test.mypac;

public class IosPhone extends MobilePhone{
	public IosPhone() {
		System.out.println("아이폰입니다.");
	}
	public void apple() {
		System.out.println("이것은 사과입니다. 농담입니다. 앱등입니다");
	}
	@Override
	public void mobileCall() {
		// TODO Auto-generated method stub
		//super.mobileCall();
		System.out.println("사과는 애아뽈, 애아뽈");
	}
}
