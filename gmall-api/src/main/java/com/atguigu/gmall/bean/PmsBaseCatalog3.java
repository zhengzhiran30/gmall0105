package com.atguigu.gmall.bean;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author zhengzhiran
 * @version 1.0
 * @date 2020/4/24 21:02
 */
public class PmsBaseCatalog3 implements Serializable {

    @Id
    private String id;
    private String name;
    private String catalog2Id;


}
