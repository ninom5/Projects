package com.example.darts2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class choosePlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_players);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnSubmit = findViewById(R.id.btnSubmit);
        String gameMode = getIntent().getStringExtra("gameMode");
        EditText edtNam1 = findViewById(R.id.name1);
        EditText edtNam2 = findViewById(R.id.name2);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choosePlayers.this, proba.class);
                String play1 = edtNam1.getText().toString();
                String play2 = edtNam2.getText().toString();
                intent.putExtra("gameMode", gameMode);
                intent.putExtra("Player1", play1);
                intent.putExtra("Player2", play2);
                intent.putExtra("numOfPlayers", numOfPlayers);
                startActivity(intent);
            }
        });
    }
    private int numOfPlayers = 0;
        public void onEnterClick(View view)
        {

            Button btnEnter = findViewById(R.id.btnEnter);
            Button btnSubmit = findViewById(R.id.btnSubmit);
            EditText edtNum = findViewById(R.id.num_of_players);
            EditText edtName1 = findViewById(R.id.name1);
            EditText edtName2 = findViewById(R.id.name2);
            //EditText edtName3 = findViewById(R.id.name3);
            //EditText edtName4 = findViewById(R.id.name4);
            String num_of_players = edtNum.getText().toString();

            switch (num_of_players) {
                case "1":
                    edtName1.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.VISIBLE);
                    numOfPlayers = 1;
                    break;
                case "2":
                    edtName1.setVisibility(View.VISIBLE);
                    edtName2.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.VISIBLE);
                    numOfPlayers = 2;
                    break;
               /* case "3":
                    edtName1.setVisibility(View.VISIBLE);
                    edtName2.setVisibility(View.VISIBLE);
                    edtName3.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    edtName1.setVisibility(View.VISIBLE);
                    edtName2.setVisibility(View.VISIBLE);
                    edtName3.setVisibility(View.VISIBLE);
                    edtName4.setVisibility(View.VISIBLE);
                    btnSubmit.setVisibility(View.VISIBLE);
                    break;*/
                default:
                    Toast.makeText(getApplicationContext(), "Choose up to 2 players", Toast.LENGTH_LONG).show();
                    break;
            }
        }
}