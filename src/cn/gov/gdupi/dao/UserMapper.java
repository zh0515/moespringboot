package cn.gov.gdupi.dao;

import cn.gov.gdupi.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

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
    @Insert("insert into user(name,password) values(#{name},#{password})")
    int addUser(@Param("name") String name, @Param("password") String password);

    @Select("select id,name,role from user where id =#{id}")
    @Cacheable(key = "id", value = "user")
    User findById(@Param("id") String id);

    @Select("select id,name,password,role from user where name =#{name}")
    @Cacheable(key = "'name'", value = "user")
    User findByName(@Param("name") String name);

    @Cacheable(key = "id", value = "user")
    @Update("update user set name=#{name} where id=#{id}")
    void setnameById(@Param("id") String id, @Param("name") String name);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update user set del_tag='1' where id=#{id}")
    void deleteById(@Param("id") String id);

    @Select("select id,name,role from user where name like %#{name}% ")
    List<User> getUserlist();
}
