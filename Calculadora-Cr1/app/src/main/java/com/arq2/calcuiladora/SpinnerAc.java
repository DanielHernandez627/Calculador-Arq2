package com.arq2.calcuiladora;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAc extends AppCompatActivity {

    private Button btnCalcularS, btnRegresarS;
    private EditText txtn1, txtn2, txtResult;
    private Spinner spinner;
    private float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Configuracion de objetos
        btnCalcularS = (Button) findViewById(R.id.btnCalcularS);
        btnRegresarS = (Button) findViewById(R.id.btnRegresarS);
        txtn1 = (EditText) findViewById(R.id.txtn1S);
        txtn2 = (EditText) findViewById(R.id.txtn2S);
        txtResult = (EditText) findViewById(R.id.txtResultS);
        spinner = findViewById(R.id.spinnerS);

        //Configuracion del Spinner
        List<String> opciones = new ArrayList<>();
        opciones.add("Seleccione Operacion");
        opciones.add("Sumar");
        opciones.add("Restar");
        opciones.add("Multiplicar");
        opciones.add("Dividir");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        setUp();
    }

    private void setUp(){
        btnCalcularS.setOnClickListener(v -> {
            float n1 = Float.parseFloat((!txtn1.getText().toString().isEmpty()) ? txtn1.getText().toString() : "0");
            float n2 = Float.parseFloat((!txtn2.getText().toString().isEmpty()) ? txtn2.getText().toString() : "0");
            if (n1 == 0 || n2 == 0){
                Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_SHORT).show();
                return;
            }

            String selectedOption = spinner.getSelectedItem().toString();

            if (selectedOption.equals("Sumar")){
                Suma(n1, n2);
            } else if (selectedOption.equals("Restar")) {
                Resta(n1, n2);
            }else if (selectedOption.equals("Multiplicar")) {
                Multiplicacion(n1, n2);
            }else if (selectedOption.equals("Dividir")) {
                Division(n1, n2);
            }else {
                Toast.makeText(this, "Seleccione una opcion", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegresarS.setOnClickListener(v -> {
            finish();
        });
    }

    public void Suma(float n1, float n2){
        result = n1 + n2;
        txtResult.setText(String.valueOf(result));
    }

    public void Resta(float n1, float n2){
        result = n1 - n2;
        txtResult.setText(String.valueOf(result));
    }

    public void Multiplicacion(float n1, float n2){
        result = n1 * n2;
        txtResult.setText(String.valueOf(result));
    }

    public void Division(float n1, float n2){
        if (n2 == 0){
            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
        }else{
            result = n1 / n2;
            txtResult.setText(String.valueOf(result));
        }
    }

}