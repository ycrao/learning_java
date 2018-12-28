package com.raoyc.demo;

public class StrDataTest {

    public static void main(String[] args) {

        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);  // false

        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4);  // true

        String s5 = "bbb";
        String s6 = "bbb";
        System.out.println(s5 == s6);  // true

        // https://stackoverflow.com/questions/26231263/create-string-with-emoji-unicode-flag-countries
        char cHexDao = 0x9053;  // 道
        char cDao = '\u9053';
        char cSmile = '☺';
        char cIntSmile = 9786;
        char cUniSmile = '\u263a';
        char cHexSmile = 0x263a;
        // see https://apps.timwhitlock.info/emoji/tables/unicode
        char iSign = 0x2705;
        int signPoint = "✅".codePointAt(0);

        System.out.println(iSign + " : " + signPoint);
        System.out.println(cHexDao);
        System.out.println(cDao);
        System.out.println(cSmile);
        System.out.println(cIntSmile);
        System.out.println(cUniSmile);
        System.out.println(cHexSmile);

        System.out.println("\ud83d\udeb4");  // emoji 🚴

        String str = "123";
        change(str);
        System.out.println(str);
    }

    public static void change(String str) {
        str = "456";
    }
}
