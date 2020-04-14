package com.atguigu.gmall.user.service;
/**
 * @author zhengzhiran
 * @version 1.0
 * @date 2020/4/14 21:55
 */
import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;


public interface UserService {

    List<UmsMember> getAllUser();

    //定义一个方法查询到所有的UmsMemberReceiveAddress的memberId    注意：在请求地址栏上传入...?memberId=数据
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
