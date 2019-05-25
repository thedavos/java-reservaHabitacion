package utils;

//Mysql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public String driver = "com.mysql.jdbc.Driver";
	public String database = "RESERVA";
	public String hostname = "localhost";
	public String port = "3306";
	public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";;
	public String username = "davos";
	public String password = "domi123";

	@SuppressWarnings("finally")
	public Connection connectionMySQL() {
		Connection conn = null;

		 try {
		   Class.forName(driver);
		   conn = DriverManager.getConnection(url, username, password);
		 } catch (ClassNotFoundException | SQLException e) {
		   e.printStackTrace();
		 } finally {
		 	return conn;
		}
	}
}
