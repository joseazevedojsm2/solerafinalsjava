package com.solerafinals.hpels_mx.controller;

import com.solerafinals.hpels_mx.entity.UserInfo;
import com.solerafinals.hpels_mx.service.UserInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @PostMapping("/add")
    public UserInfo insertUserInfo(@RequestBody UserInfo user){
        return service.createUserInfo(user);
    }

    @GetMapping("/all")
    public List<UserInfo> retrieveAllUsersInfo(){
        return service.getAllUsersInfo();
    }

    @GetMapping("/{id}")
    public UserInfo retrieveUserInfoById(@PathVariable int id){
        return service.getUserInfoById(id);
    }
}
