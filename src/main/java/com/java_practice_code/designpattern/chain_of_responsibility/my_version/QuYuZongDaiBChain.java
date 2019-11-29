package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.Objects;

public class QuYuZongDaiBChain extends AbstractChain {
    public QuYuZongDaiBChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            if (now.isSelfBuy()) {
                System.out.println("自购省钱209元");
            } else {
                System.out.println("发放209元");
            }
            return;
        }
        if (prev.getLevel() == AbstractChain.MEMBER_A) {
            System.out.println("发放109元");
        }
        if (prev.getLevel() == AbstractChain.MEM_DIAN) {
            System.out.println("发放70元");
        }
        if (prev.getLevel() == AbstractChain.ZONG_DAI) {
            System.out.println("发放30元");
        }
        if (prev.getLevel() == AbstractChain.HENG_TUI_ZONG_DAI) {
            System.out.println("发放25元");
        }
    }
}
