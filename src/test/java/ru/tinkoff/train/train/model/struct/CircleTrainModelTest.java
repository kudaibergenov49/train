package ru.tinkoff.train.train.model.struct;

import org.junit.Test;
import ru.tinkoff.train.train.constant.Constant;

import static org.junit.Assert.assertEquals;

public class CircleTrainModelTest {

    @Test
    public void calculateLength() {
        CircleTrainModel<Character> train = new CircleTrainModel<>();
        train.add(Constant.switchOn);
        train.add(Constant.switchOf);
        train.add(Constant.switchOn);
        train.add(Constant.switchOf);
        train.add(Constant.switchOn);
        train.add(Constant.switchOf);
        train.add(Constant.switchOn);
        train.add(Constant.switchOn);
        train.add(Constant.switchOn);
        train.add(Constant.switchOf);
        train.add(Constant.switchOf);
        assertEquals(train.calculateLength(), 11);
    }
}