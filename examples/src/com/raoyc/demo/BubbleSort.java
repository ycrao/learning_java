package com.raoyc.demo;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr2[] = {3, 56, 78, 15, 31, 21, 1, 6, 99, 8, 111, 4};
        int arr[] = {20, 60, 51, 81, 285, 12, 165, 51, 81, 318, 186, 9, 70};
        Arrays.sort(arr2);
        // Arrays.sort 使用 Dal-Pivot QuickSort 算法，参考 https://www.jianshu.com/p/2c6f79e8ce6e
        System.out.println("使用 Arrays.sort 对 arr2 排序结果：" + Arrays.toString(arr2));
        System.out.println("----------");
        System.out.println("使用 冒泡法 对 arr 排序结果：");
        for (int i = 0; i < arr.length - 1; i ++) {
            for (int j = 0; j < arr.length - 1 - i; j ++) {
                // 值交换，小的放在前面
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第" + i + "次排序结果" + Arrays.toString(arr));
        }


    }
}
