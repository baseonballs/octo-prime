package io.octoprime.ps.fb.hard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenNestedList implements Iterator {


    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List getList();
    }

    Queue<Integer> queue = new LinkedList<>();

    public FlattenNestedList(List<NestedInteger> nestedList) {
        this.buildList(nestedList);
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void buildList(List<NestedInteger> nestedList) {

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                queue.offer(nestedInteger.getInteger());
            } else {
                buildList(nestedInteger.getList());
            }
        }
        return;
    }

}
