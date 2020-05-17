package com.gh;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Data  // 默认生成get set toString等方法
public class LoggerTest {
//    private final Logger log = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        String name = "imooc";
        String password = "123456";

        log.debug("debug...");
        log.info("我是info");
        log.error("error...");
        log.info("name: " + name + " ,password: " + password);
        log.info("name: {}, password: {}", name, password);
        log.error("error...");
        log.warn("warn...");
    }
}
