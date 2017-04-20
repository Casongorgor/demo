package cn.demo.service1.controller;

import cn.demo.service1.client.Service0Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cason
 *
 */
@RestController
public class Service1Controller {

    @Autowired
    Service0Client service0Client;

    @ApiOperation(value="测试调用service0的服务", notes="sleepSec就是睡眠时间，时间长的时候会超时，从而触发断路器，要的就是这种效果！")
    @GetMapping("/test/{sleepSec}")
    public String test(
            @PathVariable int sleepSec
    ) {
        try {
            return service0Client.test("Cason", sleepSec);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
