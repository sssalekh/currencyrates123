package com.example.currencyrates;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CurrencyAdapter currencyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.currencyListView);
        currencyAdapter = new CurrencyAdapter(this);
        listView.setAdapter(currencyAdapter);

        // Load data in the background
        DataLoader dataLoader = new DataLoader(new DataLoader.DataLoaderCallback() {
            @Override
            public void onDataLoaded(List<Currency> currencies) {
                currencyAdapter.setCurrencyList(currencies);
            }
        });
        dataLoader.execute("https://www.floatrates.com/daily/usd.xml");
    }
}
