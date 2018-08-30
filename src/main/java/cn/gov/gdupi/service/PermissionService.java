package cn.gov.gdupi.service;


import cn.gov.gdupi.dao.read.RPermissionMapper;
import cn.gov.gdupi.dao.write.WPermissionMapper;
import cn.gov.gdupi.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    RPermissionMapper rpermissionMapper;

    @Autowired
    WPermissionMapper wpermissionMapper;

    public Permission getPermissionByName(String name) {
        return rpermissionMapper.findByName(name);
    }

    public Permission getPermissionByID(Integer id) {
        return rpermissionMapper.findById(id);
    }

    public List<Permission> getPermissionlist(String name, int from, int limit) {
        List<Permission> permissions = rpermissionMapper.getPermissionlist(name, from, limit);
        return permissions;
    }

    public String updatePermissionByID(Integer id, String name, String remarks) {
        int count = wpermissionMapper.updateById(id, name, remarks);
        return count + "";
    }

    public String deletePermissionByID(Integer id) {
        int count = wpermissionMapper.deleteById(id);
        return count + "";
    }

    public String addPermission(Permission permission) {
        int count = wpermissionMapper.addPermission(permission.getName(), permission.getRemarks());
        return count + "";
    }

}
