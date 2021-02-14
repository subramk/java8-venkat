package java8;


import java.util.function.BiConsumer;
import java.util.*;
import java.util.function.*;


public class BiConsumerComplex {


  public static <T, C> void validateAndSet(final BiConsumer<C,T> setMethod,final T value, final Supplier<List<C>> listSupplier) {

    Objects.requireNonNull(listSupplier);
    Objects.requireNonNull(setMethod);

    final List<C> consumersList = listSupplier.get();
//
//    if(isNotEmpty(consumersList)){
//      consumersList.stream().forEach( c -> validateAndSetIfValid(setMethod,c,value));
//    }

  }

  private static <C, T> void validateAndSetIfValid(final BiConsumer<C,T> setMethod, final C c, final T value) {
  }


}
