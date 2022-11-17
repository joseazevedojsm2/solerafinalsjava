package com.solerafinals.hpels_mx.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.solerafinals.hpels_mx.entity.UserInfo;
import com.solerafinals.hpels_mx.repository.UserInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
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
    void whenUserAddInfo_withInvalidEmail_shouldFail() {
        UserInfo user = new UserInfo("Lucas","Mathew",900000000L,"vsdfwcwefcefewd");

        UserInfo newUser = service.createUserInfo(user);

        assertEquals(null,newUser);
    }


    @Test
    void whenUserAddInfo_withEmptyPhoneNumber_shouldFail() {
        UserInfo user = new UserInfo("Lucas","Mathew","");

        UserInfo newUser = service.createUserInfo(user);

        assertEquals(null,newUser);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,-2})
    void whenUserGetInfoById_withNonExistantId_shouldFail(int id){
        Mockito.when(repository.findAll()).thenReturn(List.of());

        UserInfo user = service.getUserInfoById(id);

        assertEquals(null, user);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,-2})
    void whenUserUpdateInfoById_withNonExistantId_shouldFail(int id){
        UserInfo user = new UserInfo("Lucas","Mathew",900000000L,"lucasmathew@gmail.com");

        Mockito.when(repository.findAll()).thenReturn(List.of());

        UserInfo updatedUser = service.updateUserInfo(id,user);

        assertEquals(null, updatedUser);
    }

    @Test
    void whenUserUpdateInfoById_withWrongInfo_shouldFail(){
        int id = 1;
        UserInfo user = new UserInfo("Lucas","Mathew",900000000L,"");

        Mockito.when(repository.findAll()).thenReturn(null);

        UserInfo updatedUser = service.updateUserInfo(id,user);

        assertEquals(null, updatedUser);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,-2})
    void whenUserDeleteInfoById_withNonExistantId_shouldFail(int id){
        Mockito.when(repository.findAll()).thenReturn(null);

        Boolean deletedUser = service.deleteUserInfo(id);

        assertEquals(null, deletedUser);
    }

}
