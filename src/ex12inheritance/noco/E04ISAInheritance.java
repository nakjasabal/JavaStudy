package ex12inheritance.noco;

class Computer{
	String owner;  
	
	//public Computer() {}
	public Computer(String name) {
		owner = name;
	}
	private void keyboardTouch() {
		System.out.println("키보드를 통해서 입력한 ");
	}
	private void calculate() {
		System.out.println("요청된 내용을 계산한다.");
	} 
	public void calculateFunc() {
		keyboardTouch(); 
		calculate(); 
	}
}
class NotebookComputer extends Computer {
	int battery;  
	
	public NotebookComputer(String name, int initCharge) {
		super(name);
		battery = initCharge;
	}
	public void charging() {
		battery += 5;
	}
	public void movingCal() {
		if(battery < 1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		
		System.out.print("이동하면서 ");
//		keyboardTouch(); 	//에러
//		calculate();		//발생
		calculateFunc();
		
		//배터리를 1 차감한다. 
		battery -= 1;  
	}
}
class TabletNotebook extends NotebookComputer{
	
	String registPencil;  
	public TabletNotebook(String name, int initCharge,
			String pen) {
		super(name, initCharge);
		registPencil = pen;
	}
	public void write(String penInfo) {
		if(battery<1) {
			System.out.println("배터리가 방전되어 사용불가");
			return;
		}
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된 펜이 아닙니다.");
			return;
		}
		super.movingCal();
		System.out.println("스크린에 펜으로 그림을 그린다.");
		battery -= 1;
	}
}

public class E04ISAInheritance {
	
	public static void main(String[] args) {

		NotebookComputer noteBook = new NotebookComputer("공유", 5);
		TabletNotebook tablet = 
				new TabletNotebook("이동욱", 5, "ISE-1234");

		System.out.println("==노트북컴퓨터사용==");	
		noteBook.movingCal();
		noteBook.movingCal();
		noteBook.movingCal();
		noteBook.movingCal();
		noteBook.movingCal(); 
		noteBook.movingCal(); 
		noteBook.movingCal();
		noteBook.movingCal();

		System.out.println("==ISE-1234 펜으로 테블릿사용==");
		tablet.write("ISE-1234");  

		System.out.println("==XYZ-9876 펜으로 테블릿사용==");
		tablet.write("XYZ-9876");  
	}
}
