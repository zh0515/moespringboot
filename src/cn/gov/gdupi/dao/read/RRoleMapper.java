package cn.gov.gdupi.dao.read;

import cn.gov.gdupi.model.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface RRoleMapper {

    List<Role> getRolelist(@Param("name") String name, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select id,name,create_time,remarks from role where id =#{id}")
    @Cacheable(key = "#p0", value = "role")
    Role findById(@Param("id") Integer id);

    @Select("select id,name,create_time,remarks  from role where name =#{name}")
    Role findByName(@Param("name") String name);

}
