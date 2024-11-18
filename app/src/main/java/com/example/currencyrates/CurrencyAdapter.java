package com.example.currencyrates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;
import java.util.List;

public class CurrencyAdapter extends ArrayAdapter<Currency> {

    public CurrencyAdapter(Context context) {
        super(context, 0);
    }

    public void setCurrencyList(List<Currency> currencies) {
        clear();
        addAll(currencies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.currency_item, parent, false);
        }

        Currency currency = getItem(position);
        TextView nameTextView = convertView.findViewById(R.id.currencyName);
        TextView rateTextView = convertView.findViewById(R.id.currencyRate);

        nameTextView.setText(currency.getName());
        rateTextView.setText(currency.getRate());

        return convertView;
    }
}
