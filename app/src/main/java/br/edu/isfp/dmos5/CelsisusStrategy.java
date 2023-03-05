package br.edu.isfp.dmos5;

public class CelsisusStrategy implements ConversorTemperatura{
    private CelsisusStrategy instance;

    public CelsisusStrategy(){

    }

    public CelsisusStrategy getInstance() {
        return instance;
    }

    @Override
    public double getConversion(double temperatura) {
        temperatura = (temperatura * 9/5) + 32;
        return temperatura;
    }
}