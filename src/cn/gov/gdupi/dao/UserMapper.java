package cn.gov.gdupi.dao;

import cn.gov.gdupi.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by zl on 2015/8/27.
 * https://www.cnblogs.com/gdpuzxs/p/7222309.html
 * 　　@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
 * <p>
 * 　　@CachePut，指定key，将更新的结果同步到redis中
 * <p>
 * 　　@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
 */

public interface  UserMapper {
    @Insert("insert into user(name,age) values(#{name},#{age})")
    int addUser(@Param("name") String name, @Param("age") String age);

    @Select("select * from user where id =#{id}")
    @Cacheable(key = "#p0")
    User findById(@Param("id") String id);

    @CachePut(key = "#p0")
    @Update("update user set name=#{name} where id=#{id}")
    void updataById(@Param("id") String id, @Param("name") String name);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Delete("delete from user where id=#{id}")
    void deleteById(@Param("id") String id);

    User findUserInfo();
}
