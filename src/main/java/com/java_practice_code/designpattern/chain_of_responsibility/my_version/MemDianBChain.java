package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class MemDianBChain extends AbstractChain {
    public MemDianBChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            System.out.println("发放139元");
        } else {
            System.out.println("发放39");
        }

    }
}
