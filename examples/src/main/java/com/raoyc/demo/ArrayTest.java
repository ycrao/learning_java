package com.raoyc.demo;

public class ArrayTest {

    public static void main(String[] args) {
        // 数组大小
        int size = 7;
        // 定义数组
        String[] days = new String[size];
        days[0] = "Sunday";
        days[1] = "Monday";
        days[2] = "Tuesday";
        days[3] = "Wednesday";
        days[4] = "Thursday";
        days[5] = "Friday";
        days[6] = "Saturday";

        System.out.println("7 days in one week:");
        for (String day : days) {
            System.out.println(day);
        }

        System.out.println("----------");


        Double[] numbers = {10.01, 20.20, 30.03, 40.40, 50.05};

        System.out.println("numbers are:");
        for (Double number : numbers) {
            System.out.println(number);
        }
    }
}
