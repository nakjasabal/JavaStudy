package ex21jdbc.v2;

public interface IConnect {
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	void dbExecute();
	void dbClose();
	String inputValue(String title);
}
