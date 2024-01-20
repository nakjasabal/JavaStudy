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
class Apple{
	int weight;
	public Apple(int w) {
		weight = w;
	}
	public void showInfo() {
		System.out.println("사과의 무게는 "+ weight +" 입니다.");
	}
}
class OrangeBox {
	Orange item;
	public Orange getItem() {
		return item;
	}
	public void setItem(Orange item) {
		this.item = item;
	}
}
class FruitBox {
	Object item;
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
}
public class Test {

	public static void main(String[] args) {
		
		OrangeBox oBox = new OrangeBox();
		Orange orange = new Orange(10);
		oBox.setItem(orange);	
		orange = oBox.getItem();

		Apple apple = new Apple(20);
//		oBox.setItem(apple);

		
		FruitBox fBox = new FruitBox();
		fBox.setItem(orange);
		Orange orange1 = (Orange)fBox.getItem();
		
		fBox.setItem(apple);
		Orange orange2 = (Orange)fBox.getItem(); 

	}

}
