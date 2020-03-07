package com.epamejc.lessons.src.homework.homework8.java8.functional_interfaces;

@FunctionalInterface
public interface CoolBiFunction<T, U, R> {
    R apply(T t, U u);
}
