package java8.designpatterns.factory;

import java.util.function.Consumer;

public interface Vehicle {

    default void start(Consumer<Void> prestartChecks) {
        prestartChecks.accept(null);
        System.out.println( String.format("%s starting", this.getClass().getSimpleName()));

    }
}
