package com.java._15_Json._01_JacksonDatabind;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    @Test
    public void TestJson1JacksonDatabind(){
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = null;

        try {
            person = objectMapper.readValue(new File("files\\person.json"), Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(person);

        /*
        Person{
        firstName='Yevhenii',
        lastName='Tykhonov',
        course=Course{author='Yevhenii Tykhonov', title='Java Professional', description='For everyone'},
        personalContacts=[https://itvdn.com/ru/video/java-professional, https://www.facebook.com/yevheniitykhonov, https://www.instagram.com/yevheniitykhonov]
        }

         */
    }

    @Test
    public void TestJson2JacksonDatabind() throws IOException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        ObjectMapper objectMapper = new ObjectMapper();

        CurrencyRate[] currencyRates = objectMapper.readValue(new URL(url), CurrencyRate[].class);

        for (CurrencyRate currencyRate : currencyRates) {
            System.out.println(currencyRate);
        }

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(currencyRates);

        Files.write(Paths.get("files\\jacksonCurrency.json"),
                jsonString.getBytes(), StandardOpenOption.CREATE);

        /*
        CurrencyRate{from='EUR', to='UAH', buy=43.00000, sale=44.00000}
        CurrencyRate{from='USD', to='UAH', buy=41.35000, sale=41.95000}
         */
    }
}
