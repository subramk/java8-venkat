package com.java8.dto;

import java.util.Arrays;
import java.util.List;

public final class ActorHelper {


  public static void main(String z[]){
    ActorHelper helper = new ActorHelper();
    List<Integer> numbersList = Arrays.asList(1,2,3,4,5,6,7, 8 , 9 ,10 );

    helper.doBinarySearch(numbersList);
  }

  private void doBinarySearch(List<Integer> numbersList) {

    //SetUtils

    int r = numbersList.size() -1 ; // index of lastElement
    int  f = 0 ; // index of firstElement

   // Integer  midpoint = numbersList.get ( Integer(  Math.floor( numbersList.get(f) + numbersList.get(r)) / 2))  ;

    //System.out.println( midpoint);



  }


}
