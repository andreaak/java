package com.patterns._01_Creational.abstractFactory;

public class USAddressFactory implements AddressFactory{
    public Address createAddress(){
        return new USAddress();
    }
    
    public PhoneNumber createPhoneNumber(){
        return new USPhoneNumber();
    }
}