package ex21jdbc.v2;

import java.sql.SQLException;

public class SQLinsert extends MyConnection {

	public SQLinsert(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			stmt = con.createStatement();
			query = "INSERT INTO member VALUES "
					+ " ('test3', '3333', '테스터3', sysdate)";
			result = stmt.executeUpdate(query);
			System.out.println("[stmt]"+ result +"행 입력됨");
			
			/////////////////////////////////////////////////////////
			
			query = "INSERT INTO member VALUES (?, ?, ?, sysdate)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, inputValue("아이디"));
			psmt.setString(2, inputValue("패스워드"));
			psmt.setString(3, inputValue("이름"));
			result = psmt.executeUpdate();
			System.out.println("[psmt]"+ result +"행 입력됨");
		}
		catch (SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SQLinsert("study", "1234").dbExecute();
	}
}
