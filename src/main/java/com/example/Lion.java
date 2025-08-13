package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private SuperFeline superFeline;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public Lion(SuperFeline superFeline) {
        this.superFeline = superFeline;
    }

    public int getKittens() {
        return superFeline.getKittens();
    }

    public List<String> getFood() throws Exception {
        return superFeline.getFood();
    }
}
