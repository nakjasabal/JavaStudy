package ex21jdbc.v2;

import java.sql.SQLException;

public class SQLselect1 extends MyConnection {
	
	public SQLselect1(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			stmt = con.createStatement();			 
			String query = "SELECT id, pass, name, regidate,"
				+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') d1 "
				+ " FROM member";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1);//id컬럼
				String pw = rs.getString("pass");
				String name = rs.getString("name");				
			 
				/* 오라클의 date타입을 getDate()로 인출하면 0000-00-00형태로
				출력된다. 또한 자료형이 Date이므로 java.sql패키지의 클래스를
				사용해야한다. */ 
				java.sql.Date regidate = rs.getDate("regidate");
				
				/* 날짜를 getString()으로 인출하면 시간까지 포함되서 출력된다. 
				0000-00-00 00:00:00 형식이므로 적당한 크기로 자르고 싶다면
				substring() 메서드를 사용하면된다. */
				String regidate2 = rs.getString("regidate");
				String regidate3 = rs.getString("regidate").substring(0,13);
				
				/* 오라클의 변환함수를 통해 출력하고자 하는 형태로 포매팅한후 
				문자형식으로 출력한다. 쿼리문에 별칭을 사용한경우 그대로 사용할수
				있다. 즉 컬럼명, 인덱스, 별칭을 통해 컬럼을 지정할 수 있다. */
				String regidate4 = rs.getString("d1");

				System.out.printf("%s %s %s %s %s %s %s\n",
						id, pw, name, regidate, 
						regidate2, regidate3, regidate4);
			}
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
