package com.raoyc.demo;

public class OperatorTest {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("b / a = " + (b / a));
        System.out.println("b % a = " + (b % a));
        System.out.println("c % a = " + (c % a));
        System.out.println("a++   = " +  (a++));
        System.out.println("a--   = " +  (a--));
        // 查看  d++ 与 ++d 的不同
        System.out.println("d++   = " +  (d++));
        System.out.println("++d   = " +  (++d));

        int e = 10;
        int f = 20;
        System.out.println("e == f = " + (e == f));
        System.out.println("e != f = " + (e != f));
        System.out.println("e > f = " + (e > f));
        System.out.println("e < f = " + (e < f));
        System.out.println("e >= f = " + (e >= f));
        System.out.println("e <= f = " + (e <= f));

        a = 60; /* 60 = 0011 1100 */
        b = 13; /* 13 = 0000 1101 */
        c = 0;
        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c);

        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c);

        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c);

        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c);

        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c);

        c = a >> 2;     /* 15 = 1111 */
        System.out.println("a >> 2  = " + c);

        c = a >>> 2;     /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c);

        boolean x = true;
        boolean y = false;
        System.out.println("x && y = " + (x && y));
        System.out.println("x || y = " + (x || y));
        System.out.println("!(x && y) = " + !(x && y));

        a = 10;
        b = 20;
        c = 0;
        c = a + b;
        System.out.println("c = a + b = " + c);
        c += a ;
        System.out.println("c += a  = " + c);
        c -= a ;
        System.out.println("c -= a = " + c);
        c *= a ;
        System.out.println("c *= a = " + c);
        a = 10;
        c = 15;
        c /= a ;
        System.out.println("c /= a = " + c);
        a = 10;
        c = 15;
        c %= a ;
        System.out.println("c %= a  = " + c);
        c <<= 2 ;
        System.out.println("c <<= 2 = " + c);
        c >>= 2 ;
        System.out.println("c >>= 2 = " + c);
        c >>= 2 ;
        System.out.println("c >>= 2 = " + c);
        c &= a ;
        System.out.println("c &= a  = " + c);
        c ^= a ;
        System.out.println("c ^= a   = " + c);
        c |= a ;
        System.out.println("c |= a   = " + c);

        b = (a == 1) ? 20 : 30;
        System.out.println( "Value of b is : " + b);

        String name = "James";
        boolean result = name instanceof String; // 由于 name 是 String 类型，所以返回真
        System.out.println("result is " + result);
    }
}
