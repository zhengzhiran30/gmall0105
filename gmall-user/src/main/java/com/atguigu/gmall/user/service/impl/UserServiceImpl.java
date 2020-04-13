package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMembers;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMembers> getAllUser() {

        List<UmsMembers> umsMembersList= userMapper.selectAllUser(); //userMapper.selectAllUser();selectAll()
        return umsMembersList;
    }
}
