package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParamTest {

    @ParameterizedTest
    @CsvSource(value = {
            "3, 3",
            "0, 0",
            "null, 1"
    }, nullValues = "null")
    void getKittensParameterized(Integer kittensCount, int expectedResult) {
        Feline feline = new Feline();
        int actual;
        if (kittensCount == null) {
            actual = feline.getKittens();
        } else {
            actual = feline.getKittens(kittensCount);
        }
        assertEquals(expectedResult, actual);
    }
}
