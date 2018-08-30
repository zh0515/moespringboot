package cn.gov.gdupi.dao;

import cn.gov.gdupi.model.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface RoleMapper {
    @Insert("insert into role(name,create_time,remarks,permission) values( #{name},now(),#{remarks},#{permissions})")
    int addRole(@Param("name") String name, @Param("remarks") String remarks, @Param("permissions") String permissions);


    List<Role> getRolelist(@Param("name") String name, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select id,name,create_time,remarks,permissions from role where id =#{id}")
    @Cacheable(key = "#p0", value = "role")
    Role findById(@Param("id") Integer id);

    @Select("select id,name,create_time,remarks,permissions  from role where name =#{name}")
    Role findByName(@Param("name") String name);

    @CacheEvict(key = "#p0", value = "role")
    @Update("update role set name=#{name},remarks=#{remarks},permissions=#{permissions}  where  id=#{id}")
    int updateById(@Param("id") Integer id, @Param("name") String name, @Param("remarks") String remarks, @Param("permissions") String permissions);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update role set del_tag='1' where id=#{id}")
    int deleteById(@Param("id") Integer id);

}
