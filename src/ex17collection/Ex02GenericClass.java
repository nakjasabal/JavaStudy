package ex17collection;
 
/*
class FruitBox{
	Object item;
	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Object item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}  => 기존 Object기반의 FruitBox를 아래와 같이 제네릭 클래스로
	변경한다. 자료형에 해당하는 부분을 타입매개변수로 교체하고 
	인스턴스 생성시 자료형을 결정하기 위해 클래스명 <T>형태로 
	변경한다. 
*/
//제네릭 클래스 정의 
class GenericFruitBox<T> {
	T item;
	public void store(T item) {
		this.item = item;
	}
	public T pullOut() {
		return item;
	}
}

public class Ex02GenericClass {

	public static void main(String[] args) {
 
		/* Box인스턴스를 생성할때 T부분을 결정하므로 구현의 
		편의성이 보장된다. 각각 Apple, Banana 객체를 저장할 수 
		있는 인스턴스가 생성되었다. */
		GenericFruitBox<Apple> appleBox = new GenericFruitBox<Apple>();
		appleBox.store(new Apple(10));
		Apple apple1 = appleBox.pullOut();
		System.out.println(apple1);	
		
		GenericFruitBox<Orange> orangeBox = new GenericFruitBox<Orange>();
		//orangeBox.store(new Apple(20));
		//Apple apple2 = (Apple) orangeBox.pullOut();
		//System.out.println(apple2);
	}
}

