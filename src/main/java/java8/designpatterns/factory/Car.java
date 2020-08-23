package java8.designpatterns.factory;

public class Car implements Vehicle {

    private VehicleColour vehicleColour;

    public Car(VehicleColour vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public VehicleColour getColour() {
        return vehicleColour;
    }
}