package com.java_practice_code.designpattern.chain_of_responsibility.my_version;


import java.util.LinkedList;

public class ChainPatternDemo {
    private static AbstractChain getChains() {
        AbstractChain firstChain = new MemberAChain(AbstractChain.MEMBER_A);
        AbstractChain secondChain = new MemDianBChain(AbstractChain.MEMDIAN_B);
        AbstractChain thirdChain = new MemDianAChain(AbstractChain.MEMDIAN_A);
        AbstractChain fourChain = new ZongDaiBChain(AbstractChain.ZONGDAI_B);
        AbstractChain fiveChain = new ZongDaiAChain(AbstractChain.ZONGDAI_A);
        AbstractChain sixChain = new QuYuZongDaiBChain(AbstractChain.QUYUZONGDAI_B);
        AbstractChain sevenChain = new QuYuZongDaiAChain(AbstractChain.QUYUZONGDAI_A);

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
        int[] levels = {2, 4, 6};
        for (int level : levels) {
            linkedList.add(new Node(level));
        }
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList<Node> linkedList = getNodes();
        AbstractChain loggerChain = getChains();
        loggerChain.commission(null, linkedList);
    }
}