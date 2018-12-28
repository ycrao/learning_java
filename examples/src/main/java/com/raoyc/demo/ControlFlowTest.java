package com.raoyc.demo;

import java.util.Random;

public class ControlFlowTest {

    public static void main(String[] args) {
        int x = 10;
        while (x < 20) {
            System.out.println("value of x : " + x);
            x++;

        }
        System.out.println("------");

        x = 10;
        do {
            System.out.println("value of x : " + x);
            x++;
        } while (x < 20);

        System.out.println("------");
        for (x = 10; x < 20; x ++) {
            System.out.println("value of x : " + x );
        }

        int [] numbers = {10, 20, 30, 40, 50};

        for (int y : numbers) {
            if (y == 30) {
                break;
            }
            System.out.println("break y: " + y);
        }

        for (int y : numbers) {
            if (y == 30) {
                continue;
            }
            System.out.println("continue y: " + y);
        }

        Random random = new Random();

        int z = random.nextInt(50);
        if (z < 10) {
            System.out.print("value of z is " + z + " z < 10");
        } else if (z >= 10 && z < 20) {
            System.out.print("value of z is " + z + " between 10 <= z < 20");
        } else if (z >=20  && z < 30) {
            System.out.print("value of z is " + z + " between 20 <= z < 30");
        } else {
            System.out.print("value of z is " + z);
        }

        //char grade = args[0].charAt(0);
        char grade = 'C';

        switch (grade) {
            case 'A' :
                System.out.println("优秀");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                break;
            case 'D' :
                System.out.println("及格");
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);
    }
}
