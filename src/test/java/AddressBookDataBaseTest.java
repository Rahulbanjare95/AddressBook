import com.Bridgelabz.services.AddressBook;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AddressBookDataBaseTest {

    AddressBook  addressBook = new AddressBook();

    @Test
    public void givenQuery_WhenFetchAllDataFromDataBase_ShouldReturnNumberOfRows() {
        int numberOfRows = addressBook.getNumberOfRows("select * from person");
        Assert.assertEquals(3,numberOfRows);
    }

    @Test
    public void givenQuery_WhenAddedNewPersonInDataBase_ShouldReturnNumberOfEntriesAdded() {
        int entry = addressBook.insertDataInDatabase("insert into person " +
                "(first_name, last_name, city, state, zipcode, phone)" +
                "values('Prashant', 'Jain', 'bengalore', 'karnataka', '343213', '10000000000');");
        Assert.assertEquals(1,entry);

    }
}
