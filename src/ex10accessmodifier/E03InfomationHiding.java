package ex10accessmodifier;

class FruitSeller6{
	
	/* 멤버변수에 private 접근지정자를 추가한다. 이렇게 하면
	클래스 내부에서만 접근할 수 있고 외부에서의 접근은 원천적으로 
	차단할 수 있다. */
	private int numOfApple;
	private int myMoney;	  
	private final int APPLE_PRICE;	

	public FruitSeller6(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	} 
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}
class FruitBuyer6{
	private int myMoney; 
	private int numOfApple;
	
	public FruitBuyer6(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller6 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}

public class E03InfomationHiding {
	
	public static void main(String[] args) {

		FruitSeller6 seller1 = 
				new FruitSeller6(0, 100, 1000);
		
		FruitSeller6 seller2 = 
				new FruitSeller6(0, 80, 500);
		
		FruitBuyer6 buyer = new FruitBuyer6(10000, 0);

		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
///////////////////////////////////////////////
		/* 멤버변수를 private으로 선언하면 클래스 외부에서는 
		접근이 불가능하므로 아래 코드는 에러가 발생하게된다.(이
		부분은 주석으로 처리한다)
		즉, 멤버변수의 정보은닉을 통해 비정상적인 접근을 차단하고
		멤버메서드를 통해서만 구매가 이루어질 수 있도록 구현해야한다.
		*/
		
		//각 판매자에게 1000원을 지불한다. 
		//단가가 1000원이므로 1개 구매할 수 있다. 
		buyer.buyApple(seller1, 1000);
		//단가가 500원이므로 2개 구매할 수 있다. 
		buyer.buyApple(seller2, 1000);
		/* 정보은닉(Information hiding)을 통해 판매의 규칙이
		지켜지게된다. */
		
//		seller1.myMoney += 1000; //판매자 1에게 1000원 지불
//		buyer.myMoney -= 1000;//구매자의 금액 차감 
//		seller1.numOfApple -= 50;//사과 50개를 구매한다.
//		buyer.numOfApple += 50;//구매자는 사과 50개가 증가한다.
		//즉 1000원 내고 사과 50개를 구매한 꼴이 된다. 
		
///////////////////////////////////////////////

		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult(); 
		seller2.showSaleResult();  
		buyer.showBuyResult();
	}
}



