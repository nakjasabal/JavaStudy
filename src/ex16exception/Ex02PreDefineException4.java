package ex16exception;

import java.util.Date;

public class Ex02PreDefineException4 {
 
	//정적변수를 생성한다. 단 아직까지 객체는 생성되지 않았다. 
	static Date toDay;
	
	public static void main(String[] args)  {	
		
		System.out.println("### NullPointerException ###");
		/*
		참조변수가 null인 상태에서 출력하면 toString()메서드를 통해
		문자열 형태의 null이 출력된다. 예외가 발생하진 않는다. 
		 */
		System.out.println("toDay="+ toDay);
		
		try {
			/*
			인스턴스 변수만 생성하고, 참조할 객체가 없는 경우에
			메서드를 호출하면 예외가 발생하게된다.
			 */
			System.out.println(toDay.getTime());
		}
		catch(NullPointerException e) {
			System.out.println("toDay 참조변수는 null입니다.");
			System.out.println("예외메세지:"+ e.getMessage());
		}
		
	}////end of main	
}
