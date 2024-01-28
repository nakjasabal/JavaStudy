package ex12inheritance;

/*
구성관계로 표현하기에 적합한 Has-A관계
: X has a Y => X가 Y를 소유(포함)하다.
여기서는 권총을 소유한 경찰을 표현하다. 

Has-A와 같이 소유의 관계를 상속으로 표현하면 클래스간의 강한 연결고리
가 형성되어 권총이 없는 경찰을 표현하기가 힘들어진다. 따라서 이 경우에
는 구성(Composition)관계로 표현하는것이 적합하다. 
구성관계란 클래스의 멤버로 다른 객체를 사용하는것을 말한다. 
 */
//권총을 표현한 클래스 
class Gun {
	//총알수를 표현한 멤버변수
	int bullet;
	public Gun(int bNum) {
		bullet = bNum;
	}
	//총을 발사한 후 총알이 감소하는것을 표현한 멤버메서드
	public void shutGun() {
		System.out.println("빵야~~!"); 
		bullet--; 
	}
}
//경찰을 표현한 클래스 
class Police {
	/* 권총과 수갑을 보유한 경찰을 표현하기 위해 상속을 사용하지
	않고, 멤버변수로 정의하고 있다. */
	int handCuffs; //수갑 : 일반적인 멤버변수
	Gun gun; //권총 : 인스턴스형 멤버변수
	
	//생성자 메서드 
	public Police(int bNum, int hCuff) {
		//수갑은 단순히 정수값을 통해 보유여부를 설정한다. 
		handCuffs = hCuff;
		/* 권총의 보유여부는 총알이 없는 상태라면 권총이 없는것으로
		간주하여 null로 초기화한다. 참조변수가 null 이라는것은
		참조할 인스턴스가 없는것을 의미한다. 즉 힙영역에 생성된 
		인스턴스가 아예 없으므로 소유하지 않은것을 표현할 수 있다. */
		if(bNum<=0) {
			gun = null;
		}
		else {
 			gun = new Gun(bNum);
		}
	}
	//수갑을 채우는 행위를 표현 
	public void putHandcuff() {
		System.out.println("수갑채움~!넌콩밥~!");
		handCuffs--; 
	}
	//권총을 발사하는 행위를 표현 
	public void shut() {
		//조건문을 통해 소유한 총이 있을때만 발사할 수 있다. 
		if(gun==null) {
			System.out.println("보유한 권총없음. 헛빵~!");
		}
		else {
			gun.shutGun();//권총발사~
		}
	}
}

public class E05HasAComposite {

	public static void main(String[] args) {
		//권총을 보유한 경찰을 표현
		System.out.println("==경찰1==");
		Police police1 = new Police(5, 3);
		police1.shut(); //발사 가능
		police1.putHandcuff();
		
		//권총이 없는 경찰을 표현 
		System.out.println("==경찰2==");
		Police police2 = new Police(0, 3);
		police2.shut(); //발사할 수 없음
		police2.putHandcuff();
	}
}


