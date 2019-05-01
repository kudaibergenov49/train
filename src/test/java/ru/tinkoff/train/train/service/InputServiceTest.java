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
public class InputServiceTest {
    @Autowired
    InputService inputService;

    @Test
    public void checkValue() {
        Assert.assertTrue(inputService.checkValue("010101"));
        Assert.assertTrue(inputService.checkValue("0"));
        Assert.assertTrue(inputService.checkValue("11111"));
        Assert.assertFalse(inputService.checkValue("0101012"));
        Assert.assertFalse(inputService.checkValue("5"));
        Assert.assertFalse(inputService.checkValue("f"));
    }

    @Test
    public void convertToCircleLinkedList() {
    }

    @TestConfiguration
    static class PathVariableServiceTestContextConfiguration {
        @Bean
        public InputService employeeService() {
            return new InputService();
        }
    }
}