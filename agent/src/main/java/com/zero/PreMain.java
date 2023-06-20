package com.zero;

import java.lang.instrument.Instrumentation;

/**
 * @author: Zero
 * @date: 2023-06-20 18:35
 * @desc: preMain 方式
 */
public class PreMain {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("premain 开始执行");
        inst.addTransformer(new TransformerTest(), true);
        System.out.println("premain 执行结束");
    }
}
