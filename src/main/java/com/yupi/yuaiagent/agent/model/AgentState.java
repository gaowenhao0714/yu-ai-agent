package com.yupi.yuaiagent.agent.model;

/**
 * ClassName:AgentState
 * Package:com.yupi.yuaiagent.agent.model
 * Description:
 *
 * @Author gaowenhao
 * @Create 2026/7/13 15:11
 * @Version 1.0
 */
/**
 * 代理执行状态的枚举类
 */
public enum AgentState {

    /**
     * 空闲状态
     */
    IDLE,

    /**
     * 运行中状态
     */
    RUNNING,

    /**
     * 已完成状态
     */
    FINISHED,

    /**
     * 错误状态
     */
    ERROR
}
