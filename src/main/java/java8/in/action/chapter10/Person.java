package java8.in.action.chapter10;

import java.util.*;

public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
    
    public void setCar(final Optional<Car> car) {
    		this.car = car ; 
    }
}
