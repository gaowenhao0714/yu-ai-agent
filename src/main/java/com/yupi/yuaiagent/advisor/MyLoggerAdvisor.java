package com.yupi.yuaiagent.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisor;


import org.springframework.ai.chat.client.ChatClientMessageAggregator;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisorChain;
import reactor.core.publisher.Flux;
import java.util.Objects;


/**
 * 自定义日志 Advisor
 * 打印 info 级别日志、只输出单次用户提示词和 AI 回复的文本
 */
@Slf4j
public class MyLoggerAdvisor implements CallAdvisor, StreamAdvisor {


    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {

        logRequest(chatClientRequest);
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
        logResponse(chatClientResponse);

        return chatClientResponse;
    }

    @Override
    public Flux adviseStream(ChatClientRequest chatClientRequest,
                             StreamAdvisorChain streamAdvisorChain) {
        logRequest(chatClientRequest);
        Flux chatClientResponses = streamAdvisorChain.nextStream(chatClientRequest);
        return new ChatClientMessageAggregator().aggregateChatClientResponse(chatClientResponses, this::logResponse);
    }

    protected void logRequest(ChatClientRequest request) {
        log.info("用户问答：{}", request.prompt().getUserMessage().getText());
        // 打印系统提示词
        if (request.prompt().getSystemMessage() != null) {
            log.info("系统提示词：{}", request.prompt().getSystemMessage().getText());
        }
    }

    private void logResponse(ChatClientResponse chatClientResponse) {
        // 打印工具调用信息
        var toolCalls = chatClientResponse.chatResponse().getResults().stream()
                .flatMap(result -> result.getOutput().getToolCalls().stream())
                .toList();
        if (!toolCalls.isEmpty()) {
            log.info("AI 调用了 {} 个工具：", toolCalls.size());
            toolCalls.forEach(tc -> log.info("  工具名={}, 参数={}", tc.name(), tc.arguments()));
        } else {
            log.warn("AI 没有调用任何工具！(模型直接文字回复)");
        }
        // 打印 AI 返回的完整回答
        log.info("AI 完整响应：{}", Objects.requireNonNull(chatClientResponse.chatResponse().getResult().getOutput().getText()));
    }

    @Override
    public String getName() {
        return "MyloggerAdvisor";
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
