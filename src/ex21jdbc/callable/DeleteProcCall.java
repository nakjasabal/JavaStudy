package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class DeleteProcCall extends IConnectImpl {

	public DeleteProcCall() {
		super("education", "1234");
	}
	
	@Override
	public void execute() {
		try {
//프로시저 호출을 위한 Callable 객체 생성			
csmt = con.prepareCall("{call MyMemberDelete(?,?)}");
//인파라미터 설정 - 삭제할 아이디를 입력받아서 처리
csmt.setString(1, scanValue("삭제할아이디"));
//아웃파라미터 설정 - 반환값의 타입을 설정 
csmt.registerOutParameter(2, Types.VARCHAR);
//프로시저 실행 
csmt.execute();
//아웃파라미터가 문자형이므로 getString()으로 출력한다. 
System.out.println("삭제프로시저 실행결과:");
System.out.println(csmt.getString(2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}		
	}
	
	public static void main(String[] args) {	
		new DeleteProcCall().execute();
	}
}







