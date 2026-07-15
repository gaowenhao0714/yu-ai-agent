package com.yupi.yuaiagent.controller.demo.invoke;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
//public class SpringAiAiInvoke implements CommandLineRunner {
//
//    @Autowired
//    private ChatModel dashscopeChatModel;
//
//    @Override
//    public void run(String... args) throws Exception {
//        AssistantMessage output = dashscopeChatModel.call(new Prompt("你好，我是高文浩"))
//                .getResult()
//                .getOutput();
//        System.out.println(output.getText());
//    }
//}
