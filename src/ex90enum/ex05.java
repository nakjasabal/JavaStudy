package ex90enum;

enum Week {
	MONDAY, SATURDAY, SUNDAY;
}

class MyFavo {
	String hobby;
	Week goodDay;
	public MyFavo(String hobby, Week week) {
		this.hobby = hobby;
		this.goodDay = week;
	}
	@Override
	public String toString() {		
		return goodDay+" : "+ hobby;
	}
}
 
public class ex05 {
	public static void main(String[] args) {
		
		MyFavo mf1 = new MyFavo("자전거", Week.SATURDAY);
		MyFavo mf2 = new MyFavo("목욕", Week.SUNDAY);
		 
		System.out.println(mf1);
		System.out.println(mf2);
		
		System.out.println("\n열거된 원소를 배열처럼 출력");
		for(Week w : Week.values()) {
			System.out.print(w +" ");
		}
		
		System.out.println("\n\n열거된 순서대로 정수값을 리턴");
		System.out.println("MONDAY="+Week.MONDAY.ordinal());
		System.out.println("SUNDAY="+Week.SUNDAY.ordinal());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
