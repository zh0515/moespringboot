package cn.dev.dao.read;

import cn.dev.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 　　@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
 * <p>
 * 　　@CachePut，指定key，将更新的结果同步到redis中
 * <p>
 * 　　@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
 */

public interface RUserMapper {

    @Cacheable(key = "id", value = "user")
    @Select("select id,name,create_time,remarks,role from user where del_flag='0' and name like %#{name}% limit #{from},#{limit}")
    List<User> getUserlist(@Param("name") String name, @Param("from") Integer from, @Param("limit") Integer limit);

    @Select("select id,name,create_time,remarks,role from user where id =#{id}")
    @Cacheable(key = "id", value = "user")
    User findById(@Param("id") String id);

    @Select("select id,name,create_time,remarks,password,role from user where name =#{name}")
    User findByName(@Param("name") String name);


}
