package com.example.currencyrates;

import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DataLoader extends AsyncTask<String, Void, List<Currency>> {

    public interface DataLoaderCallback {
        void onDataLoaded(List<Currency> currencies);
    }

    private final DataLoaderCallback callback;

    public DataLoader(DataLoaderCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Currency> doInBackground(String... urls) {
        String url = urls[0];
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            return Parser.parseXml(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Currency> currencies) {
        if (callback != null) {
            callback.onDataLoaded(currencies);
        }
    }
}
