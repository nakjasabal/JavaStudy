package ex15usefulclass;

/*
Java의규칙 : java.lang패키지는 자동으로 import 된다. 
	모든 클래스는 Object클래스를 직/간접적으로 상속한다. 
 */
import java.lang.*;

/*
Math클래스
-java.lang 패키지에 정의된 클래스
-수학과 관련된 일련의 작업들을 처리하는 메서드가 정의됨
-메서드는 static으로 선언되어있어 객체생성없이 클래스명으로 즉시 
사용가능함
 */
public class E03MathClass extends Object {

	public static void main(String[] args) {
		
		System.out.println("원주율:"+ Math.PI);

		float f = -3.14f;
		double d = -100.9;
		int num = -10;

		System.out.println("### 절대값 ###");
		System.out.println("Math.abs:"+ Math.abs(f));
		System.out.println("Math.abs:"+ Math.abs(d));
		System.out.println("Math.abs:"+ Math.abs(num));

		System.out.println("### 올림 ###");
		System.out.println("Math.ceil:"+ Math.ceil(3.4));//4
		System.out.println("Math.ceil:"+ Math.ceil(-3.4));//-3
		System.out.println("Math.ceil:"+ Math.ceil(3.9));//4

		System.out.println("### 내림 ###");
		System.out.println("Math.floor:"+ Math.floor(3.4));//3 
		System.out.println("Math.floor:"+ Math.floor(-3.4));//-4
		System.out.println("Math.floor:"+ Math.floor(3.9));//3

		 
		/*
		round의 경우 소수첫번째 자리수로 올림/버림을 결정한다. 
		따라서 3.4xx라면 버림처리를 하게된다. 
		 */
		System.out.println("### 반올림 ###");
		//버림처리 : 3
		System.out.println("Math.round:"+ Math.round(3.49999));
		//올림처리 : 4
		System.out.println("Math.round:"+ Math.round(3.54444));
		
		System.out.println("Math.round:"+ Math.round(-1.4));
		System.out.println("Math.round:"+ Math.round(-1.5));
		System.out.println("Math.round:"+ Math.round(-3.5));
		
		System.out.println("### 최대/최소 ###");
		System.out.println("Math.max:"+ Math.max(100, 99));
		System.out.println("Math.min:"+ Math.min(100, 99));

		System.out.println("### 난수 ###");
		/*
		0~1사이의 실수값을 반환. 정수값을 만들고 싶을때는 특정한
		값을 곱해준다. 
		 */
		System.out.println((int)(Math.random()*45)+1);

		System.out.println("### 거듭제곱 ###");
		System.out.println("2의 10승은? "+ Math.pow(2, 10));
	}
}
