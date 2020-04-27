package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @author zhengzhiran
 * @version 1.0
 * @date 2020/4/25 23:23
 */
public interface AttrService {

    //对平台属性进行修改,传入参数catalog3Id
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    //对平台属性进行保存
    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
