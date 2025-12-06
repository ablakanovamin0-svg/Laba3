package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс алгоритма по
 * сравнению производительности
 * ArrayList и LinkedList
 *
 */
public class Comparison {
    private int count;

    /**
     * Конструктор объектов класса Comparison по умолчанию
     */
    public Comparison() {
        count = 1000;
    }

    /**
     * Конструктор объектов класса Comparison с заданным числом операций
     * @param operationCount число операций
     */
    public Comparison(int operationCount) {
        count = operationCount;
    }

    /**
     * Установление заданного числа операций
     * @param operationCount число операций
     */
    public void setCount(int operationCount) {
        count = operationCount;
    }

    /**
     * Получение числа операций
     * @return число операций
     */
    public int getCount() {
        return count;
    }

    /**
     * Время добавления элемента в начало
     * @param list заданный список
     * @return вычисленное время
     */
    private double addFirstTime(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Время добавления элемента в конец
     * @param list заданный список
     * @return вычисленное время
     */
    private double addLastTime(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Время добавления элемента в середину
     * @param list заданный список
     * @return вычисленное время
     */
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

    /**
     * Время получения элемента
     * @param list заданный список
     * @return вычисленное время
     */
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

    /**
     * Время удаления элемента из начала
     * @param list заданный список
     * @return вычисленное время
     */
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

    /**
     * Время удаления элемента из конца
     * @param list заданный список
     * @return вычисленное время
     */
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

    /**
     * Время удаления элемента из середины
     * @param list заданный список
     * @return вычисленное время
     */
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

    /**
     * Время прохождения по списку с
     * использованием итератора
     * @param list заданный список
     * @return вычисленное время
     */
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

    /**
     * Время поиска элемента
     * @param list заданный список
     * @return вычисленное время
     */
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

    /**
     * Время очистки списка
     * @param list заданный список
     * @return вычисленное время
     */
    private double clearTime(List<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        list.clear();
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вывод результатов сравнения в консоль
     */
    public void compare() {
        System.out.println("Сравнение производительности ArrayList и LinkedList");
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Метод", "Количество операций",
                "ArrayList (мс)", "LinkedList (мс)");
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Удаление из начала", count, deleteFirstTime(arrayList), deleteFirstTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Удаление из середины", count, deleteMiddleTime(arrayList), deleteMiddleTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Удаление из конца", count, deleteLastTime(arrayList), deleteLastTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Добавление в начало", count, addFirstTime(arrayList), addFirstTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Добавление в середину", count, addMiddleTime(arrayList), addMiddleTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Добавление в конец", count, addLastTime(arrayList), addLastTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Получение элемента", count, getElemTime(arrayList), getElemTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Использование итераторов", count, iterationTime(arrayList), iterationTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Поиск элемента", count, containsTime(arrayList), containsTime(linkedList));
        System.out.printf("%-25s  %-19s  %-14s  %-15s \n", "Очистка списка", count, clearTime(arrayList), clearTime(linkedList));
    }
}
