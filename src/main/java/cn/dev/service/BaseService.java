package cn.dev.service;


import cn.dev.dao.read.RBaseMapper;
import cn.dev.dao.write.WBaseMapper;
import cn.dev.model.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    RBaseMapper rbaseMapper;

    @Autowired
    WBaseMapper wbaseMapper;

    public Base getBaseByName(String name) {
        return rbaseMapper.findByName(name);
    }

    public Base getBaseByID(Integer id) {
        return rbaseMapper.findById(id);
    }

    public List<Base> getBaselist(String name, int from, int limit) {
        List<Base> bases = rbaseMapper.getBaselist(name, from, limit);
        return bases;
    }

    public String updateBaseByID(Integer id, String name, String remarks) {
        int count = wbaseMapper.updateById(id, name, remarks);
        return count + "";
    }

    public String deleteBaseByID(Integer id) {
        int count = wbaseMapper.deleteById(id);
        return count + "";
    }

    public String addBase(Base base) {
        int count = wbaseMapper.addBase(base.getName(), base.getRemarks());
        return count + "";
    }

}
