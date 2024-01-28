package ex18lambda;

import java.util.Random;

/*
매개변수는 있으나 반환값이 없는 추상메서드
: 두개의 문자열을 전달받아 연결해서 출력한다.  
 */
@FunctionalInterface
interface StringConcat{
	public void makeString(String s1, String s2);
}
/*
매개변수는 없으나 반환값은 있음
: 0~99사이의 난수를 생성하여 반환한다. */
@FunctionalInterface
interface RandomNumber{
	public int randomNum();
}
/*
매개변수와 반환값 둘다 있음
: 매개변수로 전달된 두 정수만큼의 구구단을 2차원배열로 반환한다. */
@FunctionalInterface
interface GugudanRange{
	public String[][] guguString(int n1, int n2);
}
/*
매개변수도 없고 반환값도 없음
: 단순히 메뉴만 출력하는 기능을 가진다. */
@FunctionalInterface
interface MenuPrint {
	public void onlyPrint();
}

public class Ex05ParamNReturn {
	
	public static void main(String[] args) {
			
		System.out.println("### 람다식1");
		String s1 = "안녕하세요?";
		String s2 = "람다식입니다.";
		/* 
		2개의 매개변수는 String으로 추상메서드를 통해 유추할수 
		있으므로 람다식에서는 생략할 수 있다. 메서드명을 제거한 후
		괄호사이에 화살표를 삽입하여 람다식을 정의한다. 호출시에는
		부모 인터페이스의 추상메서드인 makeString()을 이용하면
		된다. */
		StringConcat sc = (a, b) -> {
			System.out.println(a +" "+ b);
		};
		sc.makeString(s1, s2);
		
	 
		System.out.println("\n### 람다식2");
		/* 
		매개변수가 없는 람다식을 정의해야 하므로 빈 소괄호를 사용한
		다. 난수를 생성해서 반환하는 기능을 정의하였다. */
		RandomNumber randomNumber = () -> {
			Random random = new Random();
			return random.nextInt(100);
		};
		//반환값이 있으므로 좌측항의 변수로 할당된다. 
		int rNumber = randomNumber.randomNum();
		System.out.println("생성된 난수:"+ rNumber);

		
		System.out.println("\n### 람다식3");		 
		GugudanRange gugudanRange = (num1, num2) -> {
			//2차원배열을 선언한 후 구구단을 각 인덱스에 삽입한다.
			String[][] gugudan = new String[9][9];
			//num1단에서 num2단까지 반복한다. 
			for (int i=num1 ; i<=num2 ; i++) {
				for (int j=1 ; j<=9 ; j++) {
					gugudan[i-1][j-1] = i+"*"+j+"="+(i*j);
				}
			}
			return gugudan;
		};
		/* 람다식 호출시 두 정수를 인수로 전달한 후 이차원배열의
		반환값을 받는다. */
		String[][] returnStr = 
				gugudanRange.guguString(4, 6);
		//반환된 결과값을 통해 4단에서 6단까지 출력한다. 
		for (int i=4 ; i<=6 ; i++) {
			for (int j=1 ; j<=9 ; j++) {
				System.out.print(returnStr[i-1][j-1]+" ");
			}
			System.out.println();
		}		
		
		//단순히 문자열만 출력하는 람다식을 정의한다. 
		System.out.println("\n### 람다식4");	 
		MenuPrint menuPrint = () -> {
			System.out.println("메뉴를 출력합니다");
		};
		menuPrint.onlyPrint();
	}
}








