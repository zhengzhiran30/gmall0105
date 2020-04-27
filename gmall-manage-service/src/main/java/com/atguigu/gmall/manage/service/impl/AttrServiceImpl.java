package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.atguigu.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.List;

/**
 * @author zhengzhiran
 * @version 1.0
 * @date 2020/4/25 23:24
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    //修改属性
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    //保存平台属性值
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

       String id =  pmsBaseAttrInfo.getId();

       //判断id是否为空，id为空，保存
       if(StringUtils.isBlank(id)){


           //保存属性
           //insertSelective 插入数据库
           pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

           //保存属性值
           List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
           for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {

               pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());

               pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);

           }

       }else {
        //id不为空，为修改
           //根据id修改
           //属性修改
           Example example = new Example(PmsBaseAttrInfo.class);
           example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
           pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

           //属性值修改
          //按照属性id删除所有属性值
          PmsBaseAttrValue pmsBaseAttrValueDel = new PmsBaseAttrValue();
          pmsBaseAttrValueDel.setAttrId(pmsBaseAttrInfo.getId());
          pmsBaseAttrValueMapper.delete(pmsBaseAttrValueDel);


           List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
          //删除后，将新的属性值插入
           for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {

               pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());

              pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
           }
       }


        return "success";
    }

    //实现getAttrValueList的方法，为修改页面查询一个平台属性值得集合
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }


}
