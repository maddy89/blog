package com.example.spock

import spock.lang.Specification

/**
 * Calculator test.
 *
 * @author Madhawa Bandara.
 */
class CalculatorTest extends Specification {

    def calculator = new Calculator()

    def setup () {
        println("Running Setup")
    }

    def setupSpec () {
        println("Running Setup")
    }

    def "adding two ints together should return total" () {

        given:
        def a = 10
        def b = 20

        when:
        def result = calculator.add(a,b)

        then:
        result == 30
    }

    def "subtracting two ints should return difference" () {

        given:
        def a = 20
        def b = 10

        when:
        def result = calculator.subtract(a,b)

        then:
        result == 10
    }

    def "difference of two ints should return unsigned difference when a > b" () {

        given:
        def a = 20
        def b = 10

        when:
        def result = calculator.difference(a, b)

        then:
        result == 10
    }

    def "difference of two ints should return unsigned difference when b > a" () {

        given:
        def a = 10
        def b = 20

        when:
        def result = calculator.difference(a, b)

        then:
        result == 10
    }

    def "difference common test method for both above cases" () {

        when:
        def result = calculator.difference(a, b)

        then:
        result == sum

        where:
        a  |b  |sum
        10 |20 |10
        20 |10 |10
    }

    def cleanup () {

    }

    def clieanupSpec () {

    }

}
