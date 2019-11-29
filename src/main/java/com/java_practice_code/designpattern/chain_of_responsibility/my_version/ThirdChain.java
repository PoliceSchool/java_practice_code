package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class ThirdChain extends AbstractChain {
    public ThirdChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            System.out.println("发放80%奖金");
            return;
        }
        if (prev.getLevel() == AbstractChain.FIRST) {
            System.out.println("发放40%奖金");
        }
        if (prev.getLevel() == AbstractChain.SECOND) {
            System.out.println("发放15%奖金");
        }
    }
}
