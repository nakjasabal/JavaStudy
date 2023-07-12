package ex12inheritance;

import java.util.Scanner;
/*
친구를 표현한 최상위 클래스로 해당 프로그램에서는 Friend클래스로
인스턴스 생성은 하지 않는다. 단지 기본정보를 저장하고 상속을 목적으로
정의된 클래스이다. 
이와같이 데이터를 저장하기 위한 용도의 클래스를 가르켜 VO(Value 
Object)라고 한다. 즉 값만 가진 객체라는 뜻이다. 
*/
class Friend {
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
	//멤버변수 전체를 출력하기 위한 멤버메서드 
	public void showAllData() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("주소:"+ addr);
	}
	/* 간략 정보를 출력하기 위한 메서드로 실행부가 없는 상태로 
	정의한다. 해당 프로그램에서는 오버라이딩의 목적으로만 사용하기
	위해 정의한다. */
	public void showBasicInfo() {}
}
//고등학교 친구의 정보를 저장할 클래스 	
class HighFriend extends Friend {
	//확장한 멤버변수 : 별명 
	String nickname; 
	//생성자 : 부모의 생성자를 먼저 호출한후 멤버변수 초기화.
	public HighFriend(String name, String phone, String addr,
			String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	/* 오버라이딩1 : 고딩친구의 전체정보를 출력하기 위해 부모에서 
		정의한 메서드를	super를 통해 호출하고, 자식에서 확장한 
		변수를 추가해서 출력한다. */
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	/* 오버라이딩2 : 자식 클래스에서 오버라이딩하여 재정의한 메서드
	 	로 고딩친구의 간략한 정보를 출력한다. 부모클래스에서는
	 	실행부가 없는 상태로 정의되었다. */
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("별명:"+ nickname);
		System.out.println("전번:"+ phone);
	}
}
//대학교 친구 정보를 저장하기 위한 클래스 
class UnivFriend extends Friend	{
	//확장한 멤버변수로 전공과목을 표현 
	String major;  
	//생성자 
	public UnivFriend(String name, String phone, String addr,
			String major) {
		super(name, phone, addr);
		this.major = major;
	}
	//오버라이딩1,2 역시 HighFriend클래스와 동일한 패턴으로 정의됨
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공:"+ major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
	}
}


//메인클래스
public class E10MyFriendInfoBook {
	/* 메뉴를 출력하는 용도의 메서드로 매개변수, 반환타입이 없는
	형태로 정의한다. main메서드에서 직접 호출하기 위해 static으로
	선언되어있다. */
	public static void menuShow() {
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1.고딩친구입력 ");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력 ");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색 ");
		System.out.print("6.삭제 ");
		System.out.println("7.프로그램종료");
		System.out.print("메뉴선택>>>");
	}
	
	
	/*
	메인 메서드는 해당 프로그램의 시작점(Entry point)이므로 복잡한
	로직의 구성보다는 프로그램의 전반적인 흐름에 대해서만 기술하는것이
	좋다. 
	따라서 선택한 메뉴에 따라 핸들러 클래스의 메서드만 호출하는 
	형태로 구현되어있다.
	 */
	public static void main(String[] args) {	
		//사용자 입력을 위한 인스턴스 생성 
		Scanner scan = new Scanner(System.in);
		//기능을 담당하는 핸들러 클래스의 인스턴스 생성
		FriendInfoHandler handler = 
				new FriendInfoHandler(100);

		/*
		무한루프 조건으로 사용자가 원할때 종료할수 있는 구조를 만들어준다.
		break문은 반복문을 탈출시키는 기능이 있으므로 이와같은 무한루프
		에서 자주 사용한다. 
		for(;;) 문을 통해 무한루프를 구현할 수 있으나 반복의 횟수가 
		명확하지 않은 경우에는 주로 while문을 사용한다.  
		*/
		while(true) {
			//1.메뉴를 출력한다. 
			menuShow();
			
			//2.사용자는 수행할 기능의 메뉴를 선택한다. 
			int choice = scan.nextInt();
			
			//3.선택한 번호에 따라 switch문으로 각 메서드를 
			//호출한다.
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램종료");
				return;
			}////switch 끝
		}////while 끝
	}////main 끝
}////class 끝

class FriendInfoHandler {	
	//생성자
	public FriendInfoHandler(int a) {
		System.out.println("생성자 호출됨");
	}
	//친구 정보 추가
	public void addFriend(int choice) {
		System.out.println("addFriend 호출됨");
	}
	//저장된 연락처 전체정보 출력
	public void showAllData() {
		System.out.println("showAllData 호출됨");
	}
	//저장된 연락처 간략정보 출력
	public void showSimpleData() {
		System.out.println("showSimpleData 호출됨");
	}
	//연락처 정보 검색
	public void searchInfo() {
		System.out.println("searchInfo 호출됨");
	}
	//연락처 정보 삭제
	public void deleteInfo() {
		System.out.println("deleteInfo 호출됨");
	}
}

 

