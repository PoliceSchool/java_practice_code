package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class FiveChain extends AbstractChain {
    public FiveChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            System.out.println("发放95%奖金");
            return;
        }
        if (prev.getLevel() == AbstractChain.FIRST) {
            System.out.println("发放55%奖金");
        }
        if (prev.getLevel() == AbstractChain.SECOND) {
            System.out.println("发放30%奖金");
        }
        if (prev.getLevel() == AbstractChain.THIRD) {
            System.out.println("发放15%奖金");
        }
        if (prev.getLevel() == AbstractChain.FOUR) {
            System.out.println("发放5%奖金");
        }
    }
}
