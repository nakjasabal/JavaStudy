package ex04controlstatement;
/*
문제2)다음 예제는 두개의 if문을 사용하고 있다.
이를 하나의 if문으로 변경해보자
 */
public class QuIfMerge {

	public static void main(String[] args) {
		
		int num = 120;
		 
		//2개의 if문으로 구현
//		if (num > 0) {
//			if ((num % 2) == 0) {
//				System.out.println("양수이면서 짝수");
//			}
//		}
		 
		//논리연산자를 이용해서 하나의 if문으로 구현
		if (num > 0 && (num % 2) == 0) {
			System.out.println("양수이면서 짝수"); 
		}
	}

}
