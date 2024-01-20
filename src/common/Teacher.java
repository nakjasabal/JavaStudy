package common;

import java.util.Objects;

public class Teacher extends Person
{
	//자식에서 확장한 멤버변수 
	private String subject;
	public Teacher(String name, int age, String subject)
	{
		super(name, age);
		this.subject = subject;
	}
	@Override
	public String toString()
	{
		return super.toString() +", 과목:"+ subject;
	}
	
	/*
	시나리오] Teacher객체는 나이와 과목이 같으면 동일한 객체로 
		처리하도록 hashCode와 equals 메서드를 적절히 오버라이딩
		하시오. 
	 */	
	/*
	hashCode()
	 : 객체가 가진 고유한 주소값을 정수형으로 반환해준다. 
	 따라서 서로 다른 객체라면 다른값을 반환하게된다. 
	 정수형 멤버변수는 그냥 사용하면되고, 객체형 멤버변수는 
	 hashCode() 메서드를 통해 정수값으로 반환되는 참조값을 
	 사용하면된다. 
	*/
	@Override
	public int hashCode() {
		/* 방법1 : 정수형변수와 객체의 해시코드값을 합산한 후
		 	그대로 반환한다. */
		int returnCode1 = super.getAge() + 
				this.subject.hashCode();
		System.out.println("returnCode1="+ returnCode1);
		 
		/* 방법2 : 방법1이 번거롭다면 Objects 클래스의 정적메서드
		 	인 hash()를 사용해도된다. 멤버변수의 갯수만큼 인수로
		 	전달하면 위와 동일하게 고유한 주소값을 정수형으로 반환
		 	해준다. */
//		int returnCode2 = Objects.hash(super.getAge(), 
//				this.subject);
		int returnCode2 = Objects.hash(super.getName(), super.getAge());
		System.out.println("returnCode2="+ returnCode2);
		
		//1, 2 둘다 사용할 수 있다. 
		return returnCode2;
	}
	/*
	equals() 
		: 객체가 가진 멤버변수의 값을 비교한다. 값이 같을때는 true
		다를때는 false를 반환하도록 오버라이딩한다. 
	*/
	@Override
	public boolean equals(Object obj) {
		Teacher teacher = (Teacher)obj;
		/* age는 int형이므로 비교연산자를 통해 비교한다. 
		subject는 String이므로 equals() 메서드를 통해 비교해야
		한다. */
		/* (teacher.getAge()==super.getAge()) 
				&& teacher.subject.equals(this.subject) */
		if(teacher.getName().equals(this.getName()) &&
				teacher.getAge()==super.getAge() ) {
			/* 모든 내용이 일치하면 true를 반환한다. 그러면 set컬렉션
			에는 add(추가)되지 않는다. */
			return true;
		}
		else {
			//만약 내용이 틀리다면 add된다. 
			return false;
		}
	}
	
	
	
	
	
	 
}
