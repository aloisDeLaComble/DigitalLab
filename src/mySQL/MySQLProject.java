package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojos.Project;

//import com.mysql.jdbc.Driver;

public class MySQLProject {
	public static Project GetLastProject() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			String connectionUrl = "jdbc:mysql://localhost:3306/DigitalLabDB";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM projects");
			String id = "Rien";
			String name = "Nada";
			while (rs.next()) {
				id = rs.getString("id");
				name = rs.getString("name");
				System.out.println("ID: " + id + ", Name: " + name);
			}
			String ret = "ID: " + id + ", Name: " + name;
			Project project = new Project(Integer.parseInt(id), name);
			return project;
		} catch (Exception e) {
			e.printStackTrace();
			Project project = new Project(100, "Failed");
			return project;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}
