package ThanosCorp.Lab4AbhiramSanthosh;



class AddressBookNotFoundException extends RuntimeException {

    AddressBookNotFoundException(Long id) {
        super("Could not find addressbook " + id);
    }
}