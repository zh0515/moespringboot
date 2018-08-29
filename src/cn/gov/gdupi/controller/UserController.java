package cn.gov.gdupi.controller;

import cn.gov.gdupi.model.User;
import cn.gov.gdupi.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "登录", notes = "用户名密码登录")
    @ApiImplicitParam(name = "login", value = "用户详细实体user", required = true, dataType = "cn.gov.gdupi.model.UserInfo")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestBody String body) {

        JSONObject reqbody = (JSONObject) JSON.parse(body);
        logger.info(reqbody);
        String name = reqbody.getString("name");
        String password = reqbody.getString("password");
        if (Strings.isEmpty(name) || Strings.isEmpty(password)) {
            return "username or password isEmpty";
        }
        return userService.logintoken(name, password);
    }

    @ApiOperation(value = "创建新用户", notes = "创建新用户")
    @ApiImplicitParam(name = "createuser", value = "用户详细实体user", required = true, dataType = "cn.gov.gdupi.model.UserInfo")
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String createuser(@RequestBody String body) {
        User user = JSON.parseObject(body, User.class);
        if (Strings.isEmpty(user.getName()) || Strings.isEmpty(user.getPassword())) {
            return "username or password isEmpty";
        }
        return userService.createUser(user);
    }


    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @ApiImplicitParam(name = "updateuser", value = "用户详细实体user", required = true, dataType = "cn.gov.gdupi.model.UserInfo")
    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public String updateuser(@RequestBody String body) {
        User user = JSON.parseObject(body, User.class);
        if (Strings.isEmpty(user.getName()) || Strings.isEmpty(user.getPassword())) {
            return "username or password isEmpty";
        }
        return userService.createUser(user);
    }


}
