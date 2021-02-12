package ThanosCorp.Lab4AbhiramSanthosh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AddressBookRepository repository) {

        BuddyInfo buddy = new BuddyInfo("Bilbo Baggins", "burglar","123");
        BuddyInfo buddyNew = new BuddyInfo("Frodo Baggins", "thief","123");

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.addBuddy(buddyNew);

        return args -> {
            log.info("Preloading " + repository.save(addressBook));

        };
    }
}