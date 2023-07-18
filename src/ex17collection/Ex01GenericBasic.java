package ex17collection;

//오렌지를 표현한 클래스 
class Orange {
	//멤버변수 : 당도를 표현 
	int sugar;
	//생성자 
	public Orange(int sugar) {
		this.sugar=sugar;
	}	
	//멤버메서드 
	public void showInfo() {
		System.out.println("오렌지의 당도는 "+ sugar +" 입니다");
	}
}
//오렌지 전용박스 : Orange인스턴스만 저장할 수 있다. 
class OrangeBox{
	//멤버변수 : 오렌지 객체 
	Orange item;
	//setter메서드 : 저장하다
	public void store(Orange item) { 
		this.item = item;
	}
	//getter메서드 : 꺼내다 
	public Orange pullOut() { 
		return item;
	}
}
//과일상자 : Object기반으로 모든 과일(인스턴스)를 저장할수있는 상자
class FruitBox{
	//멤버변수 : 모든 객체를 저장할 수 있다. 
	Object item;
	//생성자, setter, getter
	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Object item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}
public class Ex01GenericBasic {

	public static void main(String[] args) {
		
		/* 오렌지박스 인스턴스와 당도가 10인 오렌지 인스턴스를 
		생성한 후 저장한다. */
		OrangeBox oBox1 = new OrangeBox();
		Orange orange1 = new Orange(10); 
		oBox1.store(orange1);
		//상자에서 꺼낸 후 정보를 출력한다. 
		orange1 = oBox1.pullOut();		
		orange1.showInfo();
		/* 상자1은 오렌지 전용박스 이므로 다른과일(즉 객체)를 저장
		할수없다. 컴파일 에러가 발생하므로 실행자체가 불가능하다. 
		즉 자료형에는 안전하지만, 구현에는 불편함이 있다. 다른 
		객체를 저장하기 위해서는 또 다른 Box클래스를 생성해야한다. */
		
		/* 아래와 같이 Orange가 아닌 객체를 저장하면 즉시 컴파일
		에러가 발생하여 실행할 수 없는 코드가 된다. 즉 자료형에 
		안전하다고 할수있다. */
		//oBox1.store("당도가 20인 오렌지");
		Orange orange2 = oBox1.pullOut();
		orange2.showInfo();
		
		
		/* Object 기반으로 생성된 FruitBox는 구현에는 편리하나
		코드레벨에서 에러가 발생하지 않으므로 오류를 찾아내기가 
		훨씬 더 어렵다. */
		//Orange객체를 저장후 꺼내는건 문제없이 실행된다.
		FruitBox fBox1 = new FruitBox(new Orange(20));
		Orange orange3 = (Orange)fBox1.pullOut();
		orange3.showInfo();		
		
		/* 하지만 오렌지 같은 String을 저장하고, 이를 꺼내서 
		다운캐스팅 하는 부분에서는 예외가 발생된다. 즉 런타임 에러가
		발생하게 되므로 실행해보기 전에는 오류를 예측하기 쉽지않은
		단점이 있다. */
		FruitBox fBox2 = new FruitBox("당도가 30인 오렌지");
		Orange orange4 = (Orange)fBox2.pullOut();//런타임에러발생
		orange4.showInfo();
	}
}


