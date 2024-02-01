package ex21jdbc.v2;

import java.sql.SQLException;

public class SQLupdate extends MyConnection {
	
	public SQLupdate(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			stmt = con.createStatement();
			query = "UPDATE member "
					+ " SET "
					+ " 	pass='0412',"
					+ "		name='성유겸',"
					+ "		regidate=sysdate "
					+ " WHERE id='test99' ";
			result = stmt.executeUpdate(query);
			System.out.println("[stmt]"+ result +"행 업데이트 됨");
			
			//////////////////////////////////////////////////try {
			
			query = "UPDATE member "
					+ " SET name=?, pass=? "
					+ " WHERE id=?";
			psmt = con.prepareStatement(query);
			while(true) {
				psmt.setString(3, inputValue("수정할 아이디"));
				psmt.setString(1, inputValue("이름"));
				psmt.setString(2, inputValue("패스워드"));
				result = psmt.executeUpdate();
				System.out.println("[psmt]"+ result +"행 업데이트됨");
			}
		}
		catch (SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SQLupdate("study", "1234").dbExecute();
	}
}
