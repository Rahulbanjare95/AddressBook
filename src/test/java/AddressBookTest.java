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
                ArrayList<Person> people = addressBookMain.addPersonInformation(person);
                addressBookMain.writeToJson("addressBook.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        public void givenAPersonDetail_WhenAddedAndWrittenJsonUsingGSON_ShouldWriteIntoJsonFile() {
            AddressBook addressBookMain = new AddressBook();
            Person personOne = new Person("Rahul", "Banjare", "Raipur", "Chhattisgarh",
                    "45321", "8982423482");
            Person personTwo = new Person("Shubham", "Kaser", "Janjgir", "Chhattisgarh",
                    "41111", "799001231");
            try {
                addressBookMain.addPersonInformation(personOne);
                addressBookMain.addPersonInformation(personTwo);
                addressBookMain.writeToGson("gsonExample.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

