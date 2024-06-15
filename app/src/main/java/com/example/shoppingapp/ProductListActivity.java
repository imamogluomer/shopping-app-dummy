package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductListActivity extends AppCompatActivity {

    private ListView listView;
    private String[] urunler = {
            "Telefon", "Bilgisayar", "Televizyon", "Buzdolabı", "Çamaşır Makinesi",
            "Saç Kurutma Makinesi", "Mikrodalga Fırın", "Elektrikli Süpürge", "Kahve Makinesi", "Ütü",
            "Blender", "Pijama Takımı", "Ayakkabı", "Çanta", "Parfüm",
            "Gözlük", "Makyaj Seti", "Saat", "Yüzük", "Kolye"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, urunler);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String secilenUrun = urunler[position];
                Intent intent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
                intent.putExtra("urunAdi", secilenUrun);
                startActivity(intent);
            }
        });
    }
}
