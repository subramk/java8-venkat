package java8.designpatterns.factory;

public class Bus implements Vehicle {

  private VehicleColour vehicleColour ;

  public Bus(VehicleColour vehicleColour){
    this.vehicleColour = vehicleColour;
  }

  public VehicleColour getColour(){
    return vehicleColour;
  }
}
