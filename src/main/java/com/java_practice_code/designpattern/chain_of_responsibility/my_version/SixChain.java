package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class SixChain extends AbstractChain {
    public SixChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            System.out.println("发放100%奖金");
            return;
        }
        if (prev.getLevel() == AbstractChain.FIRST) {
            System.out.println("发放60%奖金");
        }
        if (prev.getLevel() == AbstractChain.SECOND) {
            System.out.println("发放35%奖金");
        }
        if (prev.getLevel() == AbstractChain.THIRD) {
            System.out.println("发放20%奖金");
        }
        if (prev.getLevel() == AbstractChain.FOUR) {
            System.out.println("发放10%奖金");
        }
        if (prev.getLevel() == AbstractChain.FIVE) {
            System.out.println("发放5%奖金");
        }
    }
}
