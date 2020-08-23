package java8.designpatterns.factory;

abstract public class AbstractVehicle implements Vehicle {

  public void start() {
    preStartCheck();
    System.out.println(String.format("%s starting...", this.getClass().getSimpleName()));
  }

  protected abstract void preStartCheck();

}
