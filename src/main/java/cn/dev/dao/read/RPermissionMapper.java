package cn.dev.dao.read;

import cn.dev.model.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface RPermissionMapper {

    List<Permission> getPermissionlist(@Param("name") String name, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select id,name,create_time,remarks from permission where id =#{id}")
    @Cacheable(key = "#p0", value = "permission")
    Permission findById(@Param("id") Integer id);

    @Select("select id,name,create_time,remarks  from permission where name =#{name}")
    Permission findByName(@Param("name") String name);

}
