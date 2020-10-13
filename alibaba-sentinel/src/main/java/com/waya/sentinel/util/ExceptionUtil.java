package com.waya.sentinel.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 限流，熔断处理类
 *
 * @author BoJan
 * @version v 1.0
 * @date 2020/10/12 16:09
 */
public class ExceptionUtil {

    public static String someThingHandler(String name, BlockException e) {
        e.printStackTrace();
        return name + " 被限流了";
    }

}
