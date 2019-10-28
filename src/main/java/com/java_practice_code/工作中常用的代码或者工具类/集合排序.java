package com.java_practice_code.工作中常用的代码或者工具类;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/10/16.
 */
public class 集合排序 {


    public static void main(String[] args) {
        new 集合排序().run();
    }

    public void run() {
        class Item {
            private Integer x;

            private Item(Integer x) {
                this.x = x;
            }

            private Integer getX() {
                return x;
            }
        }
        List<Item> items = new ArrayList<>();
        items.add(new Item(5));
        items.add(new Item(53));
        items.add(new Item(6));
        items.add(new Item(9));
        items.add(new Item(0));
        items.add(new Item(1));
        items.add(new Item(66));
        items.sort(Comparator.comparing(Item::getX));
        items.forEach(item -> System.out.println(item.getX()));
    }
}
