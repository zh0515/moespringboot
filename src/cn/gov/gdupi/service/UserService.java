package cn.gov.gdupi.service;

import cn.gov.gdupi.dao.read.RUserMapper;
import cn.gov.gdupi.dao.write.WUserMapper;
import cn.gov.gdupi.model.User;
import cn.gov.gdupi.model.UserToken;
import cn.gov.gdupi.util.MD5;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private WUserMapper wuserMapper;
    private RUserMapper ruserMapper;

    @Autowired
    TokenManager tokenManager;

    public List<User> getUserlist(String name, int from, int limit) {
        List<User> user = ruserMapper.getUserlist(name, from, limit);

        return user;
    }

    public String logintoken(String name, String pwd) {
        User user = ruserMapper.findByName(name);
        String hashpwd = MD5.EncoderByMd5(pwd);
        JSONObject o = new JSONObject();

        if (user.getPassword().equals(hashpwd)) {
            o.put("code", 0);
            UserToken ut = tokenManager.createToken(user.getId());
            o.put("token", ut);
            return o.toJSONString();
        } else {
            o.put("code", 1);
            return o.toJSONString();
        }
    }

    public String createUser(User user) {
        String hashpwd = MD5.EncoderByMd5(user.getPassword());
        int count = wuserMapper.addUser(user.getName(), hashpwd, user.getRemarks());
        return "";
    }
}