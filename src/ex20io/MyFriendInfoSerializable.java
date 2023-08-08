package ex20io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
현재 추가되는 정보는 List에 저장된다. 프로그램을 종료하면 저장된 내용이
소멸되므로, 재시작시 정보를 처음부터 다시 입력해야하는 불편함이 있다.
Serializable 인터페이스를 이용한 직렬화로 친구들의 정보를 파일로 저장해보자.   

연습문제1] 친구의 정보를 파일로 직렬화하기 위한 메서드를 정의하시오.
	-메서드명 : saveFriendInfo()
	-저장할 파일명 : myfriend_info.obj
	-메뉴 '7.프로그램종료'을 선택한 경우 실행하면 된다. 
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다. 

연습문제2] 프로그램을 다시 시작하면 문제1에서 직렬화 했던 파일을 
	역직렬화해서 복원하시오. 만약 3명의 정보가 저장되었다면 다시 
	시작한 직후 정보출력을 하면 3명의 정보가 출력되어야 한다. 
	메서드명 : readFriendInfo()
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다.
 */

class Friend implements Serializable {
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
		System.out.print("이름:"+ name);
		System.out.print(", 전화번호:"+ phone);
		System.out.print(", 주소:"+ addr);
	}
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
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println(", 별명:"+ nickname);
	}
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
		System.out.println(", 전공:"+ major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
	}
}

//메인클래스
public class MyFriendInfoSerializable {
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
 
	public static void main(String[] args) {	
		//사용자 입력을 위한 인스턴스 생성 
		Scanner scan = new Scanner(System.in);
		
		/* 기능을 담당하는 핸들러 클래스의 인스턴스 생성. 컬렉션은 인스턴스 생성시
		크기를 지정할 필요가 없다. 데이터의 갯수에 따라 자동으로 증가된다.*/ 
		FriendInfoHandler handler = new FriendInfoHandler();
		
		/* 프로그램 시작시 직렬화된 파일이 있다면 즉시 복원하여 컬렉션에
		저장한다.*/ 
		handler.readFriendInfo();

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
				/*
				프로그램이 종료되는 시점에 컬렉션에 저장된 객체를 
				파일의 형태로 저장 즉 직렬화해야한다. 
				핸들러 클래스에 정의된 메서드를 호출한다. 
				 */
				handler.saveFriendInfo();
				return;
			}////switch 끝
		}////while 끝
	}////main 끝
}////class 끝

class FriendInfoHandler {	
	//멤버변수	
//	private Friend[] myFriends;
//	private int numOfFriends;	
	
	/* 기존에 인스턴스배열에 저장했던것을 컬렉션으로 변경한다. 컬렉션은 제네릭을
	기반으로 하므로 인스턴스 생성시 저장할 객체의 타입을 결정하게된다. 여기서는
	Friend클래스를 상속한 High, Univ를 저장할 것이므로 아래와 같이 선언하면된다.*/
	ArrayList<Friend> myFriends;
	
	//생성자 : 컬렉션은 데이터 저장시 자동인덱싱이 되므로 크기는 필요없다. 
	public FriendInfoHandler() {
//		myFriends = new Friend[num];	
//		numOfFriends = 0;
		//생성자에서 정보를 저장할 List계열의 컬렉션을 생성한다. 
		myFriends = new ArrayList<Friend>();
	}
	
