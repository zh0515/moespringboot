package cn.gov.gdupi.service;


import cn.gov.gdupi.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    cn.gov.gdupi.dao.read.RoleMapper rroleMapper;
    cn.gov.gdupi.dao.write.RoleMapper wroleMapper;

    public Role getRoleByName(String name) {
        return rroleMapper.findByName(name);
    }

    public Role getRoleByID(Integer id) {
        return rroleMapper.findById(id);
    }

    public List<Role> getRolelist(String name, int from, int limit) {
        List<Role> roles = rroleMapper.getRolelist(name, from, limit);
        return roles;
    }

    public String updateRoleByID(Integer id, String name, String remarks) {
        int count = wroleMapper.updateById(id, name, remarks);
        return count + "";
    }

    public String deleteRoleByID(Integer id) {
        int count = wroleMapper.deleteById(id);
        return count + "";
    }

    public String addRole(Role role) {
        int count = wroleMapper.addRole(role.getName(), role.getRemarks());
        return count + "";
    }

}
