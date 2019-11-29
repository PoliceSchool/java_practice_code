package com.java_practice_code.designpattern.chain_of_responsibility.my_version;

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
        System.out.println("发放1元");
    }
}
