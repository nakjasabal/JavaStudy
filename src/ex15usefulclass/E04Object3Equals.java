package ex15usefulclass;

//멤버변수가 1개인 클래스 정의
class MyClass {	
	int data;
	public MyClass(int data) {
		this.data = data;
	}
	/*
	toString() : 객체가 가진 데이터를 문자열로 반환해준다. 
		print()가 호출될때 항상 자동으로 호출되어 출력에 도움을 준다.
	 */
	@Override
	public String toString() {
		//정수를 문자열로 변경해서 반환한다. 
		return String.valueOf(data);
	}
	/*
	MyClass객체간의 비교를 위해 equals()를 오버라이딩 하여 재정의한다. 
	객체가 가진 멤버변수의 값에 대한 비교를 통해 동일여부를 판단한다.
	equals()메서드의 매개변수 타입은 모든 객체를 대상으로 하므로
	Object형으로 정의되어 있다. 
	 */
	@Override
	public boolean equals(Object obj) {		
		/*
		매개변수로 전달된 객체를 Object로 받으면 업캐스팅(자동형변환)이
		되므로 다운캐스팅 후 객체에 대한 비교를 해야한다. 
		이때 전달된 객체가 MyClass형이 아니라면 비교의 대상이 될수
		없으므로 상속관계 확인을 위해 instanceof연산자를 사용한다. 
		 */
		if(obj instanceof MyClass) {
			/*
			매개변수가 MyClass타입이 맞다면 비교를 위해 다운캐스팅한다.
			그렇지 않으면 부모타입으로는 자식 멤버에 접근이 불가능하므로
			아래와 같이 data 멤버변수에 접근할 수 없다. 
			 */
			MyClass mc = (MyClass)obj;
			if(mc.data == this.data) {
				//값이 일치하면 true를 반환하고..
				System.out.println("MyClass-멤버동일함");
				return true;  
			}
			else {
				//틀리면 false를 반환한다. 
				System.out.println("MyClass-멤버다름");
				return false;  
			}
		}
		else {
			/*
			매개변수로 전달된 객체가 MyClass의 인스턴스가 아니라면
			비교의 대상이 될수없으므로 false를 반환한다. 
			 */
			System.out.println("MyClass객체아님");
			return false;
		}
	}
}

public class E04Object3Equals {

	public static void main(String[] args) {
		
		//클래스를 통해 2개의 객체를 생성한다. 
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);

		//해당비교는 단순히 참조값을 비교하므로 다르다고 출력된다.
		System.out.println("[두 객체를 비교연산자를 통해 비교]");		
		if(mc1==mc2) {
			System.out.println("인스턴스 참조값(주소값)이 같다");
		}
		else {
			System.out.println("인스턴스 참조값(주소값)이 다르다");//[O]
		}
		
		System.out.println("[두 객체를 equals()메소드로 비교]");		
		//객체의 멤버변수를 비교하므로 같다고 출력된다. 
		System.out.println(mc1.equals(mc2) ? "같다" : "다르다");//[같다]
		
		/*
		print()를 통해 출력하면 자동으로 toString()을 호출하므로
		아래 출력결과는 동일하다. 
		 */
		System.out.println("[두 객체의 toString()메소드 호출]");
		System.out.println("mc1.toString()=>"+ mc1.toString());
		System.out.println("mc2=>"+ mc2);
		
	}
}
