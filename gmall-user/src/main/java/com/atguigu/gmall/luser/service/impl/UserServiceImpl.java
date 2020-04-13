package com.atguigu.gmall.luser.service.impl;

import com.atguigu.gmall.luser.mapper.UserMapper;
import com.atguigu.gmall.luser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
}
