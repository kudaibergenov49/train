package ru.tinkoff.train.train.model.struct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CarTest {

    @Test
    public void switchOff() {
        Car<Character> car = new Car<>('1');
        car.switchOff();
        assertEquals('0', car.getData());
        assertNotEquals('1', car.getData());
    }

    @Test
    public void switchOn() {
        Car<Character> car = new Car<>('0');
        car.switchOn();
        assertEquals('1', car.getData());
        assertNotEquals('0', car.getData());
    }

    @Test
    public void findLightOnPosition() {
        Car<Character> car = new Car<>('1');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('1');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        assertEquals(6, car.findLightOnPosition());
    }

    @Test
    public void rightNPosition() {
        Car<Character> car = new Car<>('1');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('1');
        car.addCarriageAtRight('0');
        car.addCarriageAtRight('0');
        assertEquals('1', car.rightNPosition(6).getData());
    }

    @Test
    public void leftNPosition() {
        Car<Character> car = new Car<>('0');
        car.addCarriageAtLeft('0');
        car.addCarriageAtLeft('0');
        car.addCarriageAtLeft('0');
        car.addCarriageAtLeft('0');
        car.addCarriageAtLeft('1');
        car.addCarriageAtLeft('0');
        car.addCarriageAtLeft('0');
        assertEquals('1', car.leftNPosition(5).getData());
    }

    @Test
    public void addCarriage() {
        Car<Character> car = new Car<>('0');
        car.addCarriageAtRight('1');
        assertEquals(car.getNext().getData(),'1');
    }
}