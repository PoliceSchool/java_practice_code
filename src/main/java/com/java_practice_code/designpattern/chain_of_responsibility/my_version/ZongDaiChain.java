package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class ZongDaiChain extends AbstractChain {
    public ZongDaiChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            if (now.isSelfBuy()) {
                System.out.println("自购省钱179元");
            } else {
                System.out.println("发放179元");
            }
            return;
        }
        if (prev.getLevel() == AbstractChain.MEMBER_A) {
            System.out.println("发放79元");
        }
        if (prev.getLevel() == AbstractChain.MEM_DIAN) {
            System.out.println("发放40元");
        }
        if (prev.getLevel() == AbstractChain.HENG_TUI_MEM_DIAN) {
            System.out.println("发放35元");
        }
    }
}
