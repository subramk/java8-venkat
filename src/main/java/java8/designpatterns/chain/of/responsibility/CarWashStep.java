package java8.designpatterns.chain.of.responsibility;


public abstract class CarWashStep {
    protected CarWashStep nextStep;

    public CarWashStep andThen(CarWashStep nextStep) {
        this.nextStep = nextStep;
        return nextStep;
    }
    abstract Car applyTo(Car car);
}

