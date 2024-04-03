package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.CharArrayWriter;
import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private final SecureRandom secureRandom = new SecureRandom();
    private final CharArrayWriter stringBuilder = new CharArrayWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button buttonYes = findViewById(R.id.yesBtn);
        TextView txtPass = findViewById(R.id.textView2);
        String password = txtPass.getText().toString();
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String text = txtPass.getText().toString();

                int start = 15;
                int end = text.length() - 24;
                String password = text.substring(start, end);

                intent.putExtra("message_key", password);
                startActivity(intent);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    public void onBttnClick(View view) {

        EditText edtTxtLength = findViewById(R.id.idLength);
        TextView txtPasswordView = findViewById(R.id.textView2);

        int length = Integer.parseInt(edtTxtLength.getText().toString());

        String password = generate_password(length);
        txtPasswordView.setText("Your password: " + password + "\nDo you want to save it?");

        Button buttonY = findViewById(R.id.yesBtn);
        Button buttonN = findViewById(R.id.noButton);
        buttonY.setVisibility(View.VISIBLE);
        buttonN.setVisibility(View.VISIBLE);
    }

    public void onNoClick(View view) {
        TextView txtPasswordView = findViewById(R.id.textView2);
        txtPasswordView.setText("");
    }

    public String generate_password(int length) {
        String specialLetters = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        stringBuilder.reset();
        for (int i = 0; i < length; i++) {
            char randomChar;
            int choose = secureRandom.nextInt(4);
            if (choose == 1) {
                randomChar = (char) ('0' + secureRandom.nextInt(10));
            } else if (choose == 2) {
                randomChar = (char) ('a' + secureRandom.nextInt(26));
            } else if (choose == 3) {
                randomChar = (char) ('A' + secureRandom.nextInt(26));
            } else {
                randomChar = (char) (specialLetters.charAt(secureRandom.nextInt(specialLetters.length())));
            }
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}