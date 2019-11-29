package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class FourChain extends AbstractChain {
    public FourChain(int level){
        this.level = level;
    }
    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            System.out.println("发放90%奖金");
            return;
        }
        if (prev.getLevel() == AbstractChain.FIRST) {
            System.out.println("发放50%奖金");
        }
        if (prev.getLevel() == AbstractChain.SECOND) {
            System.out.println("发放25%奖金");
        }
        if (prev.getLevel() == AbstractChain.THIRD) {
            System.out.println("发放10%奖金");
        }
    }
}
