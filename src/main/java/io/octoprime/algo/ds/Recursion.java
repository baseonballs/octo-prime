package io.octoprime.algo.ds;

public class Recursion {

    static int sum(int first, int last) {
        if (first == last)
            return last;
        else
            return first + sum(first + 1, last);
    }
}
