package ex12overidding.noco;
  
class MyParent {
	int parentMember;
	void parentMethod() {
		System.out.println("부모의메소드:parentMethod()");
	}
}
class MyChild extends MyParent{
	int childMember;
	void childMethod() {
		System.out.println("자식의메소드:childMethod()");
	}
	@Override
	void parentMethod() {
		System.out.println("자식에서 Overriding한 메소드"
				+ "parentMethod()");		
	}
	void parentMethod(int childMember) {
		this.childMember = childMember;
		System.out.println("Overloading:자식에서 확장한 메소드"
				+ ":parentMethod(param1)");
	}
}

public class E06Polymorphism {

	public static void main(String[] args) {
		
		MyChild myChild = new MyChild();
		myChild.childMember = 10;
		myChild.parentMember = 100;
		myChild.childMethod(); 
		myChild.parentMethod(1000); 
		myChild.parentMethod();
				
		MyParent parent1 = myChild;
		parent1.parentMember = 1;
		//parent1.childMember = 1;
		parent1.parentMethod();
	 
		MyParent myParent = new MyChild();
		myParent.parentMember=1;
		myParent.parentMethod();
		((MyChild)myParent).childMember = 1;
		((MyChild)myParent).childMethod();
		((MyChild)myParent).parentMethod();
		
		MyChild child2 = (MyChild)myParent;
		child2.childMember = 1;
		child2.childMethod();
		child2.parentMethod(1);
	 
		Object object = new MyChild();
		((MyParent)object).parentMethod();
	}
}




