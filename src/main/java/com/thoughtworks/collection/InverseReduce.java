package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> list = new ArrayList<>();
        int n = random.nextInt(3);
        while (number > n) {
            list.add(number - n);
            number -= 2;
        }
        return list;
    }
}
