package ru.tinkoff.train.train.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.tinkoff.train.train.constant.Constant;
import ru.tinkoff.train.train.model.JsonValue;
import ru.tinkoff.train.train.model.struct.CircleTrainModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InputService {
    public CircleTrainModel<Character> convertToCircleTrainModel(String value) {
        CircleTrainModel<Character> list = new CircleTrainModel<>();
        List<Character> charList = value.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        charList.forEach(list::add);
        return list;
    }

    public boolean checkValue(String value) {
        List<Character> charList = value.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        return charList.stream().allMatch(val -> val == Constant.switchOf || val == Constant.switchOn);
    }

    public String jsonToString(String json) {
        Gson g = new Gson();
        JsonValue jsonValue = g.fromJson(json, JsonValue.class);
        return jsonValue.getText();
    }
}