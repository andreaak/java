package com.java._14_Xml._03_SAX;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
    @Test
    public void TestXML1SAX() throws UnsupportedEncodingException {
        // Имя файла
        final String fileName = "files\\phonebook.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // Поле для указания, что тэг name начался
                boolean name = false;

                // Метод вызывается когда SAXParser "натыкается" на начало тэга
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Если тэг имеет имя name, то мы этот момент отмечаем - начался тэг name
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;
                    }
                }

                // Метод вызывается когда SAXParser считывает текст между тэгами
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // Если перед этим мы отметили, что имя тэга name - значит нам надо текст использовать.
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    }
                }
            };
            // Стартуем разбор методом parse, которому передаем наследника от DefaultHandler, который будет вызываться в нужные моменты
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        Name: Green
        Name: Crys
        Name: Duke
         */
    }


}