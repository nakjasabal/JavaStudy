package skillup.project06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	//프로그램 종료시 친구의 정보를 직렬화한다. 
	public void saveFriendInfo() {
		try {
			//친구 정보를 파일에 저장하기 위한 출력스트림을 생성한다.
			ObjectOutputStream out =
				new ObjectOutputStream(
					new FileOutputStream("src/skillup/project06/friend_info.obj")
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
					new FileInputStream("src/skillup/project06/friend_info.obj")
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