package ex12inheritance.noco;

import ex12inheritance.map.noco.Korea;

class Seoul extends Korea {
	private String city;
	public Seoul(String name, String city) {
		super(name); 
		this.city = city;
	}
	
	public void callMethod() {
		super.publicMethod("callMethod->");
		super.protectedMethod("callMethod->");
//		super.defaultMethod(); //에러
//		super.privateMethod(); //발생
	}	
}

public class E02ProtectedInheritanceMain {

	public static void main(String[] args) {
		Seoul seoul = new Seoul("대한민국", "서울");
		seoul.callMethod();
	}
}


















