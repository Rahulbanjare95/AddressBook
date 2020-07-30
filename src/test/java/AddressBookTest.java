import com.Bridgelabz.main.AddressBook;
import com.Bridgelabz.models.Person;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
    @Test
    public void givenAJsonFile_WhenAddedInDirectory_ShouldReturnTrue() {
        AddressBook addressBookMain = new AddressBook();
        Person person = new Person("Rahul", "Banjare", "Raipur", "Chhattisgarh", "45321", "8982423482");
        int i = addressBookMain.addPersonInfo(person);
        Assert.assertEquals(1,i);


    }
}
