package com.example.currencyrates;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Parser {

    public static List<Currency> parseXml(InputStream inputStream) throws Exception {
        List<Currency> currencies = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        NodeList items = document.getElementsByTagName("item");
        for (int i = 0; i < items.getLength(); i++) {
            Element item = (Element) items.item(i);

            String name = item.getElementsByTagName("targetName").item(0).getTextContent();
            String rate = item.getElementsByTagName("exchangeRate").item(0).getTextContent();

            currencies.add(new Currency(name, rate));
        }

        return currencies;
    }
}
