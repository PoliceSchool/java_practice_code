package com.java_practice_code.工作中常用的代码或者工具类;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/10/9.
 */
public class 分解字符串并映射成map {
    public Map<String, Double> getItemCommissionMap() {
        final int itemIdIndex = 0;
        final int itemCommissionIndex = 1;
        final Map<String, Double> itemCommissionMap = new HashMap<>(3);
        try {
            String value = "aa:bb,cc:dd";
            String[] items = value.split(",");
            for (String item : items) {
                item = item.trim();
                String[] itemMap = item.split(":");
                if (itemMap.length < 2) {
                    System.out.println("商品佣金信息不完整, itemMap:" + itemMap);
                    continue;
                }
                itemCommissionMap.put(itemMap[itemIdIndex].trim(), Double.parseDouble(itemMap[itemCommissionIndex].trim()));
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.print("商品佣金信息不完整" + e);
        }
        System.out.println("商品佣金map：" + "商品佣金keySet:[" + itemCommissionMap.keySet() + "], 商品佣金values:[" + itemCommissionMap.values() + "]");
        return itemCommissionMap;
    }
}
