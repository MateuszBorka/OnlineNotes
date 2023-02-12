package com.example.onlinenotesmilitaryedition.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class}, loader = AnnotationConfigContextLoader.class)
public class ApplicationConfigTest {

    @Autowired
    private DataSource dataSource;


    @Test
    public void testDataSource() {
        assertNotNull(dataSource);
    }

    @Test
    public void contextLoads() {
        // No code is necessary in this test as it will automatically check if the application context can load successfully.
        // If there are any configuration errors, the test will fail with a descriptive error message.
    }

}
