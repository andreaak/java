package com.java._14_Xml._01_Base;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Main {
    @Test
    public void TestExternalizable1() throws UnsupportedEncodingException {
        // Считываем файл.xml
        XMLParser xml = new XMLParser("files/2.xml");

        // Указываем путь, что будем считывать с файла xml
        String value = xml.get("catalog/book/author");
        System.out.println(value);
    }
}