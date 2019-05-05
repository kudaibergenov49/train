package ru.tinkoff.train.train.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.train.train.model.Train;
import ru.tinkoff.train.train.model.struct.CircleTrainModel;
import ru.tinkoff.train.train.service.DBService;
import ru.tinkoff.train.train.service.InputService;

import java.util.List;

@RestController
@RequestMapping("train")
public class TrainController {
    private final DBService dbService;
    private final InputService inputService;

    @Autowired
    public TrainController(DBService dbService, InputService inputService) {
        this.dbService = dbService;
        this.inputService = inputService;
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
        value = inputService.jsonToString(value);
        if (!inputService.checkValue(value)) {
            return null;
        }
        Train train = dbService.findByValue(value);
        if (train == null) {
            CircleTrainModel<Character> composition = inputService.convertToCircleTrainModel(value);
            int length = composition.calculateLength();
            return dbService.save(new Train(value, length));
        }
        return null;
    }

    @PutMapping("{id}")
    public Train update(@PathVariable("id") Train trainfromDB, @RequestBody Train train) {
        BeanUtils.copyProperties(train, trainfromDB, "id");
        trainfromDB.setCount(inputService.convertToCircleTrainModel(trainfromDB.getValue()).calculateLength());
        return dbService.save(trainfromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Train train) {
        dbService.delete(train);
    }
}