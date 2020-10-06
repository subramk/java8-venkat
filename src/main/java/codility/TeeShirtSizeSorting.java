package codility;

import java.util.Arrays;


/**
 *
 * Given a String representing various TeeShirt sizes S,M,L , we need to sort them
 * according to ascending order
 *
 * Example :
 *
 * Input of MSLMLSSML - will become SSSMMMLLL
 *
 *
 */
public class TeeShirtSizeSorting {

    public static void main(String[] args) {
        TeeShirtSizeSorting sorter = new TeeShirtSizeSorting();
        String afterSortingByAscOrder  = sorter.doWork("MSLMLSSML");
        System.out.println( afterSortingByAscOrder) ;

    }



static String  doWork(final String sizes){


    StringBuilder solution = new StringBuilder();
    char[] wordChar = sizes.toCharArray();
    Arrays.sort(wordChar);
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(wordChar);
            return strBuilder.reverse().toString();
            // write your code in Java SE 8
           }


}