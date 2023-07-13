package ex12inheritance;

/*
다형성(Polymorphism)
: 하나의 인스턴스(객체)를 여러 타입의 참조변수를 통해 참조할때 
참조변수의 타입에 따라 다양한 형태의 인스턴스를 이용할 수 있는 특성을
말한다. 

-부모타입의 참조변수로 자식인스턴스를 참조
1.이경우 부모타입의 참조변수는 부모로부터 상속받은 멤버까지만 접근할
수있다. 
2.자식에서 오버라이딩한 메서드가 우선적으로 호출된다. 
3.자식에서 새롭게 정의한 멤버는 접근할 수 없다. 
4.이것을 이질화(Heterogeneous : 헤테로지니어스)라고 표현한다. 

-동일한 타입의 참조변수로 인스턴스를 참조
1.인스턴스 전체를 접근할 수 있다. 즉 클래스의 일반적인 규칙을 따른다.
2.이것을 동질화(Homogeneous : 호모지니어스)라고 표현한다. 
 */
//부모클래스 
class Parent {
	int parentMember;
	void parentMethod() {
		System.out.println("부모의메소드:parentMethod()");
	}
}
//자식클래스 
class Child extends Parent{
	//자식에서 확장한 멤버 
	int childMember;
	void childMethod() {
		System.out.println("자식의메소드:childMethod()");
	}
	//부모에서 정의한 메서드를 오버라이딩 해서 재정의한 메서드 
	@Override
	void parentMethod() {
		System.out.println("자식에서 Overriding한 메소드"
				+ "parentMethod()");		
	}
	/* 메서드명은 동일하지만 매개변수가 틀리므로 오버로딩으로 정의된
	메서드이다. 따라서 자식에서 확장한 멤버가 된다. */
	void parentMethod(int childMember) {
		this.childMember = childMember;
		System.out.println("Overloading:자식에서 확장한 메소드"
				+ ":parentMethod(param1)");
	}
}

public class E11Polymorphism {

	public static void main(String[] args) {
		
		//동질화 : 참조변수와 인스턴스의 타입이 동일하다. 
		Child homeChild = new Child();
		//동질화의 경우 인스턴스 전체를 접근할 수 있다. 
		homeChild.childMember = 10;
		homeChild.parentMember = 100;
		homeChild.childMethod(); 
		homeChild.parentMethod(1000);//오버로딩 한 메서드 
		homeChild.parentMethod();//오버라이딩 한 메서드
		
		/* 이질화 : 부모타입의 변수로 자식인스턴스를 참조하는것을
		말한다. 이 경우 자식 클래스에서 새롭게 정의한 멤버는 접근
		할수없다. 만약 접근해야 한다면 자식타입으로 강제형변환(다운
		캐스팅)해야 한다. */
		System.out.println("[부모타입에 자식타입의 메모리 주소 복사]");
		Parent parent1 = homeChild;
		parent1.parentMember = 1;
		//부모타입으로 자식인스턴스에 접근할 수 없으므로 에러발생
		//parent1.childMember = 1;
		//오버라이딩 한 메서드이므로 자식쪽이 호출된다. 
		parent1.parentMethod();
	 
		//부모 참조변수로 자식 인스턴스를 참조한 두번째 변수 생성
		Parent parent2 = new Child();
		parent2.parentMember=1;
		parent2.parentMethod();
		/* 부모 참조변수로 접근하려면 강제형변환 해야한다. 하지만
		아래와 같이 기술하면 에러가 발생한다. 
		(Child)parent2.childMember
		소괄호를 하나 더 추가해서 parent2를 자식타입으로 형변환
		후 멤버변수에 접근해야 한다. */
		((Child)parent2).childMember = 1;
		((Child)parent2).childMethod();
		((Child)parent2).parentMethod();
		
		/* 자식타입으로 형변화 이후에 해당 참조변수를 통해 자식
		멤버에 접근한다. 위와 동일한 방법이다. */
		Child child2 = (Child)parent2;
		child2.childMember = 1;
		child2.childMethod();
		child2.parentMethod(1);
	 
		/* Java에서 생성한 모든 클래스는 Object클래스를 상속
		한다. 따라서 모든 인스턴스는 Object의 참조변수로 참조가
		가능하다. 또한 Object클래스에 정의된 모든 메서드를 별도의
		선언없이 사용할 수 있고, 필요하다면 오버라이딩도 할수있다.*/
		Object object = new Child();
		((Parent)object).parentMethod();
	}
}




