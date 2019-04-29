package ru.tinkoff.train.train.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "train")
@ToString(of = {"id","value","count"})
@EqualsAndHashCode(of = {"id"})
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    private Integer count;

    public Train() {

    }

    public Train(String value,Integer count) {
        this.value = value;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
