package ru.tinkoff.train.train.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.tinkoff.train.train.model.JsonConverter;
import ru.tinkoff.train.train.model.struct.CircleLinkedList;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InputValueService {
    public CircleLinkedList<Character> convertToCircleLinkedList(String value) {
        CircleLinkedList<Character> list = new CircleLinkedList<>();
        List<Character> charList = value.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        charList.forEach(list::add);
        return list;
    }

    public boolean checkValue(String value) {
        List<Character> charList = value.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        return charList.stream().allMatch(val -> val == '0' || val == '1');
    }

    public String jsonToString(String json){
        Gson g = new Gson();
        JsonConverter jsonConverter = g.fromJson(json, JsonConverter.class);
        return jsonConverter.getText();
    }
}