package br.edu.isfp.dmos5;

public class FahrenheitStrategy implements ConversorTemperatura {
    private FahrenheitStrategy instance;
    public  FahrenheitStrategy(){

    }

    public  FahrenheitStrategy getInstance(){
        return instance;
    }

    @Override
    public double getConversion(double temperatura) {
        temperatura = (temperatura - 32) * 5/9;
        return temperatura;
    }
}
