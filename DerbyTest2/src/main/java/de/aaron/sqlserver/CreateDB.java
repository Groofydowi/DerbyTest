package de.aaron.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	public static final String JDBC_URL = "jdbc:jtds:sqlserver://localhost:51368/Projektmanagement_test;instance=SQLEXPRESS;user=me;password=mine";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("net.sourceforge.jtds.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(JDBC_URL);

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT AuftraggeberID, Name FROM dbo.Auftraggeber")) {

			StringBuilder stringBuilder = new StringBuilder();

			while (resultSet.next()) {

				stringBuilder.setLength(0);

				stringBuilder.append(resultSet.getString("Name")).append("\t")
						.append(resultSet.getString("AuftraggeberID"));

				System.out.println(stringBuilder.toString());
			}

		}

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
