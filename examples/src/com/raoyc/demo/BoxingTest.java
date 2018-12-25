package com.raoyc.demo;

import java.lang.reflect.Field;

/**
 * 装箱与拆箱
 */
public class BoxingTest {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        int x = 321, y = 321;
        System.out.println(c == d);  // true 自动装箱,缓存
        System.out.println(e == f);  // false 自动装箱,未缓存
        System.out.println(x == y);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));  // true 调用 equals(),比较的是值,而不是对象地址
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(new Integer(2) == new Integer(2));  // false 比较的是对象地址


        // 参考博客 http://www.voidcn.com/blog/zgwangbo/article/p-6101689.html
        System.out.println("before swap a = " + a + ", b = " + b);
        swap(a, b);
        System.out.println("after swap a = " + a + ", b = " + b);

        c = 1;
        System.out.println("(警告:Integer缓存被改了,代码里:Integer c = 1;) 实际c=" + c);

    }

    public static void swap(Integer i1, Integer i2) {
        try {
            Field f = Integer.class.getDeclaredField("value");
            f.setAccessible(true);

            int tmp = i1;
            f.setInt(i1, i2);
            f.setInt(i2, tmp);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
