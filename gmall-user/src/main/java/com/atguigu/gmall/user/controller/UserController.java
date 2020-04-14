package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    //注入UserService类
    @Autowired
    UserService userService;

    //查询UmsMemberReceiveAddress表的全部信息，返回给前台
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){

        List<UmsMemberReceiveAddress> UmsMemberReceiveAddress = userService.getReceiveAddressByMemberId(memberId);

        return UmsMemberReceiveAddress;
    }

    //查询umsMembers全部信息，返回给前台
    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers = userService.getAllUser();

        return umsMembers;
    }

    //登陆到首页index
    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }
}
