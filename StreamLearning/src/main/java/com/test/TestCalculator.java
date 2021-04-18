package com.test;

import com.calculator.operations.MathOperation;

public class TestCalculator {


    public static void main(String[] args) {
        System.out.println(calculate(1,5,(a,b)->a*b));
        System.out.println(calculate(5,5,(a,b)->a+b));
        System.out.println(calculate(6,5,(a,b)->a-b));
        System.out.println(calculate(4,2,(a,b)->a/b));
        System.out.println(calculate(4,2,Math::addExact));
        System.out.println(calculate(4,2,Math::subtractExact));
        System.out.println(calculate(4,2,Math::multiplyExact));
        System.out.println(calculate(4,2,Math::floorDiv));

    }
    public static int calculate(int a, int b, MathOperation mathOperation){
        return mathOperation.operate(a,b);
    }
}
