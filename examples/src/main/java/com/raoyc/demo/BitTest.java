package com.raoyc.demo;

public class BitTest {

    public static void main(String[] args) {
        System.out.println("AND op:");
        System.out.printf("0 AND 0 %5d%n", 0 & 0);
        System.out.printf("0 AND 1 %5d%n", 0 & 1);
        System.out.printf("1 AND 0 %5d%n", 1 & 0);
        System.out.printf("1 AND 1 %5d%n", 1 & 1);

        System.out.println("OR op:");
        System.out.printf("0 OR 0 %5d%n", 0 | 0);
        System.out.printf("0 OR 1 %5d%n", 0 | 1);
        System.out.printf("1 OR 0 %5d%n", 1 | 0);
        System.out.printf("1 OR 1 %5d%n", 1 | 1);

        System.out.println("XOR op:");
        System.out.printf("0 XOR 0 %5d%n", 0 ^ 0);
        System.out.printf("0 XOR 1 %5d%n", 0 ^ 1);
        System.out.printf("1 XOR 0 %5d%n", 1 ^ 0);
        System.out.printf("1 XOR 1 %5d%n", 1 ^ 1);

        // 0000 0001
        int number = 1;

        System.out.printf("2 to the power of 0 %5d%n", number);

        // 0000 0001 -> 0000 0100 -> 十进制 4
        System.out.printf("2 to the power of 2 %5d%n", number << 2);
        // 0000 0001 -> 0000 1000 -> 十进制 8
        System.out.printf("2 to the power of 3 %5d%n", number << 3);
        // 0000 0001 -> 0010 0000 -> 十进制 64
        System.out.printf("2 to the power of 6 %5d%n", number << 6);

    }
}
