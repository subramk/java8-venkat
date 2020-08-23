package java8.designpatterns.factory;

public class VehicleClient {

  public static void main(String[] args) {
    final Vehicle redCar = VehicleType.CAR.factory.apply(VehicleColour.RED);
    final Vehicle redCar2 = OldStyleVehicleFactory.instanceOfType(VehicleType.CAR, VehicleColour.RED);

    final Vehicle blackTruck = VehicleType.TRUCK.factory.apply(VehicleColour.BLACK);

    final Vehicle blueBus = VehicleType.BUS.factory.apply(VehicleColour.BLUE);

    blueBus.start(nil -> {
      System.out.println("Check if every new passenger has paid for their tickets");
      System.out.println("Check if every passenger is seated");
    });
  }

}
