package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс для тестирования функционала методов класса ExpressionSolver
 * @author ablakanovamin0-svg
 * @version 1.0
 */
public class Tests {

    /**
     * Проверка работы конструкторов
     */
    @Test
    void createComparisonTest() {
        Comparison emptyComparison = new Comparison();
        assertEquals(1000, emptyComparison.getCount());
        Comparison comparison = new Comparison(2000);
        assertEquals(2000, comparison.getCount());
    }

    /**
     * Проверка работы метода getCount
     */
    @Test
    void getCountTest() {
        Comparison comparison = new Comparison(10000);
        assertEquals(10000, comparison.getCount());
    }

    /**
     * Проверка работы метода setCount
     */
    @Test
    void setCountTest() {
        Comparison comparison = new Comparison();
        comparison.setCount(10000);
        assertEquals(10000, comparison.getCount());
    }
}
