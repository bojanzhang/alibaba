package com.waya.sentinel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.waya.sentinel.service.TestService;

/**
 * TODO
 *
 * @author BoJan
 * @version v 1.0
 * @date 2020/10/12 11:06
 */
@RestController
public class TestController {
    @Autowired
    private TestService service;

    @GetMapping(value = "say/{name}")
    public String say(@PathVariable String name) {
        return service.saySomeThing(name);
    }
}
