package test.mypac;
//클래스 정의 시 특정 타입을 전달받아서 사용하는 구조로 정의할 수 있는데,
//그런 클래스를 Generic 클래스라고 한다
public class FruitBox<T> {
	//T 같은 애들을 포괄 클래스(Generic 클래스)라고 함
	
	private T item;
	public void pack(T item) {
		this.item=item;
	}
	public T unPack() {
		return item;
	}
}
