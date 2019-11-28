package com.java_practice_code.designpattern.strategy;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/28.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Strategy strategy = StrategyFactory.getStrategy(StrategyEnum.WeiXin);
        weiXinPay(strategy);
        strategy = StrategyFactory.getStrategy(StrategyEnum.ZhiFuBao);
        zhiFuBaoPay(strategy);
    }

    private static void weiXinPay(Strategy strategy) throws Exception {
        if (strategy instanceof WeiXinPayStrategy) {
            WeiXinPayStrategy weiXinPayStrategy = (WeiXinPayStrategy) strategy;
            weiXinPayStrategy.pay();
        } else {
            throw new Exception("wrong type");
        }
    }

    private static void zhiFuBaoPay(Strategy strategy) throws Exception {
        if (strategy instanceof ZhiFuBaoStrategy) {
            ZhiFuBaoStrategy zhiFuBaoStrategy = (ZhiFuBaoStrategy) strategy;
            zhiFuBaoStrategy.pay();
        } else {
            throw new Exception("wrong type");
        }
    }
}
