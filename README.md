# Learning Java

>   学习 `Java` 示例及笔记，部分资料来源于网络，整理过来仅供参考使用。推荐新手参考 [Java 教程](http://www.runoob.com/java/java-tutorial.html)
来学习。

## 简介

`Java` 是由 `Sun Microsystems` 公司于1995年5月推出的 `Java` 面向对象程序设计语言和 `Java` 平台的总称。由 `James Gosling` 和同事们共同研发，并在1995年正式推出。

Java分为三个体系：

- JavaSE（J2SE）： `Java2 Platform Standard Edition` JAVA平台标准版
- JavaEE（J2EE）： `Java 2 Platform,Enterprise Edition` JAVA平台企业版
- JavaME（J2ME）： `Java 2 Platform Micro Edition` JAVA平台微型版

2005年6月，`JavaOne` 大会召开，`SUN` 公司公开 `Java SE 6` 。此时，`Java` 的各种版本已经更名以取消其中的数字"2"：`J2EE` 更名为 `Java EE`，`J2SE` 更名为 `Java SE`，`J2ME` 更名为`Java ME`。

2009年04月20日，甲骨文（`Oracle`） 74亿美元收购 `Sun` ，取得 `Java` 的版权。

2014年3月18日，`Oracle` 发布 `Java SE 8` 。


## 基础知识

### 开发环境配置

受限于篇幅，这里不对开发环境配置做更多的说明，请参考以下链接：

- [Java 开发环境配置](http://www.runoob.com/java/java-environment-setup.html)
- [Mac环境下配置Java开发环境（jdk maven tomcat idea）](https://zhuanlan.zhihu.com/p/35272197)
- [Ubuntu下maven安装和tomcat简易安装](https://segmentfault.com/a/1190000004453530)
- [Ubuntu下安装jdk和maven并配置相关环境变量](https://www.jianshu.com/p/de3cec62bf1f)

### `Hello World` 示例

编写 `HelloWorld.java` 代码，示例代码位于 `examples/src/com/raoyc/demo/HelloWorld.java` 。

```java
package com.raoyc.demo;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

运行，如果你使用 诸如 `Virtual Studio Code` (搭配 `JAVA` 相关扩展插件) 、 `IDEA` 与 `Eclipse` 等集成环境（可能需要进行某些配置），可以很方便在源代码文件（右键）点击运行，得到结果。

你也可以手动编译运行源码文件，操作如下：

```
mkdir classes
javac examples/src/com/raoyc/demo/HelloWorld.java -d ./classes
java -classpath ./classes com.raoyc.demo.HelloWorld
Hello Wolrd!
```

编写Java程序时，应注意以下几点：

- 大小写敏感：`Java` 是大小写敏感的，这就意味着标识符 `Hello` 与 `hello` 是不同的。
- 类名：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 `MyFirstJavaClass` 。
- 方法名：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
- 源文件名：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存（切记 `Java` 是大小写敏感的），文件名的后缀为 `.java` 。（如果文件名和类名不相同则会导致编译错误）。
- 主方法入口：所有的 `Java` 程序由 `public static void main(String []args)` 方法开始执行。

>   更多参考： [Java 基础语法](http://www.runoob.com/java/java-basic-syntax.html) 。

### ８种基本数据类型

```
整型：
byte（字节型）
short（短整型）
int（整型）
long（长整型）
浮点型：
float（单精度浮点型）
double（双精度浮点型）
布尔型：
boolean（布尔型）(它只有两个值可取 true false)
字符型：
char（字符型）
```

>   类型转换等请参考：[Java 基本数据类型](http://www.runoob.com/java/java-basic-datatypes.html)

### 对象与类

>   对象：对象是类的一个实例（对象不是找个女朋友），有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。

>   类：类是一个模板，它描述一类对象的行为和状态。

示例代码 [DogTest](examples/src/com/raoyc/demo/DogTest.java)

当在一个源文件中定义多个类，并且还有 `import` 语句和 `package` 语句时，要特别注意这些规则。

- 一个源文件中只能有一个 `public` 类
- 一个源文件可以有多个非 `public` 类
- 源文件的名称应该和 `public` 类的类名保持一致。例如：源文件中 `public` 类的类名是 `Employee` ，那么源文件应该命名为 `Employee.java` 。
- 如果一个类定义在某个包中，那么 `package` 语句应该在源文件的首行。
- 如果源文件包含 `import` 语句，那么应该放在 `package` 语句和类定义之间。如果没有 `package` 语句，那么 `import` 语句应该在源文件中最前面。
- `import` 语句和 `package` 语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。
- 类有若干种访问级别，并且类也分不同的类型：抽象类和 `final` 类等。

除了上面提到的几种类型，`Java` 还有一些特殊的类，如：内部类、匿名类。


## 参考资源

- [Java教程](http://www.runoob.com/java/java-tutorial.html)
- [Java Development Kit 8 Documentation](https://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html)
- [JDK中文版](http://tool.oschina.net/apidocs/apidoc?api=jdk-zh)
- [CyC2018/CS-Notes](https://github.com/CyC2018/CS-Notes)
- [brianway/java-learning](https://github.com/brianway/java-learning)
- [winterbe/java8-tutorial](https://github.com/winterbe/java8-tutorial) 中文版 [aalansehaiyang/java8-tutorial](https://github.com/aalansehaiyang/java8-tutorial)
- [JeffLi1993/java-core-learning-example](https://github.com/JeffLi1993/java-core-learning-example)
- [HowToDoInJava](https://howtodoinjava.com/java/)