package hcmute.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionSQLServer {
	private final String serverName = "DESKTOP-FEGO3NS\\SQLSERVER_DEV";
	private final String dbName = "QLBanHang";
	private final String portNumber = "1433";

	private final String userID = "sa";
	private final String password = "sqlserverdeveloper";

	// Kết nối SQL Server với username, password
	public Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
				+ ";databaseName=" + dbName;
		

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectionSQLServer().getConnectionW());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
