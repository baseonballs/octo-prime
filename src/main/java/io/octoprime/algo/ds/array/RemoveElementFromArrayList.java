package io.octoprime.algo.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * To remove some elements from an ArrayList while iterating over the ArrayList, we need to use Iterator.
 */
public class RemoveElementFromArrayList {

    void removeElements() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println(list);

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int i = iter.next();
            if (i == 5)
                iter.remove();
        }

        System.out.println(list);
    }
}
