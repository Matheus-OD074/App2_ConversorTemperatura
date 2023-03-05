package br.edu.isfp.dmos5;

public class KelvinStrategy implements  ConversorTemperatura{
    private KelvinStrategy instance;
    private TipoTemp tipo;

    public KelvinStrategy(TipoTemp tipo){
        this.tipo = tipo;
    }

    @Override
    public double getConversion(double temperatura) {
        if(tipo == TipoTemp.CELSIUS){
            temperatura = temperatura + 273.15;
        }
        if(tipo == TipoTemp.FAHRENHEINT){

            temperatura = ((temperatura - 32 ) * 5/9) + 273.15;
        }
        return temperatura;
    }
}
