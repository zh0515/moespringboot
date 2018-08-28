package cn.gov.gdupi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface CronMapper {
    @Select("select id,name,cron,create_time,remarks,cron,dockerrepo,cmd from cron ")
    @Cacheable(key = "id", value = "cron")
    String getCron();

    @Cacheable(key = "id", value = "cron")
    @Update("update cron set cron=#{cron} where id=#{id}")
    void setcronById(@Param("id") String id, @Param("cron") String cron);

    @Cacheable(key = "id", value = "cron")
    @Update("update cron set cmd=#{cmd} where id=#{id}")
    void setcmdById(@Param("id") String id, @Param("cmd") String cmd);

    @Cacheable(key = "id", value = "cron")
    @Update("update cron set git=#{git} where id=#{id}")
    void setgitById(@Param("id") String id, @Param("git") String git);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key = "#p0", allEntries = true)
    @Update("update cron set del_tag='1' where id=#{id}")
    void deleteById(@Param("id") String id);
}