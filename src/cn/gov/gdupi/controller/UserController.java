package cn.gov.gdupi.controller;

import cn.gov.gdupi.model.User;
import cn.gov.gdupi.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    static final Logger logger = LogManager.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestBody String body) {

        JSONObject reqbody = (JSONObject) JSON.parse(body);
        logger.info(reqbody);
        String username = reqbody.getString("username");
        String password = reqbody.getString("password");
        if (Strings.isEmpty(username) || Strings.isEmpty(password)) {
            return "username or password isEmpty";
        }
        return userService.logintoken();
    }


    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String createuser(@RequestBody String body) {
        User user = JSON.parseObject(body, User.class);
        if (Strings.isEmpty(user.getName()) || Strings.isEmpty(user.getPassword())) {
            return "username or password isEmpty";
        }
        return userService.createUser(user);
    }
}
