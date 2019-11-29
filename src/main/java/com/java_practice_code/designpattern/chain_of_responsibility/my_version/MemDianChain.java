package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class MemDianChain extends AbstractChain {
    public MemDianChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            if (now.isSelfBuy()) {
                System.out.println("自购省钱139元");
            } else {
                System.out.println("发放139元");
            }
        } else {
            System.out.println("发放39");
        }

    }
}
