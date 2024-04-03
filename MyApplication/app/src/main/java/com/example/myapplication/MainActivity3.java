package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();

        String app[]=new String[1];
        app[0] = intent.getStringExtra("app");
        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");

        ListView listView;
        listView = (ListView) findViewById(R.id.listID);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, app);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Intent intentO = new Intent(MainActivity3.this, MainActivity5.class);
                    intentO.putExtra("app", app[0]);
                    intentO.putExtra("email", email);
                    intentO.putExtra("pass", pass);

                    startActivity(intentO);
                } else if (position == 1)
                {
                    Intent intentO = new Intent(MainActivity3.this, MainActivity5.class);
                    intentO.putExtra("app", app[0]);
                    intentO.putExtra("email", email);
                    intentO.putExtra("pass", pass);

                    startActivity(intentO);
                }
                else
                {
                    Intent intentO = new Intent(MainActivity3.this, MainActivity5.class);
                    intentO.putExtra("app", app[0]);
                    intentO.putExtra("email", email);
                    intentO.putExtra("pass", pass);

                    startActivity(intentO);
                }
            }
        });
    }
}