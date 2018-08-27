package cn.gov.gdupi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {

    @Insert("insert into permission(name ) values(#{name} )")
    int addPermission(@Param("name") String name);

}
