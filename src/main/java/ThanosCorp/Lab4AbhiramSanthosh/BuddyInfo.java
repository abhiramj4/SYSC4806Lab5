package ThanosCorp.Lab4AbhiramSanthosh;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    private  String name;
    private  String address;
    private  String number; //student number

    @Id
    @GeneratedValue
    private Long id = null;



    /**
     * Create a buddy based on nam
     * @param firstName name
     * @param address address of buddy
     * @param number student number
     */
    public BuddyInfo(String firstName, String address, String number) {

        setName(firstName);
        setAddress(address);
        setNumber(number);

    }

    /**
     * Create a buddy based on another buddy
     * @param buddy existing buddy
     */
    public BuddyInfo(BuddyInfo buddy) {

        setName(buddy.getName());
        setAddress(buddy.getAddress());
        setNumber(buddy.getNumber());

    }

    public BuddyInfo(){
        name = "Joh Doe";
        address = "123 Street";
        number = "123";
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}