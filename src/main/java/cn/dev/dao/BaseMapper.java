package cn.dev.dao;

import cn.dev.model.Base;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BaseMapper {

    List<Base> getBaselist(@Param("name") String name, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select id,name,create_time,remarks from base where id =#{id}")
    @Cacheable(key = "#p0", value = "base")
    Base findById(@Param("id") Integer id);

    @Select("select id,name,create_time,remarks  from base where name =#{name}")
    Base findByName(@Param("name") String name);


    @Insert("insert into base(name,create_time,remarks) values( #{name},now(),remarks  )")
    Integer addBase(@Param("name") String name, @Param("remarks") String remarks);

    @CacheEvict(key = "#p0", value = "base")
    @Update("update base set name=#{name},remarks=#{remarks}  where  id=#{id}")
    Integer updateById(@Param("id") Integer id, @Param("name") String name, @Param("remarks") String remarks);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update base set del_tag='1' where id=#{id}")
    Integer deleteById(@Param("id") Integer id);
}
