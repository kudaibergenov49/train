package ru.tinkoff.train.train.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputValueServiceTest {
    @TestConfiguration
    static class PathVariableServiceTestContextConfiguration {
        @Bean
        public InputValueService employeeService() {
            return new InputValueService();
        }
    }

    @Autowired
    InputValueService inputValueService;

    @Test
    public void convertToCircleLinkedList() {
    }

    @Test
    public void checkValue() {
        Assert.assertTrue(inputValueService.checkValue("010101"));
        Assert.assertTrue(inputValueService.checkValue("0"));
        Assert.assertTrue(inputValueService.checkValue("11111"));
        Assert.assertFalse(inputValueService.checkValue("0101012"));
        Assert.assertFalse(inputValueService.checkValue("5"));
        Assert.assertFalse(inputValueService.checkValue("f"));
    }
}