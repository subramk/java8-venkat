package java8.designpatterns.factory;


import java.util.function.Consumer;

import java8.designpatterns.factory.AbstractVehicle;

public class Plane extends AbstractVehicle {
  @Override
  protected void preStartCheck() {
    System.out.println("Checking that doors are properly closed!");
  }

  @Override
  public void start(final Consumer<Void> prestartChecks) {

  }
}
