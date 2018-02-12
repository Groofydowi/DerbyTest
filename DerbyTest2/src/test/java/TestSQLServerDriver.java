import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import junit.framework.TestCase;

public class TestSQLServerDriver extends TestCase {
	public void testLoadClassForName() throws Exception {

		Class<?> clazz = Class.forName("net.sourceforge.jtds.jdbc.Driver");
		assertNotNull(clazz);
	}

	public void testLocalhostConnection() throws Exception {

		Socket socket = new Socket("localhost", 1433);
		socket.getInputStream().read();

		socket.close();

	}

	public void testConncetion() throws Exception {

		Class.forName("net.sourceforge.jtds.jdbc.Driver");

		Connection connection = DriverManager.getConnection(
				"jdbc:jtds:sqlserver://localhost:51368/Projektmanagement_test;instance=SQLEXPRESS;user=torsten;password=torsten");

		assertNotNull(connection);
	}

	public void testResultSet() throws Exception {

		Class.forName("net.sourceforge.jtds.jdbc.Driver");

		Connection connection = DriverManager.getConnection(
				"jdbc:jtds:sqlserver://localhost:51368/Projektmanagement_test;instance=SQLEXPRESS;user=torsten;password=torsten");

		ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM Auftraggeber");

		int counter = 0;
		while (resultSet.next())
			counter++;

		assertEquals(38, counter);

	}
}
