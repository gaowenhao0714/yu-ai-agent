package com.yupi.yuaiagent.tools;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * ClassName:WebSearchToolTest
 * Package:com.yupi.yuaiagent.tools
 * Description:
 *
 * @Author gaowenhao
 * @Create 2026/7/11 09:36
 * @Version 1.0
 */
@SpringBootTest
class WebSearchToolTest {


    @Value("${search-api.api-key}")
    private String searchApiKey;


    @Test
    void searchWeb() {
        WebSearchTool webSearchTool = new WebSearchTool(searchApiKey);
        String query="程序员鱼皮编程导航codefather.cn";
        String result= webSearchTool.searchWeb(query);
        assertNotNull(result);
    }
}