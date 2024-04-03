package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView receiver_msg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        receiver_msg = findViewById(R.id.pass3);
        Intent intent = getIntent();
        if (intent != null) {
            String password = intent.getStringExtra("message_key");
            if (password != null) {
                receiver_msg.setText(password);
                Log.d("MainActivity2", "Password received: " + password);
            } else {
                Log.e("MainActivity2", "Password retrieved is null");
            }
        } else {
            Log.e("MainActivity2", "Intent is null");
        }

        Button SaveBtn = findViewById(R.id.btnSave);
        EditText app = findViewById(R.id.editTextText);
        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText pass = findViewById(R.id.pass3);

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                String application = app.getText().toString();
                String email1 = email.getText().toString();
                String password = pass.getText().toString();

                intent.putExtra("app", application);
                intent.putExtra("email", email1);
                intent.putExtra("pass", password);

                startActivity(intent);
            }
        });
    }
}