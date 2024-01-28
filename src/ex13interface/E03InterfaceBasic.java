package ex13interface;

/*
인터페이스(interface)
-클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라 할수있다.
-자바는 단일 상속을 원칙으로 하지만 인터페이스를 통해 다중 상속을
구현할 수 있다. 
-추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위클래스
에서는 반드시 추상메서드를 오버라이딩 해야한다. 
-멤버로는 추상메서드와 상수만 선언할 수 있다. 
	메서드 : public abstract
	상수 : public static final
-인터페이스는 생성자를 선언할 수 없다. 
 */
interface MyInterface1 {	
 
	//생성자 사용 불가
	//public MyInterface1() {} 
	
	/* 멤버상수 : 인터페이스에 선언되는 변수는 상수로 선언된다. 
	 	따라서 반드시 대문자로 작성해야한다. */
	//public static final은 생략하는것이 좋다. 
	public static final int MAX_INT = Integer.MAX_VALUE;
	double MAX_DBL = Double.MAX_VALUE;

	/* 멤버메서드 : 메서드는 무조건 추상메서드로 선언된다.*/
	//public abstract은 생략하는것이 좋다. 
	public abstract void absFunc1();
	void absFunc2();
}
//두번째 인터페이스
interface MyInterface2 {
	void absFunc2();
}
//일반적인 클래스 선언 
class SimpleClass {
	int simple = 1;
	void mySimple() {
		System.out.println("simple="+ simple);
	}
}
/* 인터페이스는 콤마를 이용해서 여러개의 인터페이스를 "구현" 할수있다. 
또한 "상속"과 "구현"을 동시에 사용할수도 있다. */
class MyClass extends SimpleClass 
		implements MyInterface1, MyInterface2 {
	/* 인터페이스에 동일한 이름의 추상메서드가 존재하는 경우
	하나만 오버라이딩 하면된다. 오버라이딩은 항상 자식쪽의 메서드가
	호출되므로 아무런 문제도 발생되지 않는다. */ 
	@Override
	public void absFunc1() {
		System.out.println("absFunc1() 호출됨");
	}
	@Override
	public void absFunc2() {
		System.out.println("absFunc2() 호출됨");
	}
	/* SimpleClass 클래스의 멤버메서드는 필수사항이 아니므로 
	필요한 경우에만 오버라이딩 하면된다. */
}

public class E03InterfaceBasic {
	public static void main(String[] args) {
		//"구현"한 인터페이스를 통해 참조변수 선언은 가능하다. 
		MyInterface1 my1 = new MyClass();
		//오버라이딩한 메서드는 항상 자식클래스에 정의한것이 호출된다.
		my1.absFunc1();
		my1.absFunc2();
		//자식쪽 멤버에 접근하려면 다운캐스팅 후 호출해야한다.
		((SimpleClass)my1).mySimple();
		
		/* MyClass의 부모는 모두 3개이므로 아래는 모두 참조가 
		가능하다. */
		MyInterface2 my2 = new MyClass();
		SimpleClass simpleClass = new MyClass();
	}
}


