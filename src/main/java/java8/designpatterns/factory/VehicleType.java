package java8.designpatterns.factory;

import java.util.function.Function;

public enum VehicleType {

  BUS(Bus::new),
  CAR(Car::new),
  TRUCK(Truck::new);

  public Function<VehicleColour, Vehicle> factory ;

  VehicleType(Function<VehicleColour, Vehicle> factory){
    this.factory = factory;
  }



}
