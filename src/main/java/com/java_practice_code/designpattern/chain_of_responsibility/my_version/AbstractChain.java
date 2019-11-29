package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import org.springframework.util.CollectionUtils;

import java.util.LinkedList;

public abstract class AbstractChain {
    static int MEMBER_A = 1;
    static int MEM_DIAN = 2;
    static int HENG_TUI_MEM_DIAN = 3;
    static int ZONG_DAI = 4;
    static int HENG_TUI_ZONG_DAI = 5;
    static int QU_YU_ZONG_DAI = 6;
    static int HENG_TUI_QU_YU_ZONG_DAI = 7;

    protected int level;

    /**
     * 责任链中的下一个元素
     */
    private AbstractChain nextChain;

    void commission(Node prev, LinkedList<Node> linkedList) {
        if (CollectionUtils.isEmpty(linkedList)) {
            return;
        }
        Node now = linkedList.getFirst();
        if (now.getLevel() == this.level) {
            centCommission(prev, now);
            prev = linkedList.pop();
        }
        if (nextChain != null) {
            nextChain.commission(prev, linkedList);
        }
    }

    /**
     * 由子类实现的具体分佣逻辑
     */
    protected abstract void centCommission(Node prev, Node now);

    void setNextChain(AbstractChain nextChain) {
        this.nextChain = nextChain;
    }
}
