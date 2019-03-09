package cn.dev.dao;

import cn.dev.model.Base;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BaseMapper {

    List<Base> getBaselist(@Param("name") String name, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select id,name,create_time,remarks from base where id =#{id}")
    @Cacheable(key = "#p0", value = "base")
    Base findById(@Param("id") Integer id);

    @Select("select id,name,create_time,remarks  from base where name =#{name}")
    Base findByName(@Param("name") String name);

}
