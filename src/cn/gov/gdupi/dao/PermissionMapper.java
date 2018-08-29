package cn.gov.gdupi.dao;

import cn.gov.gdupi.model.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Insert("insert into permission(name ) values(#{name} )")
    int addPermission(@Param("name") String name);


    @Select("select id,name from permission where  del_flag='0' and name like %#{name}% limit #{from},#{limit}")
    List<Permission> getPermissionlist(@Param("name") String name, @Param("from") Integer from, @Param("limit") Integer limit);
}
