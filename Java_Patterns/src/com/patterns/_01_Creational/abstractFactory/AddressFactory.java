package com.patterns._01_Creational.abstractFactory;

public interface AddressFactory{
    public Address createAddress();
    public PhoneNumber createPhoneNumber();
}