package test.mypac;
//Generic 클래스는 여러 개일 수 있다.
public class Pear<K, V> {
	//필드
	private K key;
	private V value;
	
	//생성자
	public Pear(K key, V value) {
		this.key=key;
		this.value=value;
	}
	
	//메소드
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
