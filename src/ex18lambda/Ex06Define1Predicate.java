package ex18lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
Java에서 제공하는 함수형 인터페이스에는 아래 4가지 정도가있다. 
차이점이라면 매개변수의 유무와 리턴값 정도이다. 

Predicate<T> : 매개변수O, 리턴값 boolean
Supplier<T> : 매개변수X, 리턴값O
Consumer<T> : 매개변수O, 리턴값X
Function<T,E> : 둘다있음 
 */
public class Ex06Define1Predicate {

	public static void main(String[] args) {
		
		//테스트를 위한 4개의 인스턴스를 생성한다. 
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 77);
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유", "여", 99);
		
		/*
		Predicate<T>
		-사전적의미 : ~에 근거를 두다
		-매개변수와 boolean 리턴값이 있는 추상메서드 test()가 
		정의되어있다. 
		-파라미터를 조사해 true / false를 반환한다 .
		
		interface Predicate<T> {
			boolean test(T t);
		}
		
		인터페이스에 정의된 test()를 오버라이딩하여 아래와 같은 
		람다식을 정의한다. 매개변수로 Human객체를 전달하고, getter
		인 getGender()를 통해 성별이 '남'인경우 true를 반환하도
		록 정의되어있다. 
		*/
		Predicate<Human> pre = (Human h) -> {		
			return h.getGender().equals("남"); 
		};
		System.out.println("p.test(p1) => "+ 
				pre.test(p1)); //true
		System.out.println("p.test(p2) => "+ 
				pre.test(p2)); //false
		
		System.out.println("===============================");
			
		/* 인수로 사용된 4개의 객체를 저장한 List컬렉션을 생성한다.
		단 해당 컬렉션은 값을 변경할수는 없고 참조만 가능하다. */
		List<Human> list1 = Arrays.asList(p1, p2, p3, p4);
		/*
		Predicate<Human> aaa = 
			(Human h)->{ h.getGender().equals("남"); }
		이와같은 람다식을 정의한 후 참조변수인 aaa를 전달하는것과
		아래처럼 람다식 자체를 매개변수로 작성하는것은 동일하다. 
		 */
		double maleAvg = 
			avg((Human h)->h.getGender().equals("남"), 
					list1);
		System.out.println("남자 평균:"+ maleAvg);
	}
	/*
	첫번째 매개변수는 성별이 "남"이면 true를 반환하는 람다식이고
	두번째 매개변수는 4개의 Human객체가 저장된 List컬렉션이다. 
	 */
	public static double avg(Predicate<Human> ph, List<Human> li) {
		//카운트용 변수
		int pCount = 0;
		int tCount = 0;
		//컬렉션에 저장된 Human객체의 갯수만큼 반복한다. 
		for(Human h : li) {
			//람다식을 통해 각 Human객체의 성별을 판단한다. 
			if(ph.test(h)==true) {
				//"남"인 경우에만 변수를 1증가시킨다. 
				pCount++;
				//Human의 score를 얻어와서 합산한다. 
				tCount += h.getScore();
			}
		}
		//총점을 사람의 명수로 나눠서 평균값을 반환한다. 
		return (double)tCount / pCount;
	}////end of avg
}






