package ex04controlstatement;
/*
문제3) 아래 코드의 삼항연산자를 if~else문으로 변경하시오. 
단, 실행결과는 동일해야 합니다.
 */
public class QuIfElseChange {

	public static void main(String[] args) {
		int num1=50, num2=100;
		int big, diff;

		//big = (num1>num2) ? num1 : num2; //조건?참:거짓;
		if(num1>num2) {
			big = num1;
		}
		else {
			big = num2;
		}
		System.out.println(big); //결과:100

		//diff = (num1>num2)? num1-num2: num2-num1;
		//실행할 문장이 1줄인 경우 중괄호를 생략할 수 있다.
		if(num1>num2)
			diff = num1-num2;
		else
			diff = num2-num1;
		System.out.println(diff);//결과:50
	}
}
