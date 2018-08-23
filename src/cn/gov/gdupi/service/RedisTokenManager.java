package cn.gov.gdupi.service;

import cn.gov.gdupi.model.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTokenManager implements TokenManager {
    @Value("${token.expires}")
    Long TOKEN_EXPIRES_HOUR;

    @Autowired
    RedisTemplate redisTemplate;

    public UserToken createToken(long userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        UserToken model = new UserToken(userId, token);
        //存储到redis并设置过期时间
        redisTemplate.boundValueOps(userId).set(token, TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    public UserToken getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new UserToken(userId, token);
    }

    public boolean checkToken(UserToken model) {
        if (model == null) {
            return false;
        }
        Object token = redisTemplate.boundValueOps(model.getUserId()).get();

        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisTemplate.boundValueOps(model.getUserId()).expire(TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(long userId) {
        redisTemplate.delete(userId);
    }
}