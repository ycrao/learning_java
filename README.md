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

>   笔记：https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/Java%20%E5%9F%BA%E7%A1%80.md#java-%E4%B8%8E-c-%E7%9A%84%E5%8C%BA%E5%88%AB 。

### 开发环境配置

受限于篇幅，这里不对开发环境配置做更多的说明，请参考以下链接：

- [Java 开发环境配置](http://www.runoob.com/java/java-environment-setup.html)
- [Mac环境下配置Java开发环境（jdk maven tomcat idea）](https://zhuanlan.zhihu.com/p/35272197)
- [Ubuntu下maven安装和tomcat简易安装](https://segmentfault.com/a/1190000004453530)
- [Ubuntu下安装jdk和maven并配置相关环境变量](https://www.jianshu.com/p/de3cec62bf1f)

### `Hello World` 示例

编写 `HelloWorld.java` 代码，示例代码位于 `examples/src/main/java/com/raoyc/demo/HelloWorld.java` 。

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
javac examples/src/main/java/com/raoyc/demo/HelloWorld.java -d ./classes
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

示例代码 [DogTest](examples/src/main/java/com/raoyc/demo/DogTest.java)

当在一个源文件中定义多个类，并且还有 `import` 语句和 `package` 语句时，要特别注意这些规则。

- 一个源文件中只能有一个 `public` 类
- 一个源文件可以有多个非 `public` 类
- 源文件的名称应该和 `public` 类的类名保持一致。例如：源文件中 `public` 类的类名是 `Employee` ，那么源文件应该命名为 `Employee.java` 。
- 如果一个类定义在某个包中，那么 `package` 语句应该在源文件的首行。
- 如果源文件包含 `import` 语句，那么应该放在 `package` 语句和类定义之间。如果没有 `package` 语句，那么 `import` 语句应该在源文件中最前面。
- `import` 语句和 `package` 语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。
- 类有若干种访问级别，并且类也分不同的类型：抽象类和 `final` 类等。

除了上面提到的几种类型，`Java` 还有一些特殊的类，如：内部类、匿名类。

### 变量

```java

public class Variable {
    int a, b, c;  // 申明3个int型变量 a b c
    int d = 3, e = 4, f = 5;  // 申明3个int型变量 d e f 并赋值
    byte z = 22;
    // string 必须使用双引号
    String s = "hello world"; // 实例变量 
    static Float PI = 3.14f;  // 类变量
    // char 必须使用单引号
    char x = 'x';
    char dao = '道';
    char uDao = '\u9053';  // unicode 编码的 '道'

    public void method() {
        int i = 0;  // 局部变量
    }
}
```

#### 局部变量

- 局部变量声明在方法、构造方法或者语句块中；
- 局部变量在方法、构造方法、或者语句块被执行的时候创建，当它们执行完成后，变量将会被销毁；
- 访问修饰符不能用于局部变量；
- 局部变量只在声明它的方法、构造方法或者语句块中可见；
- 局部变量是在栈上分配的；
- 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。

#### 实例变量

- 实例变量声明在一个类中，但在方法、构造方法和语句块之外；
- 当一个对象被实例化之后，每个实例变量的值就跟着确定；
- 实例变量在对象创建的时候创建，在对象被销毁的时候销毁；
- 实例变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量信息；
- 实例变量可以声明在使用前或者使用后；
- 访问修饰符可以修饰实例变量；
- 实例变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把实例变量设为私有。通过使用访问修饰符可以使实例变量对子类可见；
- 实例变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。变量的值可以在声明时指定，也可以在构造方法中指定；
- 实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：`ObejectReference.VariableName` 。

#### 类变量（静态变量）

- 类变量也称为静态变量，在类中以 `static` 关键字声明，但必须在方法构造方法和语句块之外。
- 无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
- 静态变量除了被声明为常量外很少使用。常量是指声明为 `public/private` ，`final` 和 `static` 类型的变量。常量初始化后不可改变。
- 静态变量储存在静态存储区。经常被声明为常量，很少单独使用 `static` 声明变量。
- 静态变量在第一次被访问时创建，在程序结束时销毁。
- 与实例变量具有相似的可见性。但为了对类的使用者可见，大多数静态变量声明为 `public` 类型。
- 默认值和实例变量相似。数值型变量默认值是 `0` ，布尔型默认值是 `false` ，引用类型默认值是 `null` 。变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
- 静态变量可以通过：`ClassName.VariableName` 的方式访问。
- 类变量被声明为 `public static final` 类型时，类变量名称一般建议使用大写字母。如果静态变量不是 `public` 和 `final` 类型，其命名方式与实例变量以及局部变量的命名方式一致。

### 修饰符

#### 访问控制修饰符

`Java` 中，可以使用访问控制符来保护对类、变量、方法和构造方法的访问。Java 支持 4 种不同的访问权限。

- `default` (即缺省，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
- `private` : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。
- `public` : 对所有类可见。使用对象：类、接口、变量、方法
- `protected` : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类），接口及接口的成员变量和成员方法不能声明为 `protected`。

**访问控制规则**

| 修饰符 | 当前类 | 同一包内 | 子孙类(同一包) | 子孙类(不同包) | 其他包 |
| --- | --- | --- | --- | --- | ---- |
| public | Y | Y | Y | Y | Y |
| protected | Y | Y | Y | Y/N（说明）| N |
| default | Y | Y | Y | N | N |
| private | Y | N | N | N | N |

`protected` 需要从以下两个点来分析说明：

- 子类与基类在同一包中：被声明为 `protected` 的变量、方法和构造器能被同一个包中的任何其他类访问；
- 子类与基类不在同一包中：那么在子类中，子类实例可以访问其从基类继承而来的 `protected` 方法，而不能访问基类实例的 `protected` 方法。

**访问控制和继承**

- 父类中声明为 `public` 的方法在子类中也必须为 `public` 。
- 父类中声明为 `protected` 的方法在子类中要么声明为 `protected` ，要么声明为 `public` ，不能声明为 `private` 。
- 父类中声明为 `private` 的方法，不能够被继承。

#### 非访问修饰符

为了实现一些其他的功能，Java 也提供了许多非访问修饰符。

- `static` 修饰符，用来修饰类方法和类变量。
- `final` 修饰符，用来修饰类、方法和变量，`final` 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
- `abstract` 修饰符，用来创建抽象类和抽象方法。
- `synchronized` 和 `volatile` 修饰符，主要用于线程的编程。

更多查阅：http://www.runoob.com/java/java-modifier-types.html 。

### 运算符、循环与条件等

运算符、循环、条件与`switch/case` 等知识点，类似于你所熟知的某门语言，如 `javascript/php/c/c++` 等语言，这里限于篇幅不过多赘述。您可以查阅最后一节提供的参考资源链接来学习相关内容。另外，也可参考本仓库的示例代码： [OperatorTest](examples/src/main/java/com/raoyc/demo/OperatorTest.java) 与  [ControlFlowTest](examples/src/main/java/com/raoyc/demo/ControlFlowTest.java) 。

## 高阶知识 - 数据结构

### 数组（Array）

>   数组是用来存储固定大小的同类型元素。

```java
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
    }
}
```

排序算法：[冒泡排序](examples/src/main/java/com/raoyc/demo/BubbleSort.java) 。

### 向量（Vector）

>   向量（ `Vector` ）类和传统数组非常相似，但是 `Vector` 的大小能根据需要动态的变化。和数组一样，Vector对象的元素也能通过索引访问。

```java
import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector v = new Vector(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        Enumeration vEnum = v.elements();  // 枚举
        System.out.println("Elements in vector:");
        while(vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " ");
        }
    }
}
```
### 栈（Stack）

>   栈（ `Stack` ）实现了一个后进先出（ `LIFO` ）的数据结构。你可以把栈理解为对象的垂直分布的栈，当你添加一个新元素时，就将新元素放在其他元素的顶部。当你从栈中取元素的时候，就从栈顶取一个元素。换句话说，最后进栈的元素最先被取出。

### 哈希表（Hashtable）

>   `Hashtable` 类提供了一种在用户定义键结构的基础上来组织数据的手段。
`Hashtable` 是原始的 `java.util` 的一部分， 是一个 `Dictionary` 具体的实现 。然而，`Java 2` 重构的 `Hashtable` 实现了 `Map` 接口，因此，`Hashtable` 现在集成到了集合框架中。它和 `HashMap` 类很相似，但是它支持同步。像 `HashMap` 一样，`Hashtable` 在哈希表中存储键/值对。当使用一个哈希表，要指定用作键的对象，以及要链接到该键的值。

```java
import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableTest {

    public static void main(String[] args) {
        Hashtable balance = new Hashtable();
        Enumeration names;
        String str;
        double bal;

        balance.put("Zara", new Double(3434.34));
        balance.put("Mahnaz", new Double(123.22));
        balance.put("Ayan", new Double(1378.00));
        balance.put("Daisy", new Double(99.22));
        balance.put("Qadir", new Double(-19.08));

        // Show all balances in hash table.
        names = balance.keys();
        while (names.hasMoreElements()) {
            str = (String) names.nextElement();
            System.out.println(str + ": " + balance.get(str));
        }
        System.out.println();
        // Deposit 1,000 into Zara's account
        bal = ((Double) balance.get("Zara")).doubleValue();
        balance.put("Zara", new Double(bal + 1000));
        System.out.println("Zara's new balance: " + balance.get("Zara"));
    }
}
```

## Thrift Java 示例

>   `Apache Thrift` 相关介绍以及具体语言的示例请参考我的 [learning_thrift](https://github.com/ycrao/learning_thrift) 仓库。

### 编写 `thrift` 定义文件：

```thrift
namespace java com.raoyc.thrift.demo.service
service PingService {
    string ping(),
    void say(1:string msg)
}
```

### 生成 `java` 接口代码文件：

```bash
mkdir javagen
thrift -out javagen/ --gen java ping.thrift
```

执行完之后可以看到 `javagen` 文件夹下多出含包名（`com.raoyc.thrift.demo`）路径的 `PingService.java` 文件。

移动或复制生成的上一步文件到项目源码对应的包目录下，本示例中即为：`examples/src/main/java/com/raoyc/thrift/demo/service/PingService.java` 。

### 编写接口处理类：

编写实例化 `PingService.Iface` 的类，本示例代码位于：`examples/src/main/java/com/raoyc/thrift/demo/service/impl/PingServiceImpl.java`

```java
package com.raoyc.thrift.demo.service.impl;

import com.raoyc.thrift.demo.service.PingService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingServiceImpl implements PingService.Iface {
    private Logger logger = LoggerFactory.getLogger(PingService.class);

    @Override
    public String ping() throws TException {
        System.out.println("pong");
        return "pong";
    }

    @Override
    public void say(String msg) throws TException {
        System.out.println(msg);
    }
}
```

### 编写服务端与客户端代码：

具体请参考示例代码：

[ThriftServer](examples/src/main/java/com/raoyc/thrift/demo/ThriftServer.java)

[ThriftClient](examples/src/main/java/com/raoyc/thrift/demo/ThriftClient.java)

### 运行：

使用 `IDE` 安装好依赖， 可以很方便的运行 `ThriftServer` 与 ThriftClient 代码。

运行结果大概如下：

```bash
# start ThriftServer on #terminal#1
ThreadedSelectorServer start....


# start ThriftClient on terminal#2
Client say by class com.raoyc.thrift.demo.ThriftClient@1406718218

# meanwhile on terminal#1 will display
pong
Hello from Java
```

## Quartz 示例

### 简介：

`Quartz` 对任务调度的领域问题进行了高度的抽象，提出了调度器、任务和触发器这3个核心的概念，并在 `org.quartz` 通过接口和类对重要的这些核心概念进行描述。
 
`Quartz` 调度包的两个基本单元是作业和触发器。作业是能够调度的可执行任务，触发器提供了对作业的调度。

调度器：调度器用于将与作业触发器关联，一个作业可关联多个触发器，这样每个触发器被可以触发的作业执行；一个触发器可用于控制多个作业，触发触发时，全部作业将获得调度。`Quartz` 的调度器由 `Scheduler` 接口体现。

作业：只需实现 `org.quartz.job` 接口即可。`Job` 接口包含一个方法 `execute()` ，`execute` 方法体是被调度的作业体。一旦实现 `Job` 接口和 `execute()` 方法， `Quartz` 确定作业运作的时候，它将调用 `execute()` 方法体。

触发器：有`SimpleTrigger` 和 `CronTrigger` 等类型。

### 示例代码：

- [RAMQuartzTest](examples/src/main/java/com/raoyc/quartz/demo/RAMQuartzTest.java)
- [JDBCQuartzTest](examples/src/main/java/com/raoyc/quartz/demo/JDBCQuartzTest.java)

### 参考链接：

- [quartz-core-learning](https://github.com/dufyun/quartz-core-learning)
- [quartz cron 表达式用法（CronTrigger 教程）](https://blog.csdn.net/shfqbluestone/article/details/51009685)
- [Quartz 官网](http://www.quartz-scheduler.org/)
- [Quartz 中文化资料](https://www.w3cschool.cn/quartz_doc/)
- [Quartz 调度系统入门和调度高可用实现方案](https://www.jianshu.com/p/810400e6a274)

## 参考资源

- [Java教程](http://www.runoob.com/java/java-tutorial.html)
- [Java Development Kit 8 Documentation](https://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html)
- [JDK中文版](http://tool.oschina.net/apidocs/apidoc?api=jdk-zh)
- [CyC2018/CS-Notes](https://github.com/CyC2018/CS-Notes)
- [brianway/java-learning](https://github.com/brianway/java-learning)
- [winterbe/java8-tutorial](https://github.com/winterbe/java8-tutorial) 中文版 [aalansehaiyang/java8-tutorial](https://github.com/aalansehaiyang/java8-tutorial)
- [JeffLi1993/java-core-learning-example](https://github.com/JeffLi1993/java-core-learning-example)
- [HowToDoInJava](https://howtodoinjava.com/java/)
- [Java CMS建站系统 - 建站系统 - Trending Projects - Gitee](https://gitee.com/explore/starred/cms?lang=Java)
