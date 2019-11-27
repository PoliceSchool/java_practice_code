package com.java_practice_code.util.collection.priority_queue;

import java.util.PriorityQueue;

/**
 * description: PriorityQueue可以顺序输出当前队列里最大或者最小的元素，可以自定义comparator来选择输出最大还是最小元素
 * PriorityQueue其实是一棵树，只不过通过一定的顺序保存在数组里面
 * date: Created in 2019/11/27.
 *
 * @author lujingxiao
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(11);
        queue.add(10);
        queue.add(22);
        queue.add(5);
        queue.add(12);
        queue.add(2);

        while (!queue.isEmpty()) {
            System.out.printf("%d ", queue.poll());
        }
        System.out.println("\n");
    }
}
