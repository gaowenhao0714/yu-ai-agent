package com.yupi.yuaiagent;

import com.yupi.yuaiagent.app.LoveApp;
import com.yupi.yuaiagent.rag.LoveAppDocumentLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.LinkOption;

@SpringBootTest
class YuAiAgentApplicationTests {

    @Autowired
    private LoveAppDocumentLoader loveAppDocumentLoader;

    @Test
    void contextLoads() {
        loveAppDocumentLoader.loadMarkdowns();
    }

}
