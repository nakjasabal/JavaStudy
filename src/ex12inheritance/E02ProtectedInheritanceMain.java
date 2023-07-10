package ex12inheritance;

//부모클래스와 다른 패키지에 선언되었으므로 import해야한다. 
import ex12inheritance.map.Korea;

//자식클래스에서 Korea를 상속한다. 
class Seoul extends Korea {
	//멤버변수와 생성자 정의 
	private String city;
	public Seoul(String name, String city) {
		super(name);//부모생성자 호출
		this.city = city;
	}
	
	/* 4개의 접근지정자를 통해 정의한 메서드를 호출한다. 단 부모
	클래스가 다른 패키지에 선언되었으므로 default, private 멤버는
	호출할 수 없다. 
	 */
	public void callMethod() {
		super.publicMethod("callMethod->");
		super.protectedMethod("callMethod->");
//		super.defaultMethod(); //에러
//		super.privateMethod(); //발생
		/* 이와같이 직접 접근할 수 없는 메서드는 접근 가능한
		멤버메서드를 통해 간접 호출하면 된다. */
	}	
}

public class E02ProtectedInheritanceMain {

	public static void main(String[] args) {
		
		Seoul seoul = new Seoul("대한민국", "서울");
		seoul.callMethod();
	}
}


















