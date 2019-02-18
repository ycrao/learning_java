Flyway教程
------

>   Flyway 官网：https://flywaydb.org/ 。

### 使用 `Flyway 命令行工具` 方式迁移数据库

安装命令行工具： https://flywaydb.org/documentation/commandline/ 。

`Linux` 下版本，可以使用下列命令安装 `flyway` 。

```bash
wget -qO- https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/5.2.4/flyway-commandline-5.2.4-linux-x64.tar.gz | tar xvz && sudo ln -s `pwd`/flyway-5.2.4/flyway /usr/local/bin 
```

然后，书写 `flyway.conf` ，如下示例：

```conf
flyway.url=jdbc:mysql://localhost:3306/flyway_test
flyway.user=root
flyway.password=root
```

编写迁移脚本文件 `V1__Create_person_table.sql` ，如下示例内容：

```sql
create table PERSON (
    ID int not null,
    NAME varchar(100) not null
);
```

然后执行迁移命令：

```bash
flyway migrate -locations=filesystem:/home/raoyc/github.com/ycrao/learning_java/examples/src/main/resources/db/migration/ -X
```

`--locations=filesystem:` 是指定自定义的本地迁移文件所在位置，否则必须将在迁移脚本放置在 `flyway` 安装目录 `sql` 文件夹下方能执行成功。

### 使用 `Flyway Maven 插件` 方式迁移数据库

