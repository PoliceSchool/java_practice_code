package com.java_practice_code.designpattern.adapter.thridpartycode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 杂物商品实体
 * 第三方代码,需要使用适配器才能被当前服务代码调用
 */
@Data
@Getter
@Setter
@AllArgsConstructor
public class GroceryItem {
    private String itemName;
    private int costPerUnit;
}
