package com.example.myandroidtwo;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreens extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(SplashScreens.this, MainActivity.class);
        startActivity(intent);
        finish();// se inica que se debe destruir una vez iniciada la instancia
    }
}
