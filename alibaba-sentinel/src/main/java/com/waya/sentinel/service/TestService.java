package com.waya.sentinel.service;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * TODO
 *
 * @author BoJan
 * @version v 1.0
 * @date 2020/10/12 11:09
 */
@Service
public class TestService {


    /**
     * @SentinelResourse 标识资源是否被限流， 降级。 value 属性表示 资源名称
     */
    @SentinelResource(value = "someThing")
    public String saySomeThing(String name) {
        return " some one say: " + name;
    }

}
