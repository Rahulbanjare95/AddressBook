import com.Bridgelabz.main.AddressBook;
import com.Bridgelabz.models.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTest {
    @Test
    public void givenAPersonDetail_WhenAdded_ShouldWriteIntoJsonFile() {
        AddressBook addressBookMain = new AddressBook();
        Person person = new Person("Rahul", "Banjare", "Raipur", "Chhattisgarh", "45321", "8982423482");
        try {
            ArrayList<Person> people = addressBookMain.addPersonInfo(person);
            addressBookMain.writeToJson("addressBook.json");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
