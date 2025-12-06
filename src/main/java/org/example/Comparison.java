package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Comparison {
    private int count;
    public Comparison() {
        count = 1000;
    }
    public Comparison(int operationCount) {
        count = operationCount;
    }
    private double addFirstTime(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double addLastTime(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double addMiddleTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(list.size() / 2, i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double getElemTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.get(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double deleteFirstTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.remove(0);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
}
