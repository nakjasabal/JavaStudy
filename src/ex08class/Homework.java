package ex08class;

class MyClass {
	String str;
	public MyClass(String str) {
		super();
		this.str = str;
	}
	public void showInfo() {
		System.out.println("숙제끝:"+str);
	}
}

public class Homework {

	public static void main(String[] args) {
		MyClass mc = new MyClass("클래스생성");
		mc.showInfo();
	}

}
