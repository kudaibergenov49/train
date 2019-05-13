package ru.tinkoff.train.train.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    private Integer count;

    public Train() {

    }

    public Train(String value, Integer count) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return Objects.equals(getValue(), train.getValue()) &&
                Objects.equals(getCount(), train.getCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getCount());
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", count=" + count +
                '}';
    }
}
