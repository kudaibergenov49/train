package ru.tinkoff.train.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.train.train.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
     Train findByValue(String value);
}