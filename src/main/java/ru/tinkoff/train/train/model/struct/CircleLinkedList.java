package ru.tinkoff.train.train.model.struct;

/**
 * Класс для описания кольцевого поезда
 *
 * @param <Char> значения 0 и 1(0 - свет выключен,1 - включен)
 */
public class CircleLinkedList<Char> {
    private Car<Char> head;
    private Car<Char> tail;

    public Car<Char> getHead() {
        return head;
    }

    public CircleLinkedList() {
        head = null;
        tail = null;
    }

    private boolean isEmpty() {
        return (head == null);
    }

    public void add(char data) {
        Car<Char> newCar = new Car<>(data);
        if (isEmpty()) {
            head = newCar;
            tail = newCar;
            head.setPrevious(tail);
            tail.setNext(head);
        } else {
            tail.setNext(newCar);
            newCar.setPrevious(tail);
            tail = newCar;
            tail.setNext(head);
        }
    }

    /**
     * @return Вычисляем длину состава поезда
     */
    public int calculateLength() {
        head.switchOn();
        int lightOnPosition;
        while (true) {
            lightOnPosition = head.findLightOnPosition();
            head.rightNPosition(lightOnPosition).switchOff();
            head.leftNPosition(lightOnPosition);
            if (head.getData() == '0') {
                return lightOnPosition;
            }
        }
    }
}