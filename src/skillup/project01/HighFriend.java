package skillup.project01;
 
public class HighFriend  {
	public String name;
	public String phone;
	public String addr;
	public String nickname; 
	 
	public HighFriend(String name, String phone, String addr, String nickname) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.nickname = nickname;
	}

	void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		System.out.print("이름:"+ name);
		System.out.print(", 전화번호:"+ phone);
		System.out.print(", 주소:"+ addr);
		System.out.println(", 별명:"+ nickname);
	}
	 
	void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.print("별명:"+ nickname);
		System.out.println(", 전번:"+ phone);
	}
}