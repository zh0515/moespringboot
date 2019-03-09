package cn.dev.controller;

import cn.dev.model.CommonResp;
import cn.dev.model.Role;
import cn.dev.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Value("${limit}")
    Integer searchlimit;

    @ApiOperation(value = "根基id或者name获取单条", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResp get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer id) {
        CommonResp resp = new CommonResp();
        if (name != null) {
            resp.setResult(roleService.getRoleByName(name));
        } else if (id != null) {
            resp.setResult(roleService.getRoleByID(id));
        } else {
            resp.setCode(-1);
            resp.setMessage("name or id need");
        }
        return resp;
    }

    @ApiOperation(value = "根据name搜索Role", notes = "")
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public CommonResp search(@RequestParam(required = false) String name, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        CommonResp resp = new CommonResp();

        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = searchlimit;
        }
        resp.setResult(roleService.getRolelist(name, offset, limit));
        return resp;
    }

    @ApiOperation(value = "根基id删除role", notes = "")
    @RequestMapping(value = "search", method = RequestMethod.DELETE)
    public CommonResp search(@RequestParam Integer id) {
        CommonResp resp = new CommonResp();
        resp.setResult(roleService.deleteRoleByID(id));
        return resp;
    }

    @ApiOperation(value = "根基id更新role", notes = "")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public CommonResp update(@RequestParam Integer id, @RequestBody Role role) {
        CommonResp resp = new CommonResp();
        resp.setResult(roleService.updateRoleByID(id, role.getName(), role.getRemarks()));
        return resp;
    }


    @ApiOperation(value = "创建role", notes = "")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public CommonResp insert(@RequestBody Role role) {
        CommonResp resp = new CommonResp();
        resp.setResult(roleService.addRole(role));
        return resp;
    }
}
