package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


public class HengTuiZongDaiChain extends AbstractChain {
    public HengTuiZongDaiChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        System.out.println("发放5元");
    }
}
