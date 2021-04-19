package com.test;

import com.calculator.operations.MathOperation;

import java.util.*;
import java.util.stream.Collectors;

public class TestCalculator {


    public static void main(String[] args) {
        calculate("5 + 2 - 3 * 7 + 2 / 3");


    }
    public static void calculate(String equation){
        List<String> linkedList = Arrays.stream(equation.split(" ")).filter(s -> !s.matches("[\\w\\s]")).collect(Collectors.toList());
    }

    public MathOperation getOperation(String operator){
        Map<String, MathOperation> map = new HashMap<>();
        map.put("+", (a,b)-> a+b);
        map.put("*", (a,b)-> a*b);
        map.put("-", (a,b)-> a-b);
        map.put("/", (a,b)-> a/b);
        return map.get(operator);
    }
}
