package cn.gov.gdupi.controller;

import cn.gov.gdupi.model.CommonResp;
import cn.gov.gdupi.service.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("base")
public class BaseController {
    @Autowired
    BaseService baseService;

    @ApiOperation(value = "根基id或者name获取单条", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResp get(@RequestParam String name, @RequestParam Integer id) {
        CommonResp resp = new CommonResp();
        if (name != null) {
            resp.setResult(baseService.getBaseByName(name));
        } else if (id != null) {
            resp.setResult(baseService.getBaseByID(id));
        } else {
            resp.setCode(-1);
            resp.setMessage("name or id need");
        }
        return resp;
    }

    @ApiOperation(value = "根据name搜索Base", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResp search(@RequestParam String name, @RequestParam Integer from, @RequestParam Integer limit) {
        CommonResp resp = new CommonResp();
        resp.setResult(baseService.getBaselist(name, from, limit));
        return resp;
    }
}
