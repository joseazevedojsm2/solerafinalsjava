package com.solerafinals.hpels_mx.service;

import com.solerafinals.hpels_mx.entity.UserInfo;
import com.solerafinals.hpels_mx.repository.UserInfoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    private UserInfoRepository repository;

    @Autowired
    public UserInfoService(UserInfoRepository repository) {
        this.repository = repository;
    }

    public UserInfo createUserInfo(UserInfo user){
        if(user.getFirst_name().isEmpty() || user.getLast_name().isEmpty()
            || user.getEmail().isEmpty() || user.getPhone_number()<900000000)
            return null;

        UserInfo newUser = repository.save(user);

        return newUser;
    }

    public List<UserInfo> getAllUsersInfo(){
        List<UserInfo> users = repository.findAll();

        if(users.isEmpty())
            return null;

        return users;
    }

    public UserInfo getUserInfoById(int id){
        Optional<UserInfo> user = repository.findAll().stream().filter(
                userInfo -> userInfo.getId() == id
        ).findFirst();

        if(!user.isPresent())
            return null;

        return user.get();
    }
}
