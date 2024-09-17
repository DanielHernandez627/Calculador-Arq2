package com.arq2.calcuiladora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class radioButton extends AppCompatActivity {

    private Button btnCalcularR, btnRegresar;
    private EditText txtn1, txtn2, txtResult;
    private RadioGroup radioGroup;
    private float result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Configuracion de objetos
        btnCalcularR = (Button) findViewById(R.id.btnCalcularR);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        txtn1 = (EditText) findViewById(R.id.txtn1);
        txtn2 = (EditText) findViewById(R.id.txtn2);
        txtResult = (EditText) findViewById(R.id.txtResult);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        setUp();
    }

    public void setUp(){
        btnCalcularR.setOnClickListener(v -> {
            float n1 = Float.parseFloat((!txtn1.getText().toString().isEmpty()) ? txtn1.getText().toString() : "0");
            float n2 = Float.parseFloat((!txtn2.getText().toString().isEmpty()) ? txtn2.getText().toString() : "0");
            if (n1 == 0 || n2 == 0){
                Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_SHORT).show();
                return;
            }
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId != -1){
                RadioButton seletedRadioButton = (RadioButton) findViewById(selectedId);
                String selectedText = seletedRadioButton.getText().toString();

                switch (selectedText) {
                    case "Sumar":
                        Suma(n1, n2);
                        break;
                    case "Restar":
                        Resta(n1, n2);
                        break;
                    case "Multiplicar":
                        Multiplicacion(n1, n2);
                        break;
                    case "Dividir":
                        Division(n1, n2);
                        break;
                    default:
                        Toast.makeText(this, "Seleccione una opcion", Toast.LENGTH_SHORT).show();
                        break;
                }
            }else{
                Toast.makeText(this, "Seleccione una opcion", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegresar.setOnClickListener(v -> {
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