	/*
	 * 연습문제] List컬렉션을 기반으로 친구(고딩/대딩) 정보를 
	 * 	추가하는 프로그램을 작성하시오. 1차는 추가/출력1/출력2
	 * 	까지 진행합니다. 
	 * 	출력1은 확장 for문을 통해 구현하세요.
	 * 	출력2는 이터레이터를 통해 구현하세요. 
	 * */
	//친구 정보 추가
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		//공통정보를 입력받는다. 
		System.out.print("이름:");
		iName = scan.nextLine();
		System.out.print("전화번호:");
		iPhone = scan.nextLine();
		System.out.print("주소:");
		iAddr = scan.nextLine();
		if(choice==1) {
			//고딩친구 정보 추가
			System.out.print("별명:");
			iNickname = scan.nextLine();
			/* High인스턴스를 생성한다. 해당 인스턴스는 자신의
			타입이나 부모타입인 Friend에 저장할 수 있다. */
			Friend f = 
				new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends.add(f);
		}
		else if(choice==2) {
			//대딩친구 정보 추가 
			System.out.print("전공:");
			iMajor = scan.next();
			//Univ인스턴스 생성
			myFriends.add(
				new UnivFriend(iName, iPhone, iAddr, iMajor));
		}
		/* 기존 객체배열은 정보를 추가할때마다 인덱싱을 위해
		변수를 ++하는 부분이 필요했지만, List의 경우 자동인덱싱을
		지원하므로 단지 추가만 해주면 된다. 추가시에는 add()를
		사용한다. */
	}	 
	//저장된 연락처 전체정보 출력(확장for문 사용)
	public void showAllData() {
		/*
		확장for문의 형식
		=> for(저장된타입 참조변수 : 반복할 배열 혹은 컬렉션)
		*/
		for(Friend fr : myFriends) {
			fr.showAllData();
		}
	}
	//저장된 연락처 간략정보 출력(이터레이터 사용)
	public void showSimpleData() {
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			itr.next().showBasicInfo();
		}
	}
	
	/**********************************************/
	/*
	연습문제] 이름을 입력받아 연락처를 검색하는 메서드를 작성하시오. 
	*/
	//연락처 정보 검색
	public void searchInfo() {
		boolean isFind = false;		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();		
		
		//저장된 갯수만큼 반복해서 검색 
		for(Friend fr : myFriends) {
			//입력한 이름과 일치하는 항목을 찾는다. 
			if(searchName.equals(fr.name)) {
				fr.showAllData();
				isFind = true;
			}
		}	
		
		if(isFind==true) 
			System.out.println("일치하는 정보를 찾았습니다.");
		else
			System.out.println("일치하는 정보가 없습니다.");
	}
	
	/* 오늘의숙제] 삭제할 이름을 입력받은 후 삭제하는 메서드를
	 	구현하시오. */
	//연락처 정보 삭제
	public void deleteInfo() {
		boolean isFind = false;		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			//해당 루프의 객체 참조값을 변수에 저장한다.
			Friend fr = itr.next();
			//이름이 일치하는지 확인한다. 
			if(fr.name.equals(deleteName)) {
				//참조값을 통해 객체를 삭제한다. 
				myFriends.remove(fr);
				isFind = true;
				//삭제후 루프를 탈출한다. 
				break;
			}
		}
		
		if(isFind==true)
			System.out.println("삭제되었습니다.");
		else
			System.out.println("검색된 이름이 없습니다.");
	}
	
	
	//프로그램 종료시 친구의 정보를 직렬화한다. 
	public void saveFriendInfo() {
		try {
			//친구 정보를 파일에 저장하기 위한 출력스트림을 생성한다.
			ObjectOutputStream out =
				new ObjectOutputStream(
					new FileOutputStream("src/ex20io/friend_info.obj")
				);
			
			//List<E> 컬렉션에 저장된 친구정보의 갯수만큼 반복하여..
			for(Friend fr : myFriends) {
				//파일에 저장한다. 즉 직렬화한다.
				out.writeObject(fr);
			}
		}
		catch (Exception e) {
			System.out.println("친구정보 직렬화 중 예외발생");
		}		
	}

	//프로그램이 시작되면 저장된 파일을 통해 복원한 후 컬렉션에 추가한다.
	public void readFriendInfo() {
		try {
			//파일을 복원(역직렬화)하기 위해 스트림을 생성한다. 
			ObjectInputStream in =
				new ObjectInputStream(
					new FileInputStream("src/ex20io/friend_info.obj")
				);
			//파일에 친구의 정보가 몇개 저장되었는지 확인할수 없으므로
			//무한루프로 구성한다. 
			while(true) {			
				//직렬화될때 Object기반으로 저장되므로 역직렬화할때는
				//반드시 다운캐스팅 해야한다. 
				Friend fr = (Friend) in.readObject();
				//List<E> 컬렉션에 추가한다. 
				myFriends.add(fr);			
				//만약 더이상 복원할 객체가 없다면 예외가 발생한다. 
			}
		}
		catch (Exception e) {
			//예외가 발생하면 catch절로 예외객체가 던져지므로 while루프를
			//탈출할 수 있다. 
			System.out.println("더 이상 복원할 객체가 없습니다.");
			e.printStackTrace();
		}		
		System.out.println("친구의 정보가 복원되었습니다.");
	}
}







