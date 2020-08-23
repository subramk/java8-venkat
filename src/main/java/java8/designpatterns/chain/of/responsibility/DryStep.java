package java8.designpatterns.chain.of.responsibility;

public class DryStep extends CarWashStep {
    @Override
    Car applyTo(Car car) {
        final Car newCar = car.updateState(WashState.DRIED);
        if (nextStep != null) {
            return nextStep.applyTo(newCar);
        }
        return newCar;
    }
}
