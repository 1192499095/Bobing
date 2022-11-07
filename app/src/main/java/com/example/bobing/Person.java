package com.example.bobing;

import java.io.Serializable;

public class Person implements Serializable, Comparable<Person> {
    private String name;
    private int score;
    private String result;

    public Person(String name) {
        this.name = name;
        score = 0;
        result = "再接再厉";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public int compareTo(Person o) {
        return o.score - this.score;
    }
}
