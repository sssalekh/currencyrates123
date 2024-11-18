package com.example.currencyrates;

public class Currency {
    private final String name;
    private final String rate;

    public Currency(String name, String rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getRate() {
        return rate;
    }
}
