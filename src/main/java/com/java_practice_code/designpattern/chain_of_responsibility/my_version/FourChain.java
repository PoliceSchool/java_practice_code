package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class FourChain extends AbstractChain {
    public FourChain(int level){
        this.level = level;
    }
    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            System.out.println("发放179元");
            return;
        }
        if (prev.getLevel() == AbstractChain.MEMBER_A) {
            System.out.println("发放79元");
        }
        if (prev.getLevel() == AbstractChain.MEMDIAN_B) {
            System.out.println("发放40元");
        }
        if (prev.getLevel() == AbstractChain.MEMDIAN_A) {
            System.out.println("发放35元");
        }
    }
}
