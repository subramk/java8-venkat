package java8.designpatterns.chain.of.responsibility;

public class OldStyleCarWashClient {

    public static void main(String[] args) {

        final Car car = new Car();

        final CarWashStep chain = new InitialWashStep();

        chain.andThen(new SoapStep())
                .andThen(new RinseStep())
                .andThen(new PolishStep())
                .andThen(new DryStep());

        final Car finalCar = chain.applyTo(car);

        System.out.println("Final car state is " + finalCar.washState());
    }
}
