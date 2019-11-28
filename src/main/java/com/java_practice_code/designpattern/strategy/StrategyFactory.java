package com.java_practice_code.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/28.
 */
class StrategyFactory {
    private static Map<StrategyEnum, Strategy> strategyMap;

    static {
        strategyMap = new HashMap<>();
        strategyMap.put(StrategyEnum.WeiXin, new WeiXinPayStrategy());
        strategyMap.put(StrategyEnum.ZhiFuBao, new ZhiFuBaoStrategy());
    }

    static Strategy getStrategy(StrategyEnum type) {
        return strategyMap.get(type);
    }
}
