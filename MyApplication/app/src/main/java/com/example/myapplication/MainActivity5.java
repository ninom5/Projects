package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editText0 = findViewById(R.id.editEmail);
        EditText editText1 = findViewById(R.id.editTextText3);
        EditText editText2 = findViewById(R.id.editTextTextPassword);
        Intent intent = getIntent();
        editText0.setText(intent.getStringExtra("app"));
        editText1.setText(intent.getStringExtra("email"));
        editText2.setText(intent.getStringExtra("pass"));
    }
}