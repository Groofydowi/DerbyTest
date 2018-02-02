package de.aaron.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	public static final String JDBC_URL = "jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		Connection connection = DriverManager.getConnection(JDBC_URL);
		//
		// connection.createStatement()
		// .executeQuery("create table channels(channel varchar(20), topic varchar(20),
		// videoclip varchar(20))");
		//
		// ResultSet resultSet = connection.createStatement()
		// .executeQuery("SELECT channel, topic, videoclip FROM channels");
		//
		// if (!resultSet.next())
		// System.out.println("Leer");
		// else
		// System.out.println("Magische Einträge?");
	}

}
