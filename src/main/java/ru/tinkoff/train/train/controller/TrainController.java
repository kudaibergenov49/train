package ru.tinkoff.train.train.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.train.train.model.Train;
import ru.tinkoff.train.train.model.struct.CircleLinkedList;
import ru.tinkoff.train.train.service.DBService;
import ru.tinkoff.train.train.service.InputValueService;

import java.util.List;

@RestController
@RequestMapping("train")
public class TrainController {
    private final DBService dbService;
    private final InputValueService inputValueService;

    @Autowired
    public TrainController(DBService dbService, InputValueService inputValueService) {
        this.dbService = dbService;
        this.inputValueService = inputValueService;
    }

    @GetMapping
    public List<Train> all() {
        return dbService.findAll();
    }

    @GetMapping("{id}")
    public Train get(@PathVariable("id") Train train) {
        return train;
    }

    @PostMapping
    public Train create(@RequestBody String value) {
        value = inputValueService.jsonToString(value);
        if(!inputValueService.checkValue(value)){
            return null;
        }
        Train train = dbService.findByValue(value);
        if (train == null) {
            CircleLinkedList<Character> composition = inputValueService.convertToCircleLinkedList(value);
            int length = composition.calculateLength();
            train = dbService.save(new Train(value, length));
            return dbService.save(train);
        }
        return null;
    }

    @PutMapping("{id}")
    public Train update(@PathVariable("id") Train trainfromDB, @RequestBody Train train) {
        BeanUtils.copyProperties(train, trainfromDB, "id");
        trainfromDB.setCount(inputValueService.convertToCircleLinkedList(trainfromDB.getValue()).calculateLength());
        return dbService.save(trainfromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Train train) {
        dbService.delete(train);
    }
}