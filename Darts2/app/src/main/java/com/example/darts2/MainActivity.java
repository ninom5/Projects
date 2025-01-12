package com.example.darts2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Button btn301 = findViewById(R.id.button301);
        btn301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameMode = "301";
                Intent intent = new Intent(MainActivity.this, choosePlayers.class);
                intent.putExtra("gameMode", gameMode);
                startActivity(intent);
            }
        });
        Button btn501 = findViewById(R.id.button501);
        btn501.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameMode = "501";
                Intent intent = new Intent(MainActivity.this, choosePlayers.class);
                intent.putExtra("gameMode", gameMode);
                startActivity(intent);
            }
        });
        Button btn701 = findViewById(R.id.button701);
        btn701.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameMode = "701";
                Intent intent = new Intent(MainActivity.this, choosePlayers.class);
                intent.putExtra("gameMode", gameMode);
                startActivity(intent);
            }
        });
        Button btn901 = findViewById(R.id.button901);
        btn901.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameMode = "901";
                Intent intent = new Intent(MainActivity.this, choosePlayers.class);
                intent.putExtra("gameMode", gameMode);
                startActivity(intent);
            }
        });
        Button btnCricket = findViewById(R.id.buttonCricket);
        btnCricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameMode = "cricket";
                Intent intent = new Intent(MainActivity.this, choosePlayers.class);
                intent.putExtra("gameMode", gameMode);
                startActivity(intent);
            }
        });
    }


}