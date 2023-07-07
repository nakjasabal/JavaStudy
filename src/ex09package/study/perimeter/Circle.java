package ex09package.study.perimeter;

//원의 둘레를 구하기 위해 작성한 클래스 
public class Circle {
	double rad;
	final double PI;
	
	public Circle(double rad){
		this.rad = rad;
		PI = 3.14159;
	}	
	//원의 둘레를 계산한 후 반환한다. 
	public double getPerimeter(){	
		return 2 * PI * rad;
	}
}

