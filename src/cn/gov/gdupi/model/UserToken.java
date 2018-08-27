package cn.gov.gdupi.model;

import lombok.Data;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 *
 * @author ScienJus
 * @date 2015/7/31.
 */
@Data
public class UserToken {

    //用户id
    private long userId;

    //随机生成的uuid
    private String token;

    public UserToken(long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

}