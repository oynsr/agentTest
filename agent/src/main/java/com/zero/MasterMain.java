package com.zero;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: Zero
 * @date: 2023-06-18 23:13
 * @desc:
 */
public class MasterMain {
    public static void main(String[] args) throws InterruptedException {
        // 输出当前PID
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        long pid = Long.parseLong(processName.split("@")[0]);
        System.out.println("当前进程的PID是：" + pid);
        while (true){
            TimeUnit.SECONDS.sleep(3);
            hello();
        }
    }

    public static void hello() {
        System.out.println("方法输出内容已被更新");
    }
}
