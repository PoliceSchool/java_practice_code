package com.java_practice_code.工作中常用的代码或者工具类;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/10/22.
 */
public class YxShareRecord {
    private String shareUserId;

    private String settingId;

    public String getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(String shareUserId) {
        this.shareUserId = shareUserId;
    }

    public String getSettingId() {
        return settingId;
    }

    public void setSettingId(String settingId) {
        this.settingId = settingId;
    }

    @Override
    public String toString() {
        return "YxShareRecord{" +
                "shareUserId='" + shareUserId + '\'' +
                ", settingId='" + settingId + '\'' +
                '}';
    }
}
