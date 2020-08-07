import com.Bridgelabz.databaseUtility.DataBaseConnection;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionTest {

    @Test
    public void givenOpenConnection_whenTestedForClose_shouldReturnFalse() {
        Connection connection = DataBaseConnection.getConnection();
        try {
            boolean closed = connection.isClosed();
            Assert.assertFalse(closed);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void givenAConnectionToClose_WhenCheckedForClosed_ShouldReturnTrue() {
        Connection connection = DataBaseConnection.getConnection();
        try {
            connection.close();
            boolean closed = connection.isClosed();
            Assert.assertTrue(closed);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
