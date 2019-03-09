package cn.dev.service;

import cn.dev.model.UserToken;

public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     *
     * @param userId 指定用户的id
     * @return 生成的token
     */
    UserToken createToken(long userId);

    /**
     * 检查token是否有效
     *
     * @param model token
     * @return 是否有效
     */
    boolean checkToken(UserToken model);

    /**
     * 从字符串中解析token
     *
     * @param authentication 加密后的字符串
     * @return
     */
    UserToken getToken(String authentication);

    /**
     * 清除token
     *
     * @param userId 登录用户的id
     */
    void deleteToken(long userId);

}