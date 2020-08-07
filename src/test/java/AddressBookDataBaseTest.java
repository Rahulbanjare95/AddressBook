import com.Bridgelabz.services.AddressBook;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookDataBaseTest {

    AddressBook  addressBook = new AddressBook();

    @Test
    public void givenQuery_WhenFetchAllDataFromDataBase_ShouldReturnNumberOfRows() {
        int numberOfRows = addressBook.getNumberOfRows();
        Assert.assertEquals(5,numberOfRows);
    }

    @Test
    public void givenQuery_WhenAddedNewPersonInDataBase_ShouldReturnNumberOfEntriesAdded() {
        int entryAdded = addressBook.insertDataInDatabase("insert into person " +
                "(first_name, last_name, city, state, zipcode, phone)" +
                "values('Ayush', 'Agrawal', 'bellandur', 'karnataka', '121100', '9999333111');");
        Assert.assertEquals(1,entryAdded);
    }

    @Test
    public void givenDetails_WhenAddedToAddressBook_ShoulReturnNumberOfEntries() {

    }
}
