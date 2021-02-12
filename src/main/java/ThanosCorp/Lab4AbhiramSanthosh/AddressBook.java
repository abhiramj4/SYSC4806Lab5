package ThanosCorp.Lab4AbhiramSanthosh;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> addresses;

    @Id
    @GeneratedValue

    private Long id = null;

    public AddressBook() {
        this.addresses = new ArrayList<BuddyInfo>();
    }

    /**
     * Add a buddy to the addressbook
     * @param buddy to add
     */
    public void addBuddy(BuddyInfo buddy) {

        if(buddy != null) {
            addresses.add(buddy);
        }
    }

    public BuddyInfo getBuddy(int index){
        return addresses.get(index);
    }

    public int size() {
        return this.addresses.size();
    }

    public void clear() {
        this.addresses.clear();
    }


    public List<BuddyInfo> getAddresses(){

        return this.addresses;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    /**
     * Remove buddy from addresses
     */
    public void removeBuddy() {
        addresses.remove(addresses.size()-1);
    }

    public BuddyInfo removeBuddy(int index) {
        if (index >= 0 && index < this.addresses.size()) {
            return this.addresses.remove(index);
        } else {
            return null;
        }
    }

    public void removeBuddy(BuddyInfo buddy) {

        addresses.remove(buddy);
    }

}
