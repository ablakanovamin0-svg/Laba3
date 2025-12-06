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
    public void setCount(int operationCount) {
        count = operationCount;
    }
    public int getCount() {
        return count;
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
    private double deleteLastTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = count - 1; i >= 0; i--) {
            list.remove(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double deleteMiddleTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            if (!list.isEmpty()) {
                list.remove(list.size() / 2);
            }
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double iterationTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        int result = 0;
        for (Integer elem : list) {
            result += elem;
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double containsTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.contains(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    private double clearTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        list.clear();
        return (System.nanoTime() - startTime) / 1000000.0;
    }
    public void compare() {
        System.out.println("Сравнение производительности ArrayList и LinkedList");
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "Метод", "Количество операций",
                "ArrayList (мс)", "LinkedList (мс)");
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Удаление из начала", count, deleteFirstTime(arrayList), deleteFirstTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Удаление из середины", count, deleteMiddleTime(arrayList), deleteMiddleTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Удаление из конца", count, deleteLastTime(arrayList), deleteLastTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Добавление в начало", count, addFirstTime(arrayList), addFirstTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Добавление в середину", count, addMiddleTime(arrayList), addMiddleTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Добавление в конец", count, addLastTime(arrayList), addLastTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Получение элемента", count, getElemTime(arrayList), getElemTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Использование итераторов", count, iterationTime(arrayList), iterationTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Поиск элемента", count, containsTime(arrayList), containsTime(linkedList));
        System.out.printf("%-30s  %-19s  %-14s  %-15s \n", "Очистка списка", count, clearTime(arrayList), clearTime(linkedList));
    }
}
