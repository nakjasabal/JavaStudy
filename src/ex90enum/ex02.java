package ex90enum;

//인터페이스형 상수 사용시의 문제점
interface Animal{
	int DOG=1, CAT=2;
}
interface Person{
	int MALE=1, FEMALE=2;
}

public class ex02 {
	
	public static void whoAreYou(int choice) {
		switch (choice) {
		case Person.MALE:
			System.out.println("남성");
			break;
		case Person.FEMALE:
			System.out.println("여성");
			break;
		}
	}
	public static void main(String[] args) {
		System.out.print("여성=>");
		whoAreYou(Person.FEMALE);
		System.out.print("강아지=>");
		whoAreYou(Animal.DOG);
	}
	
}
