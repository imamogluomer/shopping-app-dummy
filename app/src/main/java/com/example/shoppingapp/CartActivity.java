package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private LinearLayout llCartItems;
    private TextView tvTotalPrice;
    private Button btnCheckout;
    private int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        llCartItems = findViewById(R.id.llCartItems);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnCheckout = findViewById(R.id.btnCheckout);

        List<CartItem> cartItems = CartManager.getInstance().getCartItems();
        for (CartItem item : cartItems) {
            addProductToCart(item);
        }

        updateTotalPrice();

        btnCheckout.setOnClickListener(v -> {
            // Perform payment action
            performPayment();
        });
    }

    private void performPayment() {
        // Display toast message
        Toast.makeText(this, "Siparişiniz alındı!", Toast.LENGTH_SHORT).show();

        // Clear the cart
        CartManager.getInstance().clearCart();

        // Update UI
        llCartItems.removeAllViews();
        totalPrice = 0;
        updateTotalPrice();
    }

    private void addProductToCart(CartItem item) {
        TextView textView = new TextView(this);
        int productTotalPrice = item.getTotalPrice();
        textView.setText(item.getName() + " - " + item.getPrice() + " TL x " + item.getQuantity() + " = " + productTotalPrice + " TL");
        llCartItems.addView(textView);

        totalPrice += productTotalPrice;
    }

    private void updateTotalPrice() {
        tvTotalPrice.setText("Toplam Fiyat: " + totalPrice + " TL");
    }
}
