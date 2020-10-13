package com.waya.sentinel.service;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

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
     * blockHandler / blockHandlerClass: blockHandler 对应处理 BlockException 的函数名称，可选项。若未配置，则将 BlockException
     * 直接抛出。blockHandler 函数访问范围需要是 public，返回类型需要与原方法相匹配，参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。blockHandler
     * 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
     * fallback: fallback 函数名称，可选项，仅针对降级功能生效（DegradeException）。fallback 函数的访问范围需要是
     * public，参数类型和返回类型都需要与原方法相匹配，并且需要和原方法在同一个类中。业务异常不会进入 fallback 逻辑。
     */
    @SentinelResource(value = "someThing", blockHandler = "someThingHandler")
    public String saySomeThing(String name) {
        return " some one say: " + name;
    }

    public String someThingHandler(String name, BlockException e) {
        e.printStackTrace();
        return name + " 被限流了";
    }
}
