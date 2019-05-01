package ru.tinkoff.train.train.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.train.train.constant.Constant;
import ru.tinkoff.train.train.model.Train;
import ru.tinkoff.train.train.repository.TrainRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainControllerTest {
    @Autowired
    private TrainController trainController;
    @Autowired
    private TrainRepository trainRepository;

    @Test
    public void all() {
        List<Train> list = trainController.all();
        assertEquals(Constant.firstTrainValue, list.get(0).getValue());
        assertEquals(Constant.secondTrainValue, list.get(1).getValue());
        assertEquals(3, (int) list.get(0).getCount());
        assertEquals(3, (int) list.get(1).getCount());
    }
}