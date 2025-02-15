package com.java._14_Xml._04_JAXB;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class Main {
    @Test
    public void TestXML1JAXB(){
        Catalog catalog = new Catalog();
        catalog.add(new Book("Author1", "Title1", 40.55, new Date()));
        catalog.add(new Book("Author2", "Title2", 30, new Date()));

        try {
            // Создаем файл
            File file = new File("files\\output.xml");
            // Вызываем статический метод JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            // Возвращает объект класса Marshaller, для того чтобы трансформировать объект
            Marshaller marshaller = jaxbContext.createMarshaller();

            // Читабельное форматирование
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записываем в файл, marshal(из памяти, в файл)
            marshaller.marshal(catalog, file);
            marshaller.marshal(catalog, System.out);

            // Считываем из файла
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(file);
            System.out.println(catalog);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        /*
        [[Author1, Title1, 40.55, Sun Feb 02 23:23:10 CET 2025], [Author2, Title2, 30.0, Sun Feb 02 23:23:10 CET 2025]]
         */
    }
}