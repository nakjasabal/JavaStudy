package ex09package.study.area;

//원의 넓이를 구하기 위해 작성한 클래스 
public class Circle {
	//멤버변수 : 반지름
	double rad;
	//멤버상수 : 원주율
	final double PI;
	//생성자 메서드
	public Circle(double rad){
		//변수명이 동일한 경우 구분을 위해 this사용
		this.rad = rad;
		//생성자에서는 멤버상수를 초기화할수있다.
		PI = 3.14159;
	}	
	//멤버메서드 : 원의 넓이를 계산해서 반환한다 
	public double getArea(){
		return PI * rad * rad;
	}	
}



