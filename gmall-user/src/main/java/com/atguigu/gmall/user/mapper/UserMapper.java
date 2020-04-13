package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.user.bean.UmsMembers;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

public interface UserMapper  {
    List<UmsMembers> selectAllUser();
    //extends Mapper<UmsMembers>
}
