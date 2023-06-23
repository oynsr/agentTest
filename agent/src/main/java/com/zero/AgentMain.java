package com.zero;

import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author: Zero
 * @date: 2023-06-18 23:12
 * @desc: agentmain 方式
 */
public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("开始热更新代码");

        // 传入class 文件路径
        String path = agentArgs;
        try {
            RandomAccessFile f = new RandomAccessFile(path, "r");
            final byte[] bytes = new byte[(int) f.length()];
            f.readFully(bytes);
            final String clazzName = readClassName(bytes);

            System.out.println("热更新类名：" + clazzName);
            // inst.getAllLoadedClasses 方法将会获取所有已加载的 class
            for (Class clazz : inst.getAllLoadedClasses()) {
                if (clazz.getName().equals(clazzName)) {
                    ClassDefinition definition = new ClassDefinition(clazz, bytes);
                    // 使用指定的 class 替换当前系统正在使用 class
                    inst.redefineClasses(definition);
                }
            }
        } catch (UnmodifiableClassException | IOException | ClassNotFoundException e) {
            System.out.println("热更新数据失败");
        }
    }


    private static String readClassName(final byte[] bytes) {
        return new ClassReader(bytes).getClassName().replace("/", ".");
    }

}
