package ex05method;

/*
메서드 오버로딩(Method Overloading) 
: 동일한 이름의 메서드를 2개이상 정의하는것을 말한다. 
-매개변수의 갯수가 다르거나 자료형이 다를때 성립한다. 
-반환타입만 다른것은 허용되지 않는다. 
-컴파일러는 메서드 호출시 전달되는 인수(파라미터)를 통해 호출할 
메서드를 구분한다. 
 */
public class E07Overloading {
	
	//주민번호와 군번을 매개변수로 정의한 메서드(남자를 표현)
	static void person(int juminNum, int milNum) {
		System.out.println("군필자 이시군요");
		System.out.println("주민번호:"+ juminNum);
		System.out.println("군번:"+ milNum);
	}
	//주민번호만 있는 메서드(여자를 표현)
	static void person(int juminNum) {
		System.out.println("미필자이거나 여성이시군요");
		System.out.println("주민번호:"+ juminNum);		
	}
	/* 해당 메서드는 앞에서 선언한것과 반환타입만 다른 경우이므로
	person(10)으로 호출한다 가정했을때 어떤 메서드를 호출할지
	애매하다. 컴파일러는 애매한 경우 에러를 발생시킨다. 따라서 
	아래의 메서드는 오버로딩이 성립하지 않는다. */
//	static int person(int juminNum) {
//		System.out.println("미필자이거나 여성이시군요");
//		System.out.println("주민번호:"+ juminNum);
//		return 1;
//	}

	public static void main(String[] args) {
		//매개변수가 2개인 메서드 호출
		person(123456, 7890123);
		System.out.println("====================");
		//매개변수가 1개인 메서드 호출
		person(987654);
		
		System.out.println("====================");
		/* 출력을 위해 사용하는 print()문이 대표적인 오버로딩으로
		정의된 메서드이다. 정수, 실수, 문자 등 모든 타입에 대해
		오버로딩으로 정의되어있다. */
		System.out.println(10);
		System.out.println(3.14);
		System.out.println('a');
		System.out.println("오버로딩");
		System.out.println(true);
	}
}


