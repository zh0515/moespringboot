package cn.gov.gdupi.dao;

import cn.gov.gdupi.model.Base;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BaseMapper {
    @Insert("insert into base(name,create_time,remarks) values( #{name},now(),remarks  )")
    int addBase(@Param("name") String name, @Param("remarks") String remarks);

    @Cacheable(key = "id", value = "base")
    @Select("select id,name,create_time,remarks from base where del_flag='0' and name like %#{name}% limit #{from},#{limit}")
    List<Base> getBaselist(@Param("name") String name, @Param("from") Integer from, @Param("limit") Integer limit);

    @Select("select id,name,create_time,remarks from base where id =#{id}")
    @Cacheable(key = "id", value = "base")
    Base findById(@Param("id") Integer id);

    @Select("select id,name,create_time,remarks  from base where name =#{name}")
    Base findByName(@Param("name") String name);

    @Cacheable(key = "id", value = "base")
    @Update("update base set name=#{name},remarks=${remarks}  where  id=#{id}")
    int updateById(@Param("id") Integer id, @Param("name") String name, @Param("remarks") String remarks);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update base set del_tag='1' where id=#{id}")
    int deleteById(@Param("id") Integer id);

}
