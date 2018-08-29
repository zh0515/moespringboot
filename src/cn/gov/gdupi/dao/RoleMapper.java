package cn.gov.gdupi.dao;

import cn.gov.gdupi.model.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Insert("insert into role(name ) values(#{name} )")
    int addrole(@Param("name") String name);

    @Select("select id,name,permission from role where  del_flag='0' and name like %#{name}% limit #{from},#{limit}")
    List<Role> getRolelist(@Param("name") String name, @Param("from") Integer from, @Param("limit") Integer limit);
}
