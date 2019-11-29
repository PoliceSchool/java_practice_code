package com.java_practice_code.designpattern.chain_of_responsibility.my_version;

import java.util.Objects;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/29.
 */
public class QuYuZongDaiAChain extends AbstractChain {
    public QuYuZongDaiAChain(int level) {
        this.level = level;
    }

    @Override
    protected void centCommission(Node prev, Node now) {
        if (Objects.isNull(prev)) {
            System.out.println("发放209元");
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
        if (prev.getLevel() == AbstractChain.QU_YU_ZONG_DAI) {
            System.out.println("发放1元");
        }
    }
}