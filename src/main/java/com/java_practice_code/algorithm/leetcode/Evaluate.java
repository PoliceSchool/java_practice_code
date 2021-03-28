package com.java_practice_code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluate {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("name");
        item1.add("bob");
        list.add(item1);
        List<String> item2 = new ArrayList<>();
        item2.add("age");
        item2.add("two");
        list.add(item2);
        new Evaluate().evaluate("(name)is(age)yearsold", list);


        List<List<String>> list1 = new ArrayList<>();
        List<String> item3 = new ArrayList<>();
        item3.add("a");
        item3.add("b");
        list1.add(item3);
        new Evaluate().evaluate("hi(name)", list1);


        List<List<String>> list2 = new ArrayList<>();
        List<String> item4 = new ArrayList<>();
        item4.add("a");
        item4.add("yes");
        list2.add(item4);
        new Evaluate().evaluate("(a)(a)(a)aaa", list2);


        List<List<String>> list3 = new ArrayList<>();
        List<String> item5 = new ArrayList<>();
        item5.add("a");
        item5.add("b");
        list3.add(item5);
        List<String> item6 = new ArrayList<>();
        item6.add("b");
        item6.add("a");
        list3.add(item6);
        new Evaluate().evaluate("(a)(b)", list3);

        new Evaluate().evaluate("", new ArrayList<>());
    }


    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> item : knowledge) {
            map.put(item.get(0), item.get(1));
        }
        int length = s.length();
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char left = s.charAt(i);
            if (left == '(') {
                sb.append(s, j, i);
                j = i + 1;
                for (; j < length; j++) {
                    char right = s.charAt(j);
                    if (right == ')') {
                        break;
                    }
                }
                String value = map.get(s.substring(i + 1, j));
                sb.append(value == null ? "?" : value);
                i = (j++);
            }
        }
        sb.append(s, j, length);
        return sb.toString();
    }
}
