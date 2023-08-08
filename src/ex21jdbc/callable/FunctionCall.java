package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;
 
public class FunctionCall extends IConnectImpl {
	
	//생성자에서는 부모클래스를 통해 DB에 연결한다. 
	public FunctionCall() {
		super("education", "1234");
	}
	
	@Override
	public void execute() {
		try { 
/*
CallableStatement 객체 생성을 위해 prepareCall()을 호출한다. 
이때 Oracle에서 작성한 함수를 호출하기 위해 call 키워드를 사용한다. 
*/
csmt = con.prepareCall("{? = call fillAsterik(?)}");
/* 첫번째 파라미터는 함수 실행후 반환값에 대한 타입을 지정한다. 
Types 클래스의 정적상수를 사용해서 지정하면 된다. */
csmt.registerOutParameter(1, Types.VARCHAR);
/* 두번째 파라미터는 사용자로부터 입력받은 아이디(문자열)에 대한 
설정을 한다. 여기서 입력받은 값은 오라클로 전달된다. */
csmt.setString(2, scanValue("아이디"));
//여기서 함수를 실행한다. 
csmt.execute();
//실행후 반환값은 첫번째 파라미터로 입력되므로 getXX(1)로 출력한다.
System.out.println("함수의반환값:"+ csmt.getString(1));			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new FunctionCall().execute();
	}
}









