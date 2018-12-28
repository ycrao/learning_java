package com.raoyc.demo;

// see https://github.com/brianway/java-learning/blob/master/java-base/src/main/java/com/brianway/learning/java/base/constructor/SonClass.java
public class SonClass extends FatherClass {
    private static int countSon;

    static {
        System.out.println("子类可以访问父类的静态属性count " + count);
        System.out.println("子类的静态属性countSon初始化:" + countSon);
    }

    public SonClass(String name) {
        //super(name);
        System.out.println("执行了子类的构造方法SonClass(String name) " + name);
    }

    public SonClass() {
        System.out.println("执行了子类的无参构造方法");
    }

    public static void main(String[] args) {
        new SonClass("aaa");
        new SonClass();
    }
}
