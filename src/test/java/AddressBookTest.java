import com.Bridgelabz.main.AddressBook;
import com.Bridgelabz.main.exceptions.AddressBookException;
import com.Bridgelabz.models.Person;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
    @Test
    public void givenAPersonDetail_whenAddedTwoTimes_ShouldThrowException() {
        AddressBook addressBookMain = new AddressBook();
        Person person = new Person("Rahul", "Banjare", "Raipur", "Chhattisgarh", "45321", "8982423482");
        Person personone = new Person("Rahul", "Banjare", "Raipur", "Chhattisgarh", "45321", "8982423482");
        try {
            addressBookMain.addPersonInfo(person);
            addressBookMain.addPersonInfo(personone);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.ALREADY_PRESENT,e.type);
        }
    }

    @Test
    public void givenAPersonDetail_when() {
    }
}
