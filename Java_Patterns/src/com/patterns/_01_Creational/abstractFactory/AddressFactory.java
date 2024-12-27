package com.patterns._01_Creational.abstractFactory;

import com.patterns._01_Creational.abstractFactory.address.Address;
import com.patterns._01_Creational.abstractFactory.phoneNumber.PhoneNumber;

public interface AddressFactory{
    public Address createAddress();
    public PhoneNumber createPhoneNumber();
}