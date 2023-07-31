package ex21jdbc.statement;

import java.sql.SQLException;

public class SelectQuery extends ConnectDB {

	/* 매개변수가 없는 부모의 기본생성자를 호출해서 DB연결. 
	여기서는 아래 생성자를 주석처리해도 문제없이 실행된다. */
	public SelectQuery() {
		super();
	}
	
	/*
	ResultSet 인터페이스
	: select문 실행시 쿼리의 실행결과를 ResultSet객체를 통해 
	받는다. 결과로 반환된 레코드의 처음부터 끝까지 next()메서드를 
	통해 확인 후 반복 인출한다.
	
	컬럼의 자료형이
		number타입 : getInt()
		char/varchar2타입 : getString()
		date타입 : getDate() 메서드를 통해 출력한다. 
	해당 메서드의 인수는 인덱스(1부터시작) 혹은 컬럼명(or 별칭)을 
	사용할 수 있다. 
	오라클 자료형에 상관없이 getString()으로 모두 출력할 수 있다. 
	*/
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();			 
			String query = "SELECT id, pass, name, regidate,"
				+ " to_char(regidate, 'yyyy.mm.dd hh24:mi') d1 "
				+ " FROM member";
			/*
			쿼리문 실행시 사용하는 메서드
			executeUpdate()
				: insert, update, delete와 같이 기존 레코드
				에 변화가 생기는 경우에 사용한다. 실행후 적용된 
				행의 갯수가 int형으로 반환된다. 			
			executeQuery()
				: select 쿼리문을 실행할때 사용하는 메서드로
				레코드에 영향을 미치지않고, 단순히 조회만 하는경우
				사용한다. 조회한 레코드를 반환값으로 받아야 하므로 
				ResultSet객체가 반환타입으로 정의되어있다. 
			*/
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
		catch(Exception e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();//DB 자원반납
		}
	}
	public static void main(String[] args) {
		SelectQuery selectSQL = new SelectQuery();
		selectSQL.execute();
	}
}




