package cn.gov.gdupi.controller;


import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("file")
public class FileController {
    static final Logger logger = LogManager.getLogger(FileController.class.getName());

    @ApiOperation(value = "上传新文件", notes = "上传新文件")
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String uploadfile(@RequestBody String body, @RequestParam String filename, @RequestParam String filetype) {

        logger.info(filename, filename, body);
        return "";
    }
}
