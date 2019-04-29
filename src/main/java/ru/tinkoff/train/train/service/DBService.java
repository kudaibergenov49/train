package ru.tinkoff.train.train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.train.train.model.Train;
import ru.tinkoff.train.train.repository.TrainRepository;

import java.util.List;

@Service
public class DBService {
    private final TrainRepository trainRepository;

    @Autowired
    public DBService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train findByValue(String value) {
        return trainRepository.findByValue(value);
    }

    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    public Train save(Train train) {
        return trainRepository.save(train);
    }

    public void delete(Train train){
        trainRepository.delete(train);
    }
}
