package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


public class Node {
    private int level;
    private boolean selfBuy;

    public Node(int level, boolean selfBuy) {
        this.level = level;
        this.selfBuy = selfBuy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isSelfBuy() {
        return selfBuy;
    }

    public void setSelfBuy(boolean selfBuy) {
        this.selfBuy = selfBuy;
    }
}
