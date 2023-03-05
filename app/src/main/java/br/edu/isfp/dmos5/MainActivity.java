package br.edu.isfp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TipoTemp tipo;
    private EditText tempEditText;
    private TextView resultTextView;
    private TextView resultTextViewKelvin;
    private Button buttonConverterCelsius;
    private Button buttonConverterFahrenheit;
    private Button buttonConverterKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = findViewById(R.id.editText_temperature);
        resultTextView = findViewById(R.id.textView_Result);
        resultTextViewKelvin = findViewById(R.id.textView_Result_Kelvin);

        buttonConverterCelsius = findViewById(R.id.buttonConverterCelsius);
        buttonConverterCelsius.setOnClickListener(this);

        buttonConverterFahrenheit = findViewById(R.id.buttonConverterFahrenheit);
        buttonConverterFahrenheit.setOnClickListener(this);

        buttonConverterKelvin = findViewById(R.id.buttonCoverterKelvin);
        buttonConverterKelvin.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view == buttonConverterCelsius){
            getFahrenheitConversion();
            resultTextViewKelvin.setText("");
        }
        if(view == buttonConverterFahrenheit){
            getCelsiusConversion();
            resultTextViewKelvin.setText("");
        }
        if(view == buttonConverterKelvin){
            getKelvinConversion();
        }
    }
    private void getFahrenheitConversion(){
        double result;
        FahrenheitStrategy fs = new FahrenheitStrategy();
        result = fs.getConversion(getTemp());
        resultTextView.setText(String.format("%.2f °C", result));
        tipo = TipoTemp.CELSIUS;
    }

    private void getCelsiusConversion(){
        double result;
        CelsisusStrategy cs = new CelsisusStrategy();
        result = cs.getConversion(getTemp());
        resultTextView.setText(String.format("%.2f °F", result));
        tipo = TipoTemp.FAHRENHEINT;
    }

    private void getKelvinConversion(){
        double result;
        KelvinStrategy ks = new KelvinStrategy(tipo);
        result = ks.getConversion(getTemp());
        resultTextViewKelvin.setText(String.format("%.2f °K", result));
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

}