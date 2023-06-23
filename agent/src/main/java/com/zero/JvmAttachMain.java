package com.zero;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author: Zero
 * @date: 2023-06-18 23:14
 * @desc:
 */
public class JvmAttachMain {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {

        String pid="43440";
        String classPath="D:\\WorkFile\\CodeMao\\Project\\agentTest\\agent\\target\\classes\\com\\zero\\MasterMain.class";
        String jarPath = "D:\\WorkFile\\CodeMao\\Project\\agentTest\\agent\\target\\hotswap-jdk.jar";

        System.out.println("当前热更新工具 jar 路径为 "+jarPath);
        VirtualMachine vm = VirtualMachine.attach(pid);

        // 运行最终 AgentMain 中方法
        vm.loadAgent(jarPath, classPath);
    }
}
