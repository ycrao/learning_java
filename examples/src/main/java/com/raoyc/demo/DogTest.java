package com.raoyc.demo;


class Dog {
    int age = 1;
    String color;
    String name;
    void barking() {
        System.out.println("The dog is barking");
    }
    void hungry() {
        System.out.println("The dog is hungry");
    }
    void sleeping() {
        System.out.println("The dog is sleeping");
    }
}

class Puppy extends Dog {

    public Puppy() {

    }

    public Puppy(String name, String color) {
        // 这个构造函数有2个参数
        this.name = name;
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}

public class DogTest {

    public static void main(String[] args) {
        /* 创建对象 */
        Puppy myPuppy = new Puppy("tommy", "black");
        /* 通过方法来设定age */
        myPuppy.setAge(2);
        /*你也可以像下面这样访问成员变量 */
        System.out.println("My puppy name : " + myPuppy.name);
        System.out.println("My puppy color: " + myPuppy.color);
        System.out.println("My puppy age : " + myPuppy.getAge());
        myPuppy.barking();
    }
}
