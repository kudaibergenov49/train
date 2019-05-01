package ru.tinkoff.train.train.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.train.train.constant.Constant;
import ru.tinkoff.train.train.model.Train;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainRepositoryTest {
    @Autowired
    private TrainRepository trainRepository;

    @Test
    public void findByValue() {
        Train train = trainRepository.findByValue(Constant.firstTrainValue);
        Assert.assertEquals(train.getValue(), Constant.firstTrainValue);
    }
}