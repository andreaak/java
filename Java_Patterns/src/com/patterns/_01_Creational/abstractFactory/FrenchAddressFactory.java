package com.patterns._01_Creational.abstractFactory;

public class FrenchAddressFactory implements AddressFactory{
    public Address createAddress(){
        return new FrenchAddress();
    }
    
    public PhoneNumber createPhoneNumber(){
        return new FrenchPhoneNumber();
    }
}