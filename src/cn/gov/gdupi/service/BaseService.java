package cn.gov.gdupi.service;


import cn.gov.gdupi.dao.BaseMapper;
import cn.gov.gdupi.model.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    BaseMapper baseMapper;

    public Base getBaseByName(String name) {
        return baseMapper.findByName(name);
    }

    public Base getBaseByID(Integer id) {
        return baseMapper.findById(id);
    }

    public List<Base> getBaselist(String name, int from, int limit) {
        List<Base> bases = baseMapper.getBaselist(name, from, limit);
        return bases;
    }

    public String updateBaseByID(Integer id, String name, String remarks) {
        int count = baseMapper.updateById(id, name, remarks);
        return count + "";
    }

    public String deleteBaseByID(Integer id) {
        int count = baseMapper.deleteById(id);
        return count + "";
    }

}
