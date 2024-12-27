package com.patterns._01_Creational.abstractFactory;

import com.patterns._01_Creational.abstractFactory.address.Address;
import com.patterns._01_Creational.abstractFactory.address.FrenchAddress;
import com.patterns._01_Creational.abstractFactory.phoneNumber.FrenchPhoneNumber;
import com.patterns._01_Creational.abstractFactory.phoneNumber.PhoneNumber;

public class FrenchAddressFactory implements AddressFactory{
    public Address createAddress(){
        return new FrenchAddress();
    }
    
    public PhoneNumber createPhoneNumber(){
        return new FrenchPhoneNumber();
    }
}