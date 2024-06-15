package skillup.project06;

import java.util.Scanner;

//메인클래스
public class MyFriendInfoBook {
	/* 메뉴를 출력하는 용도의 메서드로 매개변수, 반환타입이 없는
	형태로 정의한다. main메서드에서 직접 호출하기 위해 static으로
	선언되어있다. */
	public static void menuShow() {
		System.out.println("######## 메뉴를 입력하세요(ver06) ########");
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
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		/* 프로그램 시작시 직렬화된 파일이 있다면 즉시 복원하여 컬렉션에
		저장한다.*/ 
		handler.readFriendInfo();

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

