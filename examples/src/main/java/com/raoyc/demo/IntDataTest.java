package com.raoyc.demo;

public class IntDataTest {

    public static void main(String[] args) {
        Integer x = 2;     // 装箱
        int y = x;         // 拆箱
        System.out.println(x == y);

        Integer a = new Integer(123);
        Integer b = new Integer(123);
        System.out.println(a == b);    // false
        Integer c = Integer.valueOf(123);
        Integer d = Integer.valueOf(123);
        System.out.println(c == d);   // true

        // https://stackoverflow.com/questions/9030817/differences-between-new-integer123-integer-valueof123-and-just-123
    }
}
