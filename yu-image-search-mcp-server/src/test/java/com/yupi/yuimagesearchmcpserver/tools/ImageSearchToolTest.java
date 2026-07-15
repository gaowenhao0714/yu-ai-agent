package com.yupi.yuimagesearchmcpserver.tools;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName:ImageSearchToolTest
 * Package:com.yupi.yuimagesearchmcpserver.tools
 * Description:
 *
 * @Author gaowenhao
 * @Create 2026/7/12 16:15
 * @Version 1.0
 */
@SpringBootTest
class ImageSearchToolTest {

    @Resource
    private ImageSearchTool imageSearchTool;

    @Test
    void searchImage() {
        String result = imageSearchTool.searchImage("computer");
        Assertions.assertNotNull(result);
    }
}
