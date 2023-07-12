package ex12inheritance;

//부모클래스
public class DeParent {
	//멤버변수 : 정보은닉을 위해 private으로 정의 
	private String name;
	private int age;
	//생성자 : 디폴트생성자, 인수생성자 둘 다 정의 
	public DeParent() {}
	public DeParent(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//getter메서드 : private멤버를 클래스 외부로 반환한다.
	public String getName() {
		return name;
	}
	
	/* 아래 정의된 멤버메서드는 4가지 접근지정자를 통해 선언되었다. 
	차후 자식 클래스에서 접근 가능여부를 확인할 예정이다. */
	private void eat() {
		System.out.println("부모님이 드신다");
	}
	String sleep() {
		System.out.println("부모님이 주무신다");
		return null;
	}
	protected void walk() {
		System.out.println("부모님이 산책하신다");
	}	
	public void excecise() {
		System.out.println("부모님이 운동하신다");
	}
	//정보출력용 메서드로 멤버변수를 출력한다.
	public void printParent() {
		System.out.printf("성함:%s, 연세:%d", name, age);
	}
	//static으로 선언된 정적메서드 
	public static void staticMethod() {
		System.out.println("부모님의 정적메소드");
	}
}

