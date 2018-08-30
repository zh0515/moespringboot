package cn.gov.gdupi.dao.write;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;

public interface RoleMapper {
    @Insert("insert into role(name,create_time,remarks) values( #{name},now(),remarks  )")
    int addRole(@Param("name") String name, @Param("remarks") String remarks);

    @CacheEvict(key = "#p0", value = "role")
    @Update("update role set name=#{name},remarks=#{remarks}  where  id=#{id}")
    int updateById(@Param("id") Integer id, @Param("name") String name, @Param("remarks") String remarks);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update role set del_tag='1' where id=#{id}")
    int deleteById(@Param("id") Integer id);

}
