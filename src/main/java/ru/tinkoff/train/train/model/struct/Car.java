package ru.tinkoff.train.train.model.struct;

import ru.tinkoff.train.train.constant.Constant;

/**
 * Состав поезда
 * @param <Char> значения 0 и 1(0 - свет выключен,1 - включен)
 */
class Car<Char> {
    private Car<Char> next;
    private Car<Char> previous;
    private char data;

    Car(char data) {
        this.data = data;
        next = null;
        previous = null;
    }

    void addRightCar(char data) {
        if (this.next == null) {
            this.next = new Car<>(data);
        } else {
            this.next.addRightCar(data);
        }
    }

    void addLeftCar(char data) {
        if (this.previous == null) {
            this.previous = new Car<>(data);
        } else {
            this.previous.addLeftCar(data);
        }
    }

    Car<Char> getNext() {
        return next;
    }

    public Character getData() {
        return data;
    }

    void setNext(Car<Char> next) {
        this.next = next;
    }

    void setPrevious(Car<Char> previous) {
        this.previous = previous;
    }

    void switchOff() {
        this.data = Constant.switchOf;
    }

    void switchOn() {
        this.data = Constant.switchOn;
    }

    /**
     *
     * @return сколько вагонов направо надо пройти от стартовой точки, чтобы найти включенноую лампочку
     */
    int findLightOnPosition() {
        int position = 1;
        Car<Char> current = this;
        while (current.next.data == Constant.switchOf) {
            position++;
            current = current.next;
        }
        return position;
    }

    /**
     *
     * @param n
     * @return Вагон в n шагах напрво
     */
    Car<Char> rightNPosition(int n) {
        Car<Char> current = this;
        for (char i = 0; i < n; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     *
     * @param n
     * @return Вагон в n шагах налево
     */
    Car<Char> leftNPosition(int n) {
        Car<Char> current = this;
        for (char i = 0; i < n; i++) {
            current = current.previous;
        }
        return current;
    }
}