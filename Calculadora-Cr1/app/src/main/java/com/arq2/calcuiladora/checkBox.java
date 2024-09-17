package com.arq2.calcuiladora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class checkBox extends AppCompatActivity {

    private Button btnCalcularR, btnRegresar;
    private EditText txtn1, txtn2, txtResult;
    private CheckBox checkBoxS, checkBoxR, checkBoxM, checkBoxD;
    private float result = 0;
    private String resultString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_box);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Configuracion de objetos
        btnCalcularR = (Button) findViewById(R.id.btnCalcularC);
        btnRegresar = (Button) findViewById(R.id.btnRegresarC);
        txtn1 = (EditText) findViewById(R.id.txtn1C);
        txtn2 = (EditText) findViewById(R.id.txtn2C);
        txtResult = (EditText) findViewById(R.id.txtResultC);
        checkBoxS = (CheckBox) findViewById(R.id.checkBoxS);
        checkBoxR = (CheckBox) findViewById(R.id.checkBoxR);
        checkBoxM = (CheckBox) findViewById(R.id.checkBoxM);
        checkBoxD = (CheckBox) findViewById(R.id.checkBoxD);

        setUp();
    }

    private void setUp(){
        btnCalcularR.setOnClickListener(v -> {
            float n1 = Float.parseFloat((!txtn1.getText().toString().isEmpty()) ? txtn1.getText().toString() : "0");
            float n2 = Float.parseFloat((!txtn2.getText().toString().isEmpty()) ? txtn2.getText().toString() : "0");
            if (n1 == 0 || n2 == 0){
                Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_SHORT).show();
                return;
            }
            if (checkBoxS.isChecked() && checkBoxR.isChecked() && checkBoxM.isChecked() && checkBoxD.isChecked()) {
                resultString = "Suma: " + Suma(n1, n2) + " / " +
                        "Resta: " + Resta(n1, n2) + " / " +
                        "Multiplicación: " + Multiplicacion(n1, n2) + " / " +
                        "División: " + Division(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxS.isChecked() && checkBoxR.isChecked() && checkBoxM.isChecked()) {
                resultString = "Suma: " + Suma(n1, n2) + " / " +
                        "Resta: " + Resta(n1, n2) + " / " +
                        "Multiplicación: " + Multiplicacion(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxS.isChecked() && checkBoxR.isChecked() && checkBoxD.isChecked()) {
                resultString = "Suma: " + Suma(n1, n2) + " / " +
                        "Resta: " + Resta(n1, n2) + " / " +
                        "División: " + Division(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxS.isChecked() && checkBoxM.isChecked() && checkBoxD.isChecked()) {
                resultString = "Suma: " + Suma(n1, n2) + " / " +
                        "Multiplicación: " + Multiplicacion(n1, n2) + " / " +
                        "División: " + Division(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxR.isChecked() && checkBoxM.isChecked() && checkBoxD.isChecked()) {
                resultString = "Resta: " + Resta(n1, n2) + " / " +
                        "Multiplicación: " + Multiplicacion(n1, n2) + " / " +
                        "División: " + Division(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxS.isChecked() && checkBoxR.isChecked()) {
                resultString = "Suma: " + Suma(n1, n2) + " / " +
                        "Resta: " + Resta(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxS.isChecked() && checkBoxM.isChecked()) {
                resultString = "Suma: " + Suma(n1, n2) + " / " +
                        "Multiplicación: " + Multiplicacion(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxS.isChecked() && checkBoxD.isChecked()) {
                resultString = "Suma: " + Suma(n1, n2) + " / " +
                        "División: " + Division(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxR.isChecked() && checkBoxM.isChecked()) {
                resultString = "Resta: " + Resta(n1, n2) + " / " +
                        "Multiplicación: " + Multiplicacion(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxR.isChecked() && checkBoxD.isChecked()) {
                resultString = "Resta: " + Resta(n1, n2) + " / " +
                        "División: " + Division(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxM.isChecked() && checkBoxD.isChecked()) {
                resultString = "Multiplicación: " + Multiplicacion(n1, n2) + " / " +
                        "División: " + Division(n1, n2);
                txtResult.setText(resultString);
            } else if (checkBoxS.isChecked()) {
                resultString = String.valueOf(Suma(n1, n2));
                txtResult.setText(resultString);
            } else if (checkBoxR.isChecked()) {
                resultString = String.valueOf(Resta(n1, n2));
                txtResult.setText(resultString);
            } else if (checkBoxM.isChecked()) {
                resultString = String.valueOf(Multiplicacion(n1, n2));
                txtResult.setText(resultString);
            } else if (checkBoxD.isChecked()) {
                resultString = String.valueOf(Division(n1, n2));
                txtResult.setText(resultString);
            } else {
                Toast.makeText(this, "Seleccione al menos una opción", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegresar.setOnClickListener(v -> {
            finish();
        });
    }

    public float Suma(float n1, float n2){
        result = n1 + n2;
        return result;
    }

    public float Resta(float n1, float n2){
        result = n1 - n2;
        return result;
    }

    public float Multiplicacion(float n1, float n2){
        result = n1 * n2;
        return result;
    }

    public float Division(float n1, float n2){
        if (n2 == 0){
            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
        }else{
            result = n1 / n2;
        }
        return result;
    }
}