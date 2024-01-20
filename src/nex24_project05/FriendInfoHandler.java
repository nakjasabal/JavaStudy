package nex24_project05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FriendInfoHandler {	
	//멤버변수	
	private ArrayList<Friend> myFriends;
	//생성자
	public FriendInfoHandler(int num) {
		myFriends = new ArrayList<>();
	}
	//친구 정보 추가
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		if(choice==1) {
			System.out.print("별명:"); iNickname = scan.nextLine(); 
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends.add(high);
		}
		else if(choice==2) {  
			System.out.print("전공:"); iMajor = scan.nextLine();
			myFriends.add(new UnivFriend(iName, iPhone, iAddr, iMajor));
		} 
		System.out.println("##친구정보 입력이 완료되었습니다##");
	}
	//저장된 연락처 전체정보 출력
	public void showAllData() {
		for(int i=0 ; i<myFriends.size() ; i++) {
			myFriends.get(i).showAllData();
		}
		System.out.println("##전체정보가 출력되었습니다##");
	}
	//저장된 연락처 간략정보 출력
	public void showSimpleData() {
		for(Friend friend : myFriends) {			
			friend.showBasicInfo();
		}
		System.out.println("##간략정보가 출력되었습니다##");
	}
	//연락처 정보 검색
	public void searchInfo() {
		boolean isFind = false;		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();		
		
		Iterator<Friend> itr = myFriends.iterator();
		while(itr.hasNext()) {
			Friend friend = itr.next();
			if(searchName.compareTo(friend.name)==0) {	 
				friend.showAllData();
				System.out.println("##귀하가 요청하는 정보를 찾았습니다##");
				isFind = true; 
			}
		}		
		if(isFind==false)
			System.out.println("##찾는 정보가 없습니다##");
	}
	//연락처 정보 삭제
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		int deleteIndex = -1; 
		
		for(Friend friend : myFriends) {	
			if(deleteName.equals(friend.name)) {
				myFriends.remove(friend);
				deleteIndex = 0;
				break;
			}
		}
		
		if(deleteIndex==-1) {
			System.out.println("##삭제된 데이터가 없습니다##");
		}
		else {
			System.out.println("##삭제되었습니다##");
		}
	}
}