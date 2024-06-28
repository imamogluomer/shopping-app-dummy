package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private Button btnSepeteEkle;
    private TextView tvUrunAdi, tvUrunFiyat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        numberPicker = findViewById(R.id.numberPicker);
        btnSepeteEkle = findViewById(R.id.btnSepeteEkle);
        tvUrunAdi = findViewById(R.id.tvUrunAdi);
        tvUrunFiyat = findViewById(R.id.tvUrunFiyat);

        // Initialize the NumberPicker
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        numberPicker.setWrapSelectorWheel(true);

        // Assume we get product details from intent
        Intent intent = getIntent();
        String urunAdi = intent.getStringExtra("urunAdi");
        int urunFiyat = intent.getIntExtra("urunFiyat", 2489);

        // Set product details to views
        tvUrunAdi.setText(urunAdi);
        tvUrunFiyat.setText("Fiyat: " + urunFiyat + " TL");

        btnSepeteEkle.setOnClickListener(v -> {
            int quantity = numberPicker.getValue();
            CartItem cartItem = new CartItem(urunAdi, urunFiyat, quantity);
            CartManager.getInstance().addItem(cartItem);

            Intent cartIntent = new Intent(ProductDetailActivity.this, CartActivity.class);
            startActivity(cartIntent);
        });
    }
}
