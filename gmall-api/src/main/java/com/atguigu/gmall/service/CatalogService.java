package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author zhengzhiran
 * @version 1.0
 * @date 2020/4/24 21:20
 */
public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalogId);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
