package ex12overidding.noco;

class MyA {
	public void rideMethod() {
		System.out.println("MyA의 rideMethod");
	}
}
class MyB extends MyA {
	@Override
	public void rideMethod() {
		System.out.println("MyB의 rideMethod");
	}
}
class MyC extends MyB {
	@Override
	public void rideMethod() {
		System.out.println("MyC의 rideMethod");
	} 
}

public class E03ReferenceYesNo {

	public static void main(String[] args) {

		MyA refNum1 = new MyB();
		MyA refNum2 = new MyC();  
		MyB refNum3 = new MyC();
		
		MyC refMyAddr1 = new MyC();
		MyB refMyAddr2 = refMyAddr1;
		MyA refMyAddr3 = refMyAddr1;
		
		MyA refId1 = new MyC();				
//		MyB refId2 = refId1;
//		MyC refId3 = refId1;

		MyB refId2 = (MyB) refId1;
		MyC refId3 = (MyC) refId1;
	}
}
