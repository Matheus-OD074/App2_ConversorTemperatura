package br.edu.isfp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText tempEditText;
    private TextView resultTextView;
    private Button buttonConverterCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = findViewById(R.id.editText_temperature);
        resultTextView = findViewById(R.id.textView_Result);
        buttonConverterCelsius = findViewById(R.id.buttonConverterCelsius);
        buttonConverterCelsius.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == buttonConverterCelsius){
            getFahrenheitConversion();
        }
    }
    private void getFahrenheitConversion(){
        double result;
        FahrenheitStrategy fs = new FahrenheitStrategy();
        result = fs.getConversion(getTemp());
        showResult(result);
    }

    private double getTemp(){
        double temp;
        String stringTemp;

        stringTemp = tempEditText.getText().toString();
        try{
            temp = Double.parseDouble(stringTemp);
        }catch(NumberFormatException e) {
            Toast.makeText(this, "Valor digitado é invalido.", Toast.LENGTH_SHORT).show();
            temp = 0;
        }

        return temp;
    }

    private void showResult(double result){
        resultTextView.setText(String.format("%.2f °C", result));
    }

}