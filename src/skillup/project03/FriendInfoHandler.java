package skillup.project03;

import java.util.Scanner;

public class FriendInfoHandler {	
	private Friend[] myFriends;
	private int numOfFriends;
	
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];	
		numOfFriends = 0;
	}

	public void addFriend(int choice) {
		//System.out.println("addFriend 호출됨");
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		if(choice==1) {
			System.out.print("별명:"); iNickname = scan.nextLine(); 
			HighFriend high = new HighFriend(iName, iPhone, iAddr, 
					iNickname);
			myFriends[numOfFriends++] = high;
		}
		else if(choice==2) {  
			System.out.print("전공:"); iMajor = scan.nextLine();
			myFriends[numOfFriends++] = 
				new UnivFriend(iName, iPhone, iAddr, iMajor);
		} 
		System.out.println("##친구정보 입력이 완료되었습니다##");
	}
	
	public void showAllData() {
		//System.out.println("showAllData 호출됨");
		for(int i=0 ; i<numOfFriends ; i++) {
			myFriends[i].showAllData();
		}
		System.out.println("##전체정보가 출력되었습니다##");
	}
	
	public void showSimpleData() {
		//System.out.println("showSimpleData 호출됨");
		for(int i=0 ; i<numOfFriends ; i++) {			
			myFriends[i].showBasicInfo();
		}
		System.out.println("##간략정보가 출력되었습니다##");
	}

	public void searchInfo() {
		//System.out.println("searchInfo 호출됨");
		boolean isFind = false;		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();		
		
		for(int i=0 ; i<numOfFriends ; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {	 
				myFriends[i].showAllData();
				System.out.println("##요청하신 정보를 찾았습니다##");
				isFind = true; 
			}
		}		
		if(isFind==false)
			System.out.println("##찾는 정보가 없습니다##");
	}

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

