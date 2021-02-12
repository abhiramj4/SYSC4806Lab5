package ThanosCorp.Lab4AbhiramSanthosh;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AddressBookController {

    private final AddressBookRepository repository;

    AddressBookController(AddressBookRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/addressbooks")
    List<AddressBook> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/addressbook")
    AddressBook newAddressbook(@RequestBody BuddyInfo buddy) {

        AddressBook addressBook = repository.findById(1L).get();
        addressBook.addBuddy(buddy);
        return repository.save(addressBook);
    }

    // Single item

    @GetMapping("/addressbook/{id}")
    AddressBook one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AddressBookNotFoundException(id));
    }

    @DeleteMapping("/addressbook/{id}")
    void deleteAddressbook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}