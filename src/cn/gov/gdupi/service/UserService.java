package cn.gov.gdupi.service;

import cn.gov.gdupi.dao.UserMapper;
import cn.gov.gdupi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }

    public String logintoken() {
        return "";
    }

    public String createUser(User user) {
        return "";
    }
}