package _02_Structural.proxy;

import java.util.ArrayList;
public interface AddressBook {
    public void add(Address address);
    public ArrayList<Address> getAllAddresses();
    public Address getAddress(String description);
    
    public void open();
    public void save();
}