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
class BuddyController {

    private final BuddyRepository repository;

    BuddyController(BuddyRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/buddies")
    List<BuddyInfo> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/buddies")
    BuddyInfo newBuddy(@RequestBody BuddyInfo newBuddy) {
        return repository.save(newBuddy);
    }

    // Single item

    @GetMapping("/buddies/{id}")
    BuddyInfo one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BuddyNotFoundException(id));
    }

    @PutMapping("/buddies/{id}")
    BuddyInfo replaceBuddy(@RequestBody BuddyInfo newBuddy, @PathVariable Long id) {

        return repository.findById(id)
                .map(buddy -> {
                    buddy.setName(newBuddy.getName());
                    buddy.setAddress(newBuddy.getAddress());
                    buddy.setNumber(newBuddy.getNumber());
                    return repository.save(buddy);
                })
                .orElseGet(() -> {
                    newBuddy.setId(id);
                    return repository.save(newBuddy);
                });
    }

    @DeleteMapping("/buddies/{id}")
    void deleteBuddy(@PathVariable Long id) {
        repository.deleteById(id);
    }
}