package ru.tinkoff.train.train.model.struct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleLinkedListTest {

    @Test
    public void calculateLength() {
        CircleLinkedList<Character> train = new CircleLinkedList<>();
        train.add('1');
        train.add('0');
        train.add('1');
        train.add('0');
        train.add('1');
        train.add('0');
        train.add('1');
        train.add('1');
        train.add('1');
        train.add('0');
        train.add('0');
        assertEquals(train.calculateLength(),11);
    }
}