package com.java_practice_code.jvm;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private final Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            iterator(nestedInteger, queue);
        }
    }

    private void iterator(NestedInteger nestedInteger, Queue<Integer> queue) {
        if (nestedInteger.isInteger()) {
            queue.add(nestedInteger.getInteger());
        } else {
            List<NestedInteger> nestedList = nestedInteger.getList();
            for (NestedInteger integer : nestedList) {
                iterator(integer, queue);
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
