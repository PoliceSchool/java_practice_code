package com.java_practice_code.algorithm.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GetImportance {


    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        employees.forEach(employee -> {
            map.put(employee.id, employee);
        });
        Stack<Integer> stack = new Stack<>();
        stack.push(id);
        int result = 0;
        while (stack.size() > 0) {
            Employee employee = map.get(stack.pop());
            result += employee.importance;
            if (employee.subordinates != null && employee.subordinates.size() > 0) {
                employee.subordinates.forEach(employeeId -> stack.push(employeeId));
            }
        }
        return result;
    }

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
