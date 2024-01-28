package skillup.project02;

import java.util.Scanner;

public class FriendInfoHandler {
	//멤버변수
	private Friend[] myFriends;
	private int numOfFriends;
	//생성자
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];	
		numOfFriends = 0;
	}
	//친구 정보 추가
	public void addFriend(int choice) {
		//System.out.println("addFriend 호출됨");
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		if(choice==1) {
			System.out.print("별명:"); iNickname = scan.nextLine(); 
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends[numOfFriends++] = high;
		}
		else if(choice==2) {  
			System.out.print("전공:"); iMajor = scan.nextLine();
			myFriends[numOfFriends++] = 
				new UnivFriend(iName, iPhone, iAddr, iMajor);
		} 
		System.out.println("##친구정보 입력이 완료되었습니다##");
	}
	//저장된 연락처 전체정보 출력
	public void showAllData() {
		//System.out.println("showAllData 호출됨");
		for(int i=0 ; i<numOfFriends ; i++) {
			if(myFriends[i] instanceof UnivFriend) {
				((UnivFriend)myFriends[i]).showAllData();			
			}
			else if (myFriends[i] instanceof HighFriend) {
				((HighFriend)myFriends[i]).showAllData();	
			}
		}
		System.out.println("##전체정보가 출력되었습니다##");
	}
	//저장된 연락처 간략정보 출력
	public void showSimpleData() {
		//System.out.println("showSimpleData 호출됨");
		for(int i=0 ; i<numOfFriends ; i++) {
			if(myFriends[i] instanceof UnivFriend) {
				((UnivFriend)myFriends[i]).showBasicInfo();				
			}
			else if (myFriends[i] instanceof HighFriend) {
				((HighFriend)myFriends[i]).showBasicInfo();	
			}
		}
		System.out.println("##간략정보가 출력되었습니다##");
	}
	//연락처 정보 검색
	public void searchInfo() {
		//System.out.println("searchInfo 호출됨");
		boolean isFind = false;		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();		

		for(int i=0 ; i<numOfFriends ; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {	 
				if(myFriends[i] instanceof UnivFriend) {
					((UnivFriend)myFriends[i]).showAllData();			
				}
				else if (myFriends[i] instanceof HighFriend) {
					((HighFriend)myFriends[i]).showAllData();	
				}
				System.out.println("##귀하가 요청하는 정보를 찾았습니다.##");
				isFind = true; 
			}
		}		
		if(isFind==false)
			System.out.println("##찾는 정보가 없습니다.##");
	}
	//연락처 정보 삭제
	public void deleteInfo() {
		//System.out.println("deleteInfo 호출됨");
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		int deleteIndex = -1; 
		
		for(int i=0 ; i<numOfFriends ; i++) {
			if(deleteName.equals(myFriends[i].name)) {
				myFriends[i] = null;
				deleteIndex = i;
				numOfFriends--;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("##삭제된 데이터가 없습니다##");
		}
		else {
			for(int i=deleteIndex ; i<numOfFriends ; i++) {
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("##데이터("+ deleteIndex
					+"번)가 삭제되었습니다##");
		}
	}
}