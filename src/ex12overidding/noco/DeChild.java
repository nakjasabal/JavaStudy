package ex12overidding.noco;

public class DeChild extends DeParent {
	String stNumber; 

	public DeChild(String name, int age, String stNumber) {
		super(name, age);
		this.stNumber = stNumber;
	}
	public void study() {
		//System.out.println(name +"이(가) 공부한다.");
		System.out.println(getName() +"이(가) 공부한다.");
	}
	private void eat() {
		System.out.println("학생이 먹는다.");
	}
	@Override
	public String sleep() {
		System.out.println("학생이 잔다");
		return null;
	}
	public int walk(int age) {
		System.out.println("나이가 "+ age +"살인 학생이 "
				+ "산책한다.");
		return 0;
	}
	@Override
	public void excecise() {
		System.out.println("학생이 운동한다.");
	}
	@Override
	public void printParent() {
		super.printParent();
		System.out.printf(", 학번:%s\n", stNumber);
	}
	public static void staticMethod() {
		System.out.println("학생의 정적메소드");
	}
}

