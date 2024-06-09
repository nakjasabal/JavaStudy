package ex12overidding.noco;

public class E04OverrideApply {

	public static void main(String[] args) {
		
		System.err.println("Child형 참조변수로 Child객체 참조");
		DeChild child = 
				new DeChild("율곡이이", 49, "00학번");
		
		child.excecise();
		child.sleep();
		child.printParent();
		child.study();
		child.walk();
		child.walk(25);
		DeChild.staticMethod();

		/////////////////////////////////////////
		System.err.println("Parent형 참조변수로 Child객체 참조");
		DeParent parent = 
				new DeChild("퇴계이황", 35, "99학번");
		
		parent.excecise();
		parent.sleep();
		parent.printParent();
		//parent.study(); //에러발생
		parent.walk();
		//parent.walk(20); //에러발생
		DeParent.staticMethod();
	}
}




