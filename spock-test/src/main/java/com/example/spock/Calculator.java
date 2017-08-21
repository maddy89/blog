package com.example.spock;

/**
 * Calculator.
 *
 * @author Madhawa Bandara.
 */
public class Calculator {

    /**
     * Adds
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts
     *
     * @param a
     * @param b
     * @return
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Unsigned difference
     *
     * @param a
     * @param b
     * @return
     */
    public int difference (int a, int b) {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }

}
