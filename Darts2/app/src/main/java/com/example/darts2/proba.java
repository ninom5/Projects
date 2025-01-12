package com.example.darts2;

import static com.example.darts2.R.id.Name1;
import static com.example.darts2.R.id.scorePlayer1;
import static com.example.darts2.R.id.textView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;
import java.util.Random;
import java.util.Scanner;
public class proba extends AppCompatActivity {
    private int res1;
    private int res2;
    private int turn = 0;
    private int temp = 1;
    private int count = 0;

    public class DartGame{
        public void main(String[] args) {};
        public int k(int uk) {return 0;};
        public int wuhu(int res) {return 0;};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_proba);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DartGame dartGame = new DartGame();
        String Player1 = getIntent().getStringExtra("Player1");
        String Player2 = getIntent().getStringExtra("Player2");
        String gameMode = getIntent().getStringExtra("gameMode");
        int NumOfPlayers = getIntent().getIntExtra("numOfPlayers", 0);

        Button btn1 = findViewById(R.id.button1);
        Switch switchBtn = findViewById(R.id.switch1);
        TextView score1 = findViewById(R.id.scorePlayer1);
        TextView score2 = findViewById(R.id.scorePlayer2);
        TextView nm1 = findViewById(R.id.Name1);
        TextView nm2 = findViewById(R.id.Name2);
        TextView hit1 = findViewById(R.id.Hit1);
        TextView hit2 = findViewById(R.id.Hit2);

        if(NumOfPlayers == 1)
        {
            score1.setVisibility(View.VISIBLE);
            nm1.setVisibility(View.VISIBLE);

        }
        else if(NumOfPlayers == 2)
        {
            score1.setVisibility(View.VISIBLE);
            nm1.setVisibility(View.VISIBLE);
            score2.setVisibility(View.VISIBLE);
            nm2.setVisibility(View.VISIBLE);
            switchBtn.setVisibility(View.VISIBLE);
        }

        score1.setText(gameMode);
        score2.setText(gameMode);
        nm1.setText(Player1);
        nm2.setText(Player2);

