package server.repository;

import org.junit.jupiter.api.*;
import server.entity.Contact;
import server.utils.Constants;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactRepositoryTest {

    private static ContactRepository repository;
    private static Contact contact;
    private static Long id;

    @BeforeAll
    static void setUp() {
        repository = new ContactRepository();
        contact = new Contact("Barbarella","0995480666");
    }

    @Test
    @Order(1)
    @DisplayName("Create new contact in database and verify that it is created")
    void Add_New_Contact_To_Repository_And_Verify_It_Is_Created() {
        String successMessage = repository.create(contact);
        assertEquals(Constants.DATA_INSERT_MSG,successMessage);

        List<Contact> resultAsList = repository.read().get();
        Contact lastAddedContact = resultAsList.get(resultAsList.size()-1);
        id = lastAddedContact.getId();
        assertTrue(contact.equals(lastAddedContact));
    }

    @Test
    @Order(2)
    @DisplayName("Update contact details and verify the update")
    void Update_Contact_Details() {
        Contact updatedContact = new Contact(id,"Sarah O'Connor","0995677454");
        repository.update(updatedContact);
        Contact updatedContactFromDB = repository.readById(id).get();
        assertTrue(updatedContact.equals(updatedContactFromDB));
    }

    @Test
    @Order(3)
    @DisplayName("Delete contact and verify that it is deleted")
    void Delete_Contact() {
        assertEquals(Constants.DATA_DELETE_MSG, repository.delete(id));
        assertTrue(repository.readById(id).isEmpty());
    }

    @AfterAll
    static void tearDown() {
        repository = null;
        contact = null;
        id = null;
    }
}