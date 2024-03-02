package server.service;

import jakarta.jws.WebService;
import server.entity.Contact;
import server.exceptions.ContactException;
import server.repository.ContactRepository;
import server.utils.AppValidator;
import server.utils.Constants;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@WebService(endpointInterface = "server.service.DataService")

public class DataServiceImpl  implements DataService {

    ContactRepository repository = new ContactRepository();

    @Override
    public String create(String[] data) {
        Map<String, String> errors =
                new AppValidator().validateContactDataCreate(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactException("Check inputs", errors);
            } catch (ContactException e) {
                return e.getErrors(errors);
            }
        }
        Contact contact = new Contact();
        contact.setName(data[0]);
        contact.setPhone(data[1]);
        return repository.create(contact);
    }

    @Override
    public String read() {
        Optional<List<Contact>> optional = repository.read();
        if (optional.isPresent()) {
            List<Contact> list = optional.get();
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder sb = new StringBuilder();
                list.forEach(Contact ->
                        sb.append(String.format("%d) %s%n",
                                count.incrementAndGet(), Contact.toString()))
                );
                return sb.toString();
            } else return Constants.NO_DATA_MSG;
        } else return Constants.NO_DATA_MSG;
    }

    @Override
    public String update(String[] data) {
        Map<String, String> errors =
                new AppValidator().validateContactDataUpdate(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactException("Check inputs", errors);
            } catch (ContactException e) {
                return e.getErrors(errors);
            }
        }
        Contact contact = new Contact();
        contact.setId(Long.parseLong(data[0]));
        contact.setName(data[1]);
        contact.setPhone(data[2]);
        return repository.update(contact);
    }

    @Override
    public String delete(String[] data) {
        Map<String, String> errors =
                new AppValidator().validateContactDataDelete(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactException("Check inputs", errors);
            } catch (ContactException e) {
                return e.getErrors(errors);
            }
        }
        return repository.delete(Long.parseLong(data[0]));
    }

    @Override
    public String readById(String[] data) {
        Map<String, String> errors =
                new AppValidator().validateContactDataReadById(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactException("Check inputs", errors);
            } catch (ContactException e) {
                return e.getErrors(errors);
            }
        }
        // Отримуємо дані
        Optional<Contact> optional =
                repository.readById(Long.parseLong(data[0]));
        // Якщо Optional не містить null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (optional.isPresent()) {
            // Отримуємо об'єкт з Optional
            Contact contact = optional.get();
            return contact.toString();
        } else return Constants.NO_DATA_MSG;
    }

}
