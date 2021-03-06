package challenges.ee;

public class CurrencyConverter {

    public double covert( ConverterType converterType , double d) {
        return converterType.getInput().apply(d);
    }

}
