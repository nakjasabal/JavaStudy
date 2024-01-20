package nex24_project05;

/*
친구를 표현한 최상위 클래스로 해당 프로그램에서는 Friend클래스로
인스턴스 생성은 하지 않는다. 단지 기본정보를 저장하고 상속을 목적으로
정의된 클래스이다. 
이와같이 데이터를 저장하기 위한 용도의 클래스를 가르켜 VO(Value 
Object)라고 한다. 즉 값만 가진 객체라는 뜻이다. 
*/
abstract public class Friend implements IFriend {
	//멤버변수 : 이름, 전화번호, 주소 기본정보 3가지를 저장.
	String name;
	String phone;
	String addr;
	//생성자 : 멤버변수 초기화.
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

	@Override
	public void showAllData() {
		System.out.print("이름:"+ name);
		System.out.print(", 전화번호:"+ phone);
		System.out.print(", 주소:"+ addr);
	}

	@Override
	public void showBasicInfo() {}
}