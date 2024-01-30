package ex90enum;

enum Car{
	FERRARI, PORSCHE;
}
enum Fruit{
	APPLE, ORANGE;
}

public class ex03 {
	public static void whatDoYouWant(Car c) {
		switch (c) {
		case FERRARI:
			System.out.println("난 페라리~");
			break;
		case PORSCHE:
			System.out.println("난 포르쉐~");
			break;
		}
	}
	public static void main(String[] args) {
		whatDoYouWant(Car.FERRARI);
		//whatDoYouWant(Fruit.APPLE); //자료형 불일치로 컴파일에러 
	}
}
