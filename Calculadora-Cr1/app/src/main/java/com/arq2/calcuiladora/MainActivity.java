package com.arq2.calcuiladora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnRadio, btnCheck, btnSpinner;

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

        btnRadio = (Button) findViewById(R.id.btnRadio);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnSpinner = (Button) findViewById(R.id.btnSpinner);

        setUp();
    }

    private void setUp(){
        btnRadio.setOnClickListener(v -> {
            Intent i = new Intent(this, radioButton.class);
            startActivity(i);
        });

        btnCheck.setOnClickListener(v -> {
            Intent i = new Intent(this, checkBox.class);
            startActivity(i);
        });

        btnSpinner.setOnClickListener(v -> {
            Intent i = new Intent(this, SpinnerAc.class);
            startActivity(i);
        });
    }
}