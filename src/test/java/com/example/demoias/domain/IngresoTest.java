package com.example.demoias.domain;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class IngresoTest {

    @TestFactory
    Stream<DynamicTest> validValues() {
        return Stream.of(0, 1, 100)
                .map(integer -> {
                    String name = "Deberia pasar para: " + integer;
                    Executable executable = () -> Ingreso.of(BigDecimal.valueOf(integer));
                    return dynamicTest(name, () -> {
                       assertAll(
                               () -> assertDoesNotThrow(executable),
                               () -> assertNotNull(Ingreso.of(BigDecimal.valueOf(integer)))
                       );
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> invalidValues() {
        return Stream.of(-1, -100, null)
                .map(integer -> {
                    String name = "Deberia fallar para: " + integer;
                    return dynamicTest(name, () -> {
                        Executable executable = () -> Ingreso.of(BigDecimal.valueOf(integer));
                        if(integer == null) {
                            assertThrows(NullPointerException.class, executable);
                        } else {
                            assertThrows(IllegalArgumentException.class, executable);
                        }
                    });
                });
    }
}