package ThanosCorp.Lab4AbhiramSanthosh;


class BuddyNotFoundException extends RuntimeException {

    BuddyNotFoundException(Long id) {
        super("Could not find buddy " + id);
    }
}