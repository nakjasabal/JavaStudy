package ex08class;

/* 해당 예제에서는 Human클래스를 별도의 파일로 작성하였다. 
동일한 패키지에 정의되었다면 컴파일러는 해당 클래스를 찾아 즉시
인스턴스 화 할수있다. 만약 다른 패키지에 선언된 클래스라면 반드시
import 선언을 해야한다. */
public class E02HumanMain {

	public static void main(String[] args) {
		
		/* 1.클래스를 통해 인스턴스를 생성한다. 참조변수(인스턴스
		형변수)는 스택영역에, 인스턴스는 힙영역에 생성된다. */
		Human human = new Human();
		
		/* 2.인스턴스 초기화 : 참조변수를 통해 .(닷)으로 접근할
		수 있다. 여기서 멤버변수에 초기값을 할당한다. */
		human.name = "마이클";
		human.age = 28;
		human.energy = 4;
		
		/* 3.멤버메서드 호출을 통해 걷다, 먹다 등의 행위를 
		구현한다. */
		human.showState();//-> 객체의 초기상태를 확인
		human.eating();
		human.walking();
		human.thinking();
		human.showState();//->멤버메서드 호출 후 객체의 상태 확인
		
		/* 4.반복문을 통해 멤버메서드를 여러번 호출한다. 시나리오
		에서 제시한 조건들이 정확히 구현되었는지 확인한다. */
		for(int i=1 ; i<=20 ; i++) {
			human.walking();
		}
		human.showState();		
		for(int i=1 ; i<=20 ; i++) {
			human.eating();
		}
		human.showState();
	}
}
