package ex12inheritance;

//부모클래스 
class Account {	
	/* 멤버변수가 상속관계에 있다 하더라도 private으로 선언되면
	클래스 내부에서만 접근할 수 있다. 즉 상속받은 하위클래스에서는
	직접 접근이 불가능하다. */
	private int money;	
	
	/* 이와같이 개발자가 생성자를 직접 정의하면 디폴트 생성자는 추가
	되지 않는다. 디폴트 생성자는 개발자가 생성자를 정의하지 않았을때만
	컴파일러에 의해 자동으로 추가된다. */
	public Account(int init) {
		money = init;
	}	
	//입금처리 : protected로 선언되었으므로 상속관계에서 접근가능
	protected void depositMoney(int _money) {
		if(_money<0) {
			System.out.println("마이너스 금액은 입금처리 "
					+ "불가합니다");
			return;
		}
		//금액이 음수가 아니라면 멤버변수에 금액을 합산한다. 
		money += _money;
	}
	//private멤버변수를 외부로 반환할때 사용하는 메서드(getter)
	protected int getAccMoney() {
		return money;
	}
}
//자식클래스 정의 
class SavingAccount extends Account {
	/* 인자생성자에서 부모의 생성자를 호출하기 위한 super(xx)를
	사용한다. 이때 매개변수가 하나인 부모클래스의 생성자가 호출된다. 
	현재 부모클래스에는 매개변수가 하나인 생성자가 유일하므로 만약
	아래와같이 호출하지 않으면 에러가 발생한다. */
	public SavingAccount(int initVal) {
		/* 만약 아래 문장을 삭제하면 즉시 에러가 발생한다. 삭제하는
		경우 super()라는 문장, 즉 매개변수가 없는 디폴트 생성자를
		호출하는 문장이 자동으로 추가되는데, 부모클래스에는 이런
		형태의 생성자가 없으므로 아래와 같이 명시해야한다. */
		super(initVal);
	}	
	/* 부모클래스에 정의된 멤버변수 money는 private이므로 
	자식쪽에서는 아래와 같이 접근할 수 없다. 보이지 않으므로 에러가
	발생한다. 따라서 부모클래스에 protected로 선언된 멤버메서드를
	통해 입금처리를 해야한다. */
	public void saveMoney(int money) {
		//super.money += money;
		depositMoney(money);		
	}
	/* 잔고를 확인하기 위한 멤버메서드로 부모의 멤버변수인 money에
	직접 접근할 수 없으므로 아래와같이 getter를 통해 반환받아 
	출력해야한다. */
	public void showAccountMoney() {
		//System.out.println("지금까지의 누적금액:"+ super.money);
		System.out.println("지금까지의 누적금액:"+ 
				getAccMoney());
	}
}
public class E02PrivateInheritanceMain {

	public static void main(String[] args) {
		
		//자식클래스를 통해 인스턴스를 생성한다. 
		SavingAccount sa = new SavingAccount(10000);
		/* private 멤버이므로 상속받은 하위클래스의 참조변수를
		통해서는 접근할 수 없다. 은닉된 정보이므로 "not visible"
		에러가 발생한다. */
		//sa.money = 100000;//에러발생
		//입금처리
		sa.saveMoney(5000);
		//잔액조회
		sa.showAccountMoney();
		//마이너스 금액은 입금불가
		sa.saveMoney(-1000);
		sa.showAccountMoney();		
		
		
		/* 부모클래스를 통해 객체를 생성한다. 하지만 해당 인스턴스
		변수를 통해서도 멤버변수 money에 접근할 수 없다. 현재 
		접근하려는 위치가 클래스 외부이기 때문이다. 즉, private
		멤버는 무조건 클래스 내부에서만 접근을 허용한다. */
		Account account = new Account(1000);
		//account.money = 1000;//에러발생	
	}
}







