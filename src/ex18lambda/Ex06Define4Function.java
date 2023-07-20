package ex18lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex06Define4Function {
	 
	public static void main(String[] args) {		
		/*
		Function<T, E>
		: 매개변수와 반환값을 둘 다 가지고있는 apply() 
		추상메서드가 정의되어있다. 개발자가 가장 많이 사용하는 
		함수형 인터페이스이다. 
		
		interface Function<T, E> {
			E apply(T t);
		}
		=> T는 매개변수, E는 반환타입으로 사용한다. 
		 */
		/* 매개변수는 String, 반환값은 Integer 타입으로 람다식을
		정의한다. 문자열의 길이를 반환한다. */
		Function<String, Integer> func = (String s) -> {
			return s.length();
		};
		
		System.out.println("Lambda 문자열길이="+ 
				func.apply("Lambda"));
		System.out.println("LambdaExpression 문자열길이="+ 
				func.apply("LambdaExpression"));
		
		System.out.println("================================");
		
		//Human객체 생성 후 List<E> 컬렉션으로 변환한다. 
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 77);
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유", "여", 99);
		List<Human> list = Arrays.asList(p1, p2, p3, p4);
		
		/* Human객체를 인수로 받은 후 점수(score)를 반환하는 
		람다식 정의 */
		Function<Human, Integer> getFunction = 
				(Human h) -> {
					return h.getScore(); 
				};
		int score = getFunction.apply(p1);
		System.out.println("p1의점수:"+ score);//80점 출력
		
		//향상된for문을 통해 컬렉션 전체를 반복하여 점수를 출력한다.
		System.out.println("### list에 저장된 객체의 점수 출력");
		for(Human h : list) {
			System.out.println(h.getName()+"의점수:"+ getFunction.apply(h));
		}		
	}
}
