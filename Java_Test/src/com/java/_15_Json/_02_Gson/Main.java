package com.java._15_Json._02_Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    @Test
    public void TestJson1Gson(){
        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        JsonReader jsonReader = null;
        try {
            jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CurrencyRate[] currencyRates = gson.fromJson(jsonReader, CurrencyRate[].class);

        for (CurrencyRate currencyRate : currencyRates) {
            System.out.println(currencyRate);
        }

        String gsonString = gson.toJson(currencyRates);

        try {
            Files.write(Paths.get("files\\gsonCurrency.json"),
                    gsonString.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    CurrencyRate{from='EUR', to='UAH', buy=43.00000, sale=44.00000}
    CurrencyRate{from='USD', to='UAH', buy=41.35000, sale=41.95000}
     */
}