        switch (gameMode) {
            case "301": {
                res1 = 301;
                res2 = 301;

                break;
            }
            case "501": {
                res1 = 501;
                res2 = 501;
                break;
            }
            case "701": {
                res1 = 701;
                res2 = 701;
                break;
            }
            case "901": {
                res1 = 901;
                res2 = 901;
                break;
            }
            default:
            {
                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        };

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 1;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    dartGame.wuhu(res1);
                    score1.setText(String.valueOf(res1));
                    count++;

                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 2;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 3;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 4;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 5;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 6;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 7;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 8;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn9 = findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 9;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn10 = findViewById(R.id.button10);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 10;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn11 = findViewById(R.id.button11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 11;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn12 = findViewById(R.id.button12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 12;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn13 = findViewById(R.id.button13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 13;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn14 = findViewById(R.id.button14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 14;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn15 = findViewById(R.id.button15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 15;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn16 = findViewById(R.id.button16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 16;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn17 = findViewById(R.id.button17);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 17;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn18 = findViewById(R.id.button18);
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 18;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn19 = findViewById(R.id.button19);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 19;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn20 = findViewById(R.id.button20);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 20;
                int prevRes1 = res1;
                int prevRes2 = res2;
                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        Button btn25 = findViewById(R.id.buttonBull);
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point = 25;
                int prevRes1 = res1;
                int prevRes2 = res2;

                if(turn % 2 == 0)
                {
                    res1 -= temp * point;
                    if (res1 < 0)
                    {
                        res1 = prevRes1;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score1.setText(String.valueOf(res1));
                    count++;
                    if(count == 3)
                    {
                        switchBtn.setChecked(true);
                    }
                }
                else
                {
                    res2 -= temp * point;
                    if (res2 < 0)
                    {
                        res2 = prevRes2;
                        Toast.makeText(getApplicationContext(), "BUSTED!", Toast.LENGTH_SHORT).show();
                    }
                    score2.setText(String.valueOf(res2));
                    count++;

                    if(count == 3)
                    {
                        switchBtn.setChecked(false);
                    }
                }
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonSing = findViewById(R.id.btnSingle);
        buttonSing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 1;
            }
        });

        Button btnTriple = findViewById(R.id.buttonTriple);
        btnTriple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 3;
            }
        });

        Button btnDouble = findViewById(R.id.buttonDouble);
        btnDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 2;

            }
        });

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    turn = 1;
                    count = 0;
                }
                else
                {
                    turn = 0;
                    count = 0;
                }
            }
        });
        class DartGame {
            public int wuhu(int res) {
                Random rand = new Random();
                res = Integer.parseInt(score1.getText().toString());
                int comb = 0;

                while (res != 0) {
                    if (res == 25) {
                        comb = res;
                        res -= comb;
                        if(turn % 2 == 0)
                        {
                            hit1.setText(comb);
                        }
                        else
                            hit2.setText(comb);

                    } else if (res == 50) {
                        comb = res / 2;
                        res -= comb * 2;
                        if(turn % 2 == 0)
                        {
                            hit1.setText(comb);
                        }
                    } else if (res % 3 == 0) {
                        comb = res / 3;
                        res -= comb * 3;
                        if(turn % 2 == 0)
                        {
                            hit1.setText(comb);
                        }
                    } else if (res % 2 == 0) {
                        comb = res / 2;
                        res -= comb * 2;
                        if(turn % 2 == 0)
                        {
                            hit1.setText(comb);
                        }
                    } else {
                        if (res > 20) {
                            int num1 = rand.nextInt(22);
                            if (num1 == 21)
                                num1 = 25;
                            if(turn % 2 == 0)
                            {
                                hit1.setText(comb);
                            }
                            res -= num1;
                        } else {
                            int temp = res;
                            res -= temp;
                            if(turn % 2 == 0)
                            {
                                hit1.setText(comb);
                            }
                        }
                    }
                }
                return res;
            }

            public int k(int uk) {
                Random rand = new Random();
                int r = 0;
                int wtf = 0;

                while (r == 0) {
                    int num1 = rand.nextInt(22);
                    if (num1 == 21)
                        num1 = 25;
                    int num2 = rand.nextInt(22);
                    if (num2 == 21)
                        num2 = 25;
                    int num3 = rand.nextInt(22);
                    if (num3 == 21)
                        num3 = 25;

                    if (num1 != 25 && num2 != 25 && num3 != 25) {
                        for (int i = 1; i <= 3; i++) {
                            for (int j = 1; j <= 3; j++) {
                                for (int z = 1; z <= 3; z++) {
                                    wtf = num1 * i + num2 * j + num3 * z;
                                    if (wtf == uk) {
                                        System.out.printf("Combination: %d * %d + %d * %d + %d * %d = %d\n", num1, i, num2, j, num3, z, uk);
                                        r = 1;
                                        break;
                                    }
                                }
                                if (r == 1)
                                    break;
                            }
                            if (r == 1)
                                break;
                        }
                    } else {
                        if (num1 == 25 || num2 == 25 || num3 == 25) {
                            for (int i = 1; i <= (num1 == 25 ? 2 : 3); i++) {
                                for (int j = 1; j <= (num2 == 25 ? 2 : 3); j++) {
                                    for (int k = 1; k <= (num3 == 25 ? 2 : 3); k++) {
                                        wtf = num1 * i + num2 * j + num3 * k;
                                        if (wtf == uk) {
                                            System.out.printf("Combination: %d * %d + %d * %d + %d * %d = %d\n", num1, i, num2, j, num3, k, uk);
                                            r = 1;
                                            break;
                                        }
                                    }
                                    if (r == 1)
                                        break;
                                }
                                if (r == 1)
                                    break;
                            }
                        }
                    }
                }
                return 0;
            }

            public void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int res = 0;
                int comb = 0;
                System.out.print("Enter a value: ");
                res = scanner.nextInt();
                Random rand = new Random();
                rand.setSeed(System.currentTimeMillis());
                if (res <= 60) {
                    res = wuhu(res);
                } else if (res > 60 && res < 120) {
                    while (res != 0) {
                        int temp = 3 * 20;
                        res -= temp;
                        System.out.println("triple 20");
                        res = wuhu(res);
                    }
                } else {
                    k(res);
                }
            }
        }

    }
}