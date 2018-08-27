package cn.gov.gdupi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    @Insert("insert into role(name ) values(#{name} )")
    int addrole(@Param("name") String name);

}
