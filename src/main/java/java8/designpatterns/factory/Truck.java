package java8.designpatterns.factory;

public class Truck implements Vehicle {
    private VehicleColour vehicleColour;

    public Truck(VehicleColour vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public VehicleColour getColour() {
        return vehicleColour;
    }
}
