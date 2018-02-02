import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import junit.framework.TestCase;

public class TestDerbyDriver extends TestCase {

	public void testLoadClassForName() throws Exception {

		Class<?> clazz = Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		assertNotNull(clazz);
	}

	public void testConncetion() throws Exception {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;user=me;password=mine");

		assertNotNull(connection);
	}

	public void testResultSet() throws Exception {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;user=me;password=mine");

		ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM CHANNELS");

		int counter = 0;
		while (resultSet.next())
			counter++;

		assertEquals(2, counter);

	}
}
