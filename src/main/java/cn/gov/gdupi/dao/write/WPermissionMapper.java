package cn.gov.gdupi.dao.write;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;

public interface WPermissionMapper {
    @Insert("insert into permission(name,create_time,remarks) values( #{name},now(),remarks  )")
    Integer addPermission(@Param("name") String name, @Param("remarks") String remarks);

    @CacheEvict(key = "#p0", value = "permission")
    @Update("update permission set name=#{name},remarks=#{remarks}  where  id=#{id}")
    Integer updateById(@Param("id") Integer id, @Param("name") String name, @Param("remarks") String remarks);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update permission set del_tag='1' where id=#{id}")
    Integer deleteById(@Param("id") Integer id);

}
