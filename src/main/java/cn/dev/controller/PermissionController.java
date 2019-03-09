package cn.dev.controller;

import cn.dev.model.CommonResp;
import cn.dev.model.Permission;
import cn.dev.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @Value("${limit}")
    Integer searchlimit;

    @ApiOperation(value = "根基id或者name获取单条", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResp get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer id) {
        CommonResp resp = new CommonResp();
        if (name != null) {
            resp.setResult(permissionService.getPermissionByName(name));
        } else if (id != null) {
            resp.setResult(permissionService.getPermissionByID(id));
        } else {
            resp.setCode(-1);
            resp.setMessage("name or id need");
        }
        return resp;
    }

    @ApiOperation(value = "根据name搜索Permission", notes = "")
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public CommonResp search(@RequestParam(required = false) String name, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        CommonResp resp = new CommonResp();

        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = searchlimit;
        }
        resp.setResult(permissionService.getPermissionlist(name, offset, limit));
        return resp;
    }

    @ApiOperation(value = "根基id删除permission", notes = "")
    @RequestMapping(value = "search", method = RequestMethod.DELETE)
    public CommonResp search(@RequestParam Integer id) {
        CommonResp resp = new CommonResp();
        resp.setResult(permissionService.deletePermissionByID(id));
        return resp;
    }

    @ApiOperation(value = "根基id更新permission", notes = "")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public CommonResp update(@RequestParam Integer id, @RequestBody Permission permission) {
        CommonResp resp = new CommonResp();
        resp.setResult(permissionService.updatePermissionByID(id, permission.getName(), permission.getRemarks()));
        return resp;
    }


    @ApiOperation(value = "创建permission", notes = "")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public CommonResp insert(@RequestBody Permission permission) {
        CommonResp resp = new CommonResp();
        resp.setResult(permissionService.addPermission(permission));
        return resp;
    }
}
