package ex08class;

//과일판매자를 추상화 한 클래스 
class FruitSeller2{
	//멤버변수 
	//보유한 사과의 재고수량
	int numOfApple;
	//판매 수익금
	int myMoney;
	//기존에 상수로 선언했던 부분을 일반 멤버변수로 변경한다.  
	int apple_price ;
	/* 사과의 단가를 표현하는 멤버변수가 상수로 선언되면 선언과
	동시에 초기화해야한다. 또한 초깃값이 없는 상태로 선언 자체가
	불가능하다. 따라서 기존의 상수를 일반 변수로 변경해야한다. */
	
	/* 초기화 메서드를 선언하여 객체 생성 후 다양한 형태의 
	초기화가 가능하다. */
	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	} 
	
	//멤버메서드 	
	public int saleApple(int money) {
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	//판매자의 현재상태를 출력한다. 
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}
//구매자를 추상화 한 클래스 
class FruitBuyer2{
	//멤버변수 : 보유금액, 구매한 사과의 갯수 
	int myMoney; 
	int numOfApple;
	
	//멤버변수의 초깃값을 제거한 후 초기화메서드를 추가한다. 
	public void initMembers(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	//멤버메서드 	
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	//구매자의 현재상태 출력 
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}

public class E06FruitSalesMain2 {
	
	public static void main(String[] args) {
		
		/*
		초기화 메서드가 정의되었으므로 상태가 다른 객체를 생성할 수
		있다. 
		*/
		//판매자1 : 사과100개, 단가1000원으로 정의 
		FruitSeller2 seller1 = new FruitSeller2();		
		seller1.initMembers(0, 100, 1000);
		//판매자2 : 사과80개, 단가500원으로 정의
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMembers(0, 80, 500);
		//구매자 : 보유금액10000원 
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000, 0);

		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//각각의 판매자에게 5000원씩 지불하고 사과를 구매한다. 
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);

		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();//5개를 판매한다. 
		seller2.showSaleResult();//10개를 판매한다. 
		//10000원을 내고 15개를 구매한다. 
		buyer.showBuyResult();
	}
}



