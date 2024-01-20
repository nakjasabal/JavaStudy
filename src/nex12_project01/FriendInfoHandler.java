package nex12_project01;

import java.util.Scanner;

/* 해당 프로그램에서 기능을 담당하는 클래스로 핸들러 혹은 메니져
클래스라고 부른다. */
public class FriendInfoHandler {	
	 
	private HighFriend[] highFriends;	
	private int numOfhighFriend;
	private UnivFriend[] univFriends;	
	private int numOfunivFriend;
	
	public FriendInfoHandler(int num) {
		highFriends = new HighFriend[num];	
		numOfhighFriend = 0;
		univFriends = new UnivFriend[num];	
		numOfunivFriend = 0;
	}
 
	public void addFriend(int choice) {
		//System.out.println("## addFriend 호출됨 ##");
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		if(choice==1) {
			System.out.print("별명:"); iNickname = scan.nextLine(); 
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			highFriends[numOfhighFriend++] = high;
		}
		else if(choice==2) {  
			System.out.print("전공:"); iMajor = scan.nextLine();
			univFriends[numOfunivFriend++] = 
				new UnivFriend(iName, iPhone, iAddr, iMajor);
		} 
		System.out.println("##친구정보 입력이 완료되었습니다##");
	}
 
	public void showAllData() {
		//System.out.println("## showAllData 호출됨 ##");
		//고딩친구반복
		for(int i=0 ; i<numOfhighFriend ; i++) {
			highFriends[i].showAllData();
		}
		//대딩친구반복
		for(int i=0 ; i<numOfunivFriend ; i++) {
			univFriends[i].showAllData();
		}
		System.out.println("##전체정보가 출력되었습니다##");
	}
	
	//저장된 연락처 간략정보 출력
	public void showSimpleData() {
		//System.out.println("## showSimpleData 호출됨 ##");
		//고딩친구반복
		for(int i=0 ; i<numOfhighFriend ; i++) {
			highFriends[i].showBasicInfo();
		}
		//대딩친구반복
		for(int i=0 ; i<numOfunivFriend ; i++) {
			univFriends[i].showBasicInfo();
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
		
		//고딩친구반복
		for(int i=0 ; i<numOfhighFriend ; i++) {
			if(searchName.compareTo(highFriends[i].name)==0) {	 
				highFriends[i].showAllData();
				System.out.println("##귀하가 요청하는 정보를 찾았습니다.##");
				isFind = true; 
			}
		}
		//대딩친구반복
		for(int i=0 ; i<numOfunivFriend ; i++) {
			if(searchName.compareTo(highFriends[i].name)==0) {	 
				univFriends[i].showAllData();
				System.out.println("##귀하가 요청하는 정보를 찾았습니다.##");
				isFind = true; 
			}
		}
		
		//만약 검색결과가 없다면 아래와 같이 출력한다. 
		if(isFind==false)
			System.out.println("##찾는 정보가 없습니다.##");
	}
	//연락처 정보 삭제
	public void deleteInfo() {
		//System.out.println("## deleteInfo 호출됨 ##");
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		int deleteIndexHigh = -1; 
		int deleteIndexUniv = -1; 
		
		//고딩친구반복
		for(int i=0 ; i<numOfhighFriend ; i++) {
			if(deleteName.equals(highFriends[i].name)) {
				highFriends[i] = null;
				deleteIndexHigh = i;
				numOfhighFriend--;
				break;
			}
		}
		//대딩친구반복
		for(int i=0 ; i<numOfunivFriend ; i++) {
			if(deleteName.equals(univFriends[i].name)) {
				univFriends[i] = null;
				deleteIndexUniv = i;
				numOfunivFriend--;
				break;
			}
		}
		
		if(deleteIndexHigh!=-1) {
			//고딩 친구 정보가 삭제되었을때 배열 정리
			for(int i=deleteIndexHigh ; i<numOfhighFriend ; i++) {
				highFriends[i] = highFriends[i+1];
			}
			System.out.println("##데이터("+ deleteIndexHigh
					+"번)가 삭제되었습니다##");
		}
		else if(deleteIndexUniv!=-1) {
			//대딩 친구 정보가 삭제되었을때 배열 정리
			for(int i=deleteIndexUniv ; i<numOfunivFriend ; i++) {
				univFriends[i] = univFriends[i+1];
			}
			System.out.println("##데이터("+ deleteIndexUniv
					+"번)가 삭제되었습니다##");
		}
		else {
			System.out.println("##삭제된 데이터가 없습니다##");
		}
	}
}