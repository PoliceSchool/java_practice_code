package com.java_practice_code.工作中常用的代码或者工具类;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/10/22.
 */
public class map的lambda表达式 {
    public static void main(String[] args) {
        List<YxShareRecord> list = getList();
        Map<String, Map<String, MergeRecord>> map = new HashMap<>(15);
        // 这个for循环用来分类，不同的商品一类，不同的用户一类，便于下一个循环合并记录
        for (YxShareRecord record : list) {
            // 针对不同的用户进行分类
            Map<String, MergeRecord> userMap = map.compute(record.getShareUserId(), (k, v) -> (v == null) ? new HashMap<>(15) : v);
            userMap.compute(record.getSettingId(), (k, v) -> (v == null) ? new MergeRecord() : v).addRecord(record);
        }
        System.out.println();
    }

    public static List<YxShareRecord> getList() {
        List<YxShareRecord> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            YxShareRecord record = new YxShareRecord();
            record.setSettingId("settingId" + i % 5);
            record.setShareUserId("shareUserId" + i % 2);
            list.add(record);
        }
        return list;
    }
}
