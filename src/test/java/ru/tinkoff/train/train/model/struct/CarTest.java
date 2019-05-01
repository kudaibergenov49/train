package ru.tinkoff.train.train.model.struct;

import org.junit.Test;
import ru.tinkoff.train.train.constant.Constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CarTest {

    @Test
    public void switchOff() {
        Car<Character> car = new Car<>(Constant.switchOn);
        car.switchOff();
        assertEquals(Constant.switchOf, car.getData());
        assertNotEquals(Constant.switchOn, car.getData());
    }

    @Test
    public void switchOn() {
        Car<Character> car = new Car<>(Constant.switchOf);
        car.switchOn();
        assertEquals(Constant.switchOn, car.getData());
        assertNotEquals(Constant.switchOf, car.getData());
    }

    @Test
    public void findLightOnPosition() {
        Car<Character> car = new Car<>(Constant.switchOn);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOn);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        assertEquals(6, car.findLightOnPosition());
    }

    @Test
    public void rightNPosition() {
        Car<Character> car = new Car<>(Constant.switchOn);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOn);
        car.addRightCar(Constant.switchOf);
        car.addRightCar(Constant.switchOf);
        assertEquals(Constant.switchOn, car.rightNPosition(6).getData());
    }

    @Test
    public void leftNPosition() {
        Car<Character> car = new Car<>(Constant.switchOf);
        car.addLeftCar(Constant.switchOf);
        car.addLeftCar(Constant.switchOf);
        car.addLeftCar(Constant.switchOf);
        car.addLeftCar(Constant.switchOf);
        car.addLeftCar(Constant.switchOn);
        car.addLeftCar(Constant.switchOf);
        car.addLeftCar(Constant.switchOf);
        assertEquals(Constant.switchOn, car.leftNPosition(5).getData());
    }

    @Test
    public void addCarriage() {
        Car<Character> car = new Car<>(Constant.switchOf);
        car.addRightCar(Constant.switchOn);
        assertEquals(car.getNext().getData(), Constant.switchOn);
    }
}