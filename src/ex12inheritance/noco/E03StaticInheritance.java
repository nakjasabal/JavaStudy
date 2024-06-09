package ex12inheritance.noco;
 
class Adder {	
	public static int val = 0;	
	public void add(int num) {
		val += num;
		Adder.val += num;
	}
}
class AdderFriend extends Adder{
	
	public void friendAdd(int num) {
		val += num;
		Adder.val += num;
	}
	public void showVal() {
		System.out.println("val="+ val);
		System.out.println("val="+ Adder.val);
	}
}

public class E03StaticInheritance {
	
	public static void main(String[] args) {
		
		Adder ad = new Adder();
		AdderFriend adFriend = new AdderFriend();
		
		ad.add(1); 				//1+1=2	 
		adFriend.friendAdd(3); 	//2+3+3=8
		Adder.val += 5;			//8+5=13
		AdderFriend.val += 7; 	//13+7=20
		adFriend.showVal();  
	}
}







