package challenges.ee;


import java.util.function.UnaryOperator;




public enum ConverterType {

    EUR_US_DOLLAR(input -> input * Constants.EURO_DOLLAR_RATE),
    US_DOLLAR_POUND(input -> input * Constants.DOLLAR_POUND_RATE);


    private UnaryOperator<Double> input;

    ConverterType( UnaryOperator<Double> input) {
        this.input = input;
    }

    public UnaryOperator<Double> getInput() {
        return input;
    }

    private static class Constants {
        public static final double EURO_DOLLAR_RATE = 1.2222d;
        public static final double DOLLAR_POUND_RATE = 0.71d;
    }

}
