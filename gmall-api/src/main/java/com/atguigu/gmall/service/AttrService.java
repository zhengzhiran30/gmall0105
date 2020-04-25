package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;

import java.util.List;

/**
 * @author zhengzhiran
 * @version 1.0
 * @date 2020/4/25 23:23
 */
public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
}
