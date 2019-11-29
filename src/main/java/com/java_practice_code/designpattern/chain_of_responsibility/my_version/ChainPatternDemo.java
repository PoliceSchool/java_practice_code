package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.LinkedList;

public class ChainPatternDemo {
    private static AbstractChain getChains() {
        AbstractChain firstChain = new MemberAChain(AbstractChain.MEMBER_A);
        AbstractChain secondChain = new MemDianBChain(AbstractChain.MEM_DIAN);
        AbstractChain thirdChain = new MemDianAChain(AbstractChain.HENG_TUI_MEM_DIAN);
        AbstractChain fourChain = new ZongDaiBChain(AbstractChain.ZONG_DAI);
        AbstractChain fiveChain = new ZongDaiAChain(AbstractChain.HENG_TUI_ZONG_DAI);
        AbstractChain sixChain = new QuYuZongDaiBChain(AbstractChain.QU_YU_ZONG_DAI);
        AbstractChain sevenChain = new QuYuZongDaiAChain(AbstractChain.HENG_TUI_QU_YU_ZONG_DAI);

        firstChain.setNextChain(secondChain);
        secondChain.setNextChain(thirdChain);
        thirdChain.setNextChain(fourChain);
        fourChain.setNextChain(fiveChain);
        fiveChain.setNextChain(sixChain);
        sixChain.setNextChain(sevenChain);
        sevenChain.setNextChain(null);

        return firstChain;
    }

    private static LinkedList<Node> getNodes() {
        LinkedList<Node> linkedList = new LinkedList<>();
        int[] levels = {
                AbstractChain.QU_YU_ZONG_DAI,
                AbstractChain.HENG_TUI_QU_YU_ZONG_DAI};
        boolean[] selfBuy = {
                true,
                false
        };
        for (int i = 0; i < levels.length; i++) {
            linkedList.add(new Node(levels[i], selfBuy[i]));
        }
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList<Node> linkedList = getNodes();
        AbstractChain loggerChain = getChains();
        loggerChain.commission(null, linkedList);
    }
}