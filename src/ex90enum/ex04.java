package ex90enum;

class Customer {
	enum Gender {
		MALE, FEMALE
	}
	
	private String name;
	private Gender gender;
	
	public Customer(String n, String g) {
		name = n;
		if(g.equals("man"))
			gender = Gender.MALE;
		else
			gender = Gender.FEMALE;
	}
	
	@Override
	public String toString() {
		if(gender==Gender.MALE)
			return "Thank you, Mr "+ name;
		else
			return "Thank you , Mrs " + name;
	}
}

public class ex04 {

	public static void main(String[] args) {
		Customer c1 = new Customer("이수일", "man");
		Customer c2 = new Customer("심순애", "woman");
		
		System.out.println(c1);
		System.out.println(c2);
	}

}
