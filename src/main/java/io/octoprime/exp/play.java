package io.octoprime.exp;

import static java.lang.String.format;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.octoprime.utils.UtilsArray;

class Practice {

  static int find_min(final Stream<Integer> arr) {

    final int[] x = arr.mapToInt(e -> (int) e).toArray();

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < x.length; i++)
      if (x[i] < min)
        min = x[i];

    return min;

    // final Integer z = arr.min(Comparator.comparing(Integer::valueOf)).get();
    // System.out.println("Min Z: " + z);

    // final Integer m = arr.max(Comparator.comparing(Integer::valueOf)).get();
    // System.out.println("Maz m: " + m);
  }

  public static void main(final String[] args) {

    /*
     * final List<String> brr = UtilsArray.stringArray(10, 16);
     * System.out.println(brr);
     * 
     * brr.stream().sorted().collect(Collectors.toList()).forEach(System.out::
     * println);
     */
    int num_problems = 20;

    for (int i = 0; i < num_problems;i++)
      System.out.println(String.format("%d x %d = \n\n\n\n", 
        UtilsArray.randomBetween(10,20), 
        UtilsArray.randomBetween(10,20)));


    /**
    if (false) {
      final List<Integer> arr = UtilsArray.randomArray(10, 100);
      System.out.println(arr);

      final int[] b = arr.stream().filter(e -> e != null).mapToInt(e -> (int) e).toArray();
      int i = b.length;
      while (i-- > 0)
        System.out.println(b[i]);

      final List<Integer> f = arr.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
      System.out.println(f);
    }
    */
  }

}
