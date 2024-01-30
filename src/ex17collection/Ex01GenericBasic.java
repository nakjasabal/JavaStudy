package ex17collection;

class Orange {
	int sugar;
	public Orange(int sugar) {
		super();
		this.sugar = sugar;
	}
	@Override
	public String toString() {
		return "오렌지의 당도는 "+ sugar +" 입니다";
	}
}
class Apple{
	int weight;
	public Apple(int weight) {
		super();
		this.weight = weight;
	} 
	@Override
	public String toString() {
		return "사과의 무게는 "+ weight +" 입니다";
	}
}

//오렌지 전용박스 : Orange인스턴스만 저장할 수 있다. 
class OrangeBox{
	//멤버변수 : 오렌지 객체 
	Orange item;
	public Orange getItem() {
		return item;
	}
	public void setItem(Orange item) {
		this.item = item;
	}
}
//과일상자 : Object기반으로 모든 과일(인스턴스)를 저장할수있는 상자
class FruitBox{
	//멤버변수 : 모든 객체를 저장할 수 있다. 
	Object item;
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
}
public class Ex01GenericBasic {

	public static void main(String[] args) {
		
		OrangeBox orangeBox = new OrangeBox();
		
		Orange orange = new Orange(10); 
		Apple apple = new Apple(10);
				
		orangeBox.setItem(orange);
		orange = orangeBox.getItem();
		System.out.println(orange);
		 
		//Apple을 저장할 수 있는 새로운 박스가 필요함
		//orangeBox.setItem(apple); 
		
		FruitBox fruitBox = new FruitBox();
		
		fruitBox.setItem(apple);		
		Apple a1 = (Apple) fruitBox.getItem();
		
		fruitBox.setItem(orange);
		Apple a2 = (Apple) fruitBox.getItem();
	}
}


