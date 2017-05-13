package com.hhh.fangusa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    public final Logger logger = LogManager.getLogger(getClass());

    @Resource(name = "dataSource")
    public void setDataSource(javax.sql.DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
