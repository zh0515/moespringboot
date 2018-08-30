package cn.gov.gdupi.dao.write;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;

public interface WBaseMapper {
    @Insert("insert into base(name,create_time,remarks) values( #{name},now(),remarks  )")
    int addBase(@Param("name") String name, @Param("remarks") String remarks);

    @CacheEvict(key = "#p0", value = "base")
    @Update("update base set name=#{name},remarks=#{remarks}  where  id=#{id}")
    int updateById(@Param("id") Integer id, @Param("name") String name, @Param("remarks") String remarks);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update base set del_tag='1' where id=#{id}")
    int deleteById(@Param("id") Integer id);

}
