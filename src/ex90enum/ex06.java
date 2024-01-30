package ex90enum;

enum DevType {
	WEB("Spring Boot"), MOBILE("Flutter"), SERVER("AWS");
	
	private String dtName;

	//생성자를 private으로 선언해서 new Instance를 할수없게한다. 
	//public 생성자는 선언할 수 없다. 
	private DevType(String dtName) {
		this.dtName = dtName;
	}

	public String getDtName() {
		return dtName;
	}
}

public class ex06 {

	public static void main(String[] args) {

		System.out.println(DevType.WEB.getDtName());
		System.out.println(DevType.MOBILE.getDtName());
		System.out.println(DevType.SERVER.getDtName());
	}

}
