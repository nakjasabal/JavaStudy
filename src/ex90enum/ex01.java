package ex90enum;

import java.util.Scanner;

//열거형 사용 이전에는 인터페이스형 상수를 사용했다. 
interface IScale {
	int DO=0, RE=1, MI=2, FA=3, SOL=4, RA=5, SI=6;
}

//열거형 정의 
enum EScale {
	DO, RE, MI, FA, SOL, RA, SI;
}
public class ex01 {	
	public static void main(String[] args) {
		System.out.print("숫자 하나를 입력하세요:");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		
		//인터페이스형 상수 사용
		switch (i) {
		case IScale.DO: 
			System.out.println("도");
			break;
		case IScale.RE: 
			System.out.println("레");
			break;
		case IScale.MI: 
			System.out.println("미");
			break;		
		}
		
		
		EScale es = EScale.FA;
		//열거형 사용
		switch (es) {
		case FA: 
			System.out.println("파");
			break;		
		case SOL: 
			System.out.println("솔");
			break;		
		case RA: 
			System.out.println("라");
			break;		
		case SI: 
			System.out.println("시");
			break;		
		}
	}
}
