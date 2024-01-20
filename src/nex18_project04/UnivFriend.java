package nex18_project04;

public class UnivFriend extends Friend	{
	String major;  
	
	public UnivFriend(String name, String phone, String addr,
			String major) {
		super(name, phone, addr);
		this.major = major;
	}
	
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println(", 전공:"+ major);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.print("이름:"+ name);
		System.out.print(", 전공:"+ major);
		System.out.println(", 전화번호:"+ phone);
	}
}

