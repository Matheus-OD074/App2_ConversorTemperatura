package br.edu.isfp.dmos5;

public class FahrenheitStrategy implements ConversorTemperatura {
    private FahrenheitStrategy instance;
    public  FahrenheitStrategy(){

    }

    public  FahrenheitStrategy getInstance(){
        return instance;
    }

    @Override
    public double getConversion(double temperature) {

        temperature = (temperature - 32) * 5/9;

        return temperature;
    }
}
