package ex04controlstatement;

import java.io.IOException;
/*
문제1) 파일명 : QuNumberYN.java
하나의 문자를 입력받아 숫자인지 여부를 판단하는 프로그램을 
삼항연산자를 이용하여 구현하시오.	
(System.in.read()를 사용하세요)
 */
public class QuNumberYN {

	public static void main(String[] args) throws IOException {
		
		//하드코딩으로 1차 테스트
		//char c = 'A';		
		//사용자부터 입력 받아 처리(2차)
		System.out.print("문자를 입력하세요:");
		int c = System.in.read();
		
		//if문으로 구현
		if(c>='0' && c<='9') {
			System.out.println("숫자입니다.");
		}
		else {
			System.out.println("숫자가 아닙니다.");
		}

		//삼항연산자로 구현
		/*
		형식] 자료형 변수 = (조건식) ? 참일때의값 : 거짓일때의값 ;
			=> 조건식에 따라 선택된 값이 좌측항의 변수에 할당되는 형태
		 */
		String str = (c>='0' && c<='9') ? "숫자입니다(삼항)" : "숫자가 아닙니다(삼항)";
		System.out.println(c +"는(은) "+ str);

	}

}
