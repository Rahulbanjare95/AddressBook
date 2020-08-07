import com.Bridgelabz.databaseUtility.DataBaseConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionTest {
    Connection connection;
    @Before
    public void before() {
      connection = DataBaseConnection.getConnection();
    }

    @After
    public void after() {
        DataBaseConnection.closeConnection(connection);
    }

    @Test
    public void givenOpenConnection_whenTestedForClose_shouldReturnFalse() {
        try {
            boolean closed = connection.isClosed();
            Assert.assertFalse(closed);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void givenAConnectionToClose_WhenCheckedForClosed_ShouldReturnTrue() {
        try {
            DataBaseConnection.closeConnection(connection);
            boolean closed = connection.isClosed();
            Assert.assertTrue(closed);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
