package com.java._14_Xml._02_DOM;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Main {
    @Test
    public void TestXML1DOMRead() throws UnsupportedEncodingException {
        try {
            File xmlFile = new File("files\\3.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Получаем объект DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Парсим объект DocumentBuilder и получаем объект Document
            Document doc = db.parse(xmlFile);

            // Возвращает объект класса Element, получаем корневой элемент
            Element root = doc.getDocumentElement();
            System.out.println("Корневой элемент: " + root.getNodeName());
            System.out.println("----------------------");

            // Для корневого элемента вызываем метод getChildNodes
            NodeList nl = root.getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                // По номеру получаем узел
                Node node = nl.item(i);
                // Проверяем определенный тип, если узел является элементом, то входим в тело
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Book:");
                    System.out.println("Author: " + element.getElementsByTagName("author").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("Title: " + element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("----------------------");
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        /*
        Корневой элемент: catalog
        ----------------------
        Book:
        Author: Bruce Eckel
        Title: Thinking In Java 4th Edition
        ----------------------
        Book:
        Author: Robert Lafore
        Title: Data Structures and Algorithms
        ----------------------
         */
    }

    @Test
    public void TestXML2DOMWrite() throws UnsupportedEncodingException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Получаем объект DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Создаем чистый документ
            Document doc = db.newDocument();

            // Возвращает объект класса Element, создаем каталог
            Element rootElement = doc.createElement("catalog");
            doc.appendChild(rootElement);

            // book
            Element book1 = doc.createElement("book");
            // book заносим в каталог
            rootElement.appendChild(book1);

            Element author1 = doc.createElement("author");
            author1.setTextContent("Author 1");
            book1.appendChild(author1);

            // book
            Element book2 = doc.createElement("book");
            // book заносим в каталог
            rootElement.appendChild(book2);

            Element author2 = doc.createElement("author");
            author2.setTextContent("Author 2");
            book2.appendChild(author2);

            // save
            // Трансформеры - берут данные из одного метода, трансформируют по некоторому алгоритму и перекладывают в другой метод
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            // Похожая иерархия на I/O
            DOMSource source = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("files\\4.xml"));

            // Трансформируем из источника в файл
            t.transform(source, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}