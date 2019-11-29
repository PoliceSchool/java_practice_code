package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


public class Node {
    private int level;

    public Node(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
