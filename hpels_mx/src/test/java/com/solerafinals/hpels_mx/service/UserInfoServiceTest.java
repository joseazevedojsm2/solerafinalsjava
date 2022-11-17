package com.solerafinals.hpels_mx.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.solerafinals.hpels_mx.entity.UserInfo;
import com.solerafinals.hpels_mx.repository.UserInfoRepository;
import com.solerafinals.hpels_mx.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserInfoServiceTest {

    @MockBean
    private UserInfoRepository repository;
    @InjectMocks
    private UserInfoService service;

    private static UserInfo newUserInfo;

    @Autowired
    public  UserInfoServiceTest (UserInfoService service) {
        this.service = service;
    }

    @Test
    void whenUserAddInfo_withEmptyFirstName_shouldFail() {
        UserInfo user = new UserInfo("","Mathew",900000000L,"user@email.com");

        UserInfo newUser = service.createUserInfo(user);

        assertEquals(null,newUser);
    }

    @Test
    void whenUserAddInfo_withEmptyLastName_shouldFail() {
        UserInfo user = new UserInfo("Lucas","",900000000L,"user@email.com");

        UserInfo newUser = service.createUserInfo(user);

        assertEquals(null,newUser);
    }

    @Test
    void whenUserAddInfo_withEmptyEmail_shouldFail() {
        UserInfo user = new UserInfo("Lucas","Mathew",900000000L,"");

        UserInfo newUser = service.createUserInfo(user);

        assertEquals(null,newUser);
    }

    @Test
    void whenUserAddInfo_withEmptyPhoneNumber_shouldFail() {
        UserInfo user = new UserInfo("Lucas","Mathew","");

        UserInfo newUser = service.createUserInfo(user);

        assertEquals(null,newUser);
    }



}
