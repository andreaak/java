package com.patterns._01_Creational.abstractFactory;

import com.patterns._01_Creational.abstractFactory.address.Address;
import com.patterns._01_Creational.abstractFactory.address.USAddress;
import com.patterns._01_Creational.abstractFactory.phoneNumber.PhoneNumber;
import com.patterns._01_Creational.abstractFactory.phoneNumber.USPhoneNumber;

public class USAddressFactory implements AddressFactory{
    public Address createAddress(){
        return new USAddress();
    }
    
    public PhoneNumber createPhoneNumber(){
        return new USPhoneNumber();
    }
}