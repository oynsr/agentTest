package com.zero;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author: Zero
 * @date: 2023-06-20 18:36
 * @desc:
 */
public class TransformerTest implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain
            , byte[] classfileBuffer) throws IllegalClassFormatException {
        String clazzName = className.replace("/", ".");
        if (clazzName.equals("com.zero.MasterMain")) {
            System.out.println("transform 获取到:" + className);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return classfileBuffer;
    }
}
