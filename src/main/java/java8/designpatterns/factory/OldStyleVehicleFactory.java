package java8.designpatterns.factory;

public class OldStyleVehicleFactory {
    /*
    Issues:
        1 - if conditions to check type leads to duplication most of the times
        2 - Adding a new type of vehicle implies adding a new conditional
        3 - We have to throw IllegalArgumentException if there's no match for type
        4 - Harder to read
     */

  public static Vehicle instanceOfType(VehicleType type,
                                       VehicleColour vehicleColour) {
    if (type.equals(VehicleType.CAR)) {
      return new Car(vehicleColour);
    } else if (type.equals(VehicleType.BUS)) {
      return new Bus(vehicleColour);
    } else if (type.equals(VehicleType.TRUCK)) {
      return new Truck(vehicleColour);
    }
    throw new IllegalArgumentException("No support for type " + type);
  }
}
