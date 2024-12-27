package test.mypac;
/*
 * Dto : Data Transfer Object의 약자
 * 
 * [작성 규칙]
 * 1. 디폴트 생성자가 반드시 있어야 한다
 * 2. 필드는 접근지정자가 private로 되어 있어야 한다
 * 3. 필드의 접근 메소드 setter, getter 메소드가 있어야 한다.
 */

public class MemberDto {

	//필드의 접근지정자를 private
	private int num;
	private String name;
	private String addr;
	
	//디폴트 생성자
	public MemberDto() {}

	//얘는 필수 아닌 생성자임, constructor 만들기 : 우클릭 >Source >Generate Constructor using fields
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	//Setter, Getter 만들기 : 우클릭 > Source > Generate Setter Getter methods
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}	
}
