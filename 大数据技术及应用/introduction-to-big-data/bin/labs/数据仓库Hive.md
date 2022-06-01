# 数据仓库Hive

1. 下载地址
   1. 下载地址：https://mirrors.bfsu.edu.cn/apache/hive/hive-3.1.2/apache-hive-3.1.2-bin.tar.gz
   2. 主页：https://hive.apache.org/
   3. 参考：https://cwiki.apache.org/confluence/display/Hive/GettingStarted

2. 安装

   使用 hadoop 用户登录CentOS
   
   hdfs处于启动状态
   
   ```shell
   # hadoop配置文件中，注释掉 HADOOP_CLASSPATH，否则启动可能会报错
   [hadoop@10 ~]$ vi hadoop-3.2.2/etc/hadoop/hadoop-env.sh
   #export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar
   
   # 在HDFS上创建/tmp和/user/hive/warehouse两个目录，并修改他们的同组权限可写
   [hadoop@localhost hadoop-3.2.2]$ cd /home/hadoop/hadoop-3.2.2
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -mkdir /tmp
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -mkdir -p /user/hive/warehouse
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -chmod g+w /tmp
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -chmod g+w /user/hive/warehouse
   
   # 上传安装文件，到/home/hadoop目录，解压安装文件
   [hadoop@localhost apache-hive-3.1.2-bin]$ cd
   [hadoop@localhost ~]$ tar -xvf apache-hive-3.1.2-bin.tar.gz
   
   # hive里的guava版本较低，替换为hadoop里的guava
   [hadoop@localhost ~]$ mv ./apache-hive-3.1.2-bin/lib/guava-19.0.jar ./apache-hive-3.1.2-bin/lib/guava-19.0.jar.bak
   [hadoop@10 ~]$ cp ./hadoop-3.2.2/share/hadoop/common/lib/guava-27.0-jre.jar ./apache-hive-3.1.2-bin/lib/
   
   # cd到软件目录观察
   [hadoop@localhost ~]$ cd apache-hive-3.1.2-bin
   [hadoop@localhost apache-hive-3.1.2-bin]$ ll
   total 56
   drwxrwxr-x. 3 hadoop hadoop   157 Mar  8 23:42 bin
   drwxrwxr-x. 2 hadoop hadoop  4096 Mar  8 23:42 binary-package-licenses
   drwxrwxr-x. 2 hadoop hadoop  4096 Mar  8 23:42 conf
   drwxrwxr-x. 4 hadoop hadoop    34 Mar  8 23:42 examples
   drwxrwxr-x. 7 hadoop hadoop    68 Mar  8 23:42 hcatalog
   drwxrwxr-x. 2 hadoop hadoop    44 Mar  8 23:42 jdbc
   drwxrwxr-x. 4 hadoop hadoop 12288 Mar  8 23:42 lib
   -rw-r--r--. 1 hadoop hadoop 20798 Aug 23  2019 LICENSE
   -rw-r--r--. 1 hadoop hadoop   230 Aug 23  2019 NOTICE
   -rw-r--r--. 1 hadoop hadoop  2469 Aug 23  2019 RELEASE_NOTES.txt
   drwxrwxr-x. 4 hadoop hadoop    35 Mar  8 23:42 scripts
   
   # 版本信息
   [hadoop@10 apache-hive-3.1.2-bin]$ bin/hive --version
   
   # 初始化schema，使用derby数据库
   [hadoop@10 apache-hive-3.1.2-bin]$ bin/schematool -dbType derby -initSchema
   Initialization script completed
   schemaTool completed
   
   # 目录中增加了数据库文件metastore_db
   # 如果初始化失败，可以先删除这个文件夹
   [hadoop@10 apache-hive-3.1.2-bin]$ ll
   
   drwxrwxr-x. 5 hadoop hadoop   133 Mar  9 01:48 metastore_db
   
   # 打开 Hive CLI
   [hadoop@10 apache-hive-3.1.2-bin]$ bin/hive
   
   ```
   
3. Hive DDL

   ```shell
   # 创建数据库
   hive> CREATE DATABASE IF NOT EXISTS userdb;
   OK
   Time taken: 0.481 seconds
   
   # 查看数据库
   hive> show databases;
   OK
   default
   userdb
   
   # 选择数据库
   hive> use userdb;
   OK
   Time taken: 0.059 seconds
   hive> select current_database();
   OK
   userdb
   Time taken: 0.347 seconds, Fetched: 1 row(s)
   
   # 创建表
   hive> CREATE TABLE IF NOT EXISTS employee ( eid int, name String, salary String, designation String)
       >  COMMENT 'Employee details'
       >  ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
       >  LINES TERMINATED BY '\n'
       >  STORED AS TEXTFILE;
   OK
   Time taken: 0.229 seconds
   
   
   # 查看表
   hive> show tables;
   OK
   employee
   Time taken: 0.088 seconds, Fetched: 1 row(s)
   
   # 描述表
   hive> desc employee;
   OK
   eid                     int
   name                    string
   salary                  string
   designation             string
   Time taken: 0.804 seconds, Fetched: 4 row(s)
   
   ```

4. Hive DML

   ```shell
   # 编辑数据
   [hadoop@10 ~]$ vi sample.txt
   
   1201|Gopal|45000|Technical manager
   1202|Manisha|45000|Proof reader
   1203|Masthanvali|40000|Technical writer
   1204|Kiran|40000|Hr Admin
   1205|Kranthi|30000|Op Admin
   
   # 传入hdfs，如下是传入到hdfs的/user/hadoop目录
   [hadoop@10 ~]$ hadoop-3.2.2/bin/hadoop fs -put /user/hadoop/sample.txt
   # ls确认下已上传成功
   [hadoop@10 ~]$ hadoop-3.2.2/bin/hadoop fs -ls
   
   # 导入到hive
   hive> LOAD DATA INPATH '/user/hadoop/sample.txt' OVERWRITE INTO TABLE employee;
   Loading data to table userdb.employee
   OK
   Time taken: 2.471 seconds
   
   # 查看数据
   hive> select * from employee;
   OK
   1201    Gopal   45000   Technical manager
   1202    Manisha 45000   Proof reader
   1203    Masthanvali     40000   Technical writer
   1204    Kiran   40000   Hr Admin
   1205    Kranthi 30000   Op Admin
   
   hive> select * from employee where eid=1203;
   OK
   1203    Masthanvali     40000   Technical writer
   Time taken: 0.843 seconds, Fetched: 1 row(s)
   
   
   ```

   

5. Hive WordCount

   先参考[MapReduce](./MapReduce.md)章节准备好input目录中的数据

   ```shell
   # 建表
   hive> create table docs(line string);
   OK
   Time taken: 0.171 seconds
   
   # 导入数据到Hive
   hive> load data inpath '/user/hadoop/input' overwrite into table docs;
   Loading data to table userdb.docs
   OK
   Time taken: 0.666 seconds
   
   # 查看数据
   hive> select * from docs;
   OK
   Hello world
   Connected world
   One world
   One dream
   Hello Hadoop
   Hello Map
   Hello Reduce
   
   Time taken: 0.391 seconds, Fetched: 10 row(s)
   
   # 按空格分割
   hive> SELECT split(line, ' ') AS word FROM docs;
   OK
   ["Hello","world"]
   ["Connected","world"]
   ["One","world"]
   ["One","dream"]
   ["Hello","Hadoop"]
   ["Hello","Map"]
   ["Hello","Reduce"]
   
   # 分割后的单词仍是都在一行，无法实现想要的功能，因此需要进行行转列操作
   hive> SELECT explode(split(line, ' ')) AS word FROM docs;
   OK
   Hello
   world
   Connected
   world
   One
   world
   One
   dream
   Hello
   Hadoop
   Hello
   Map
   Hello
   Reduce
   
   # group by, wordcount
   hive> select word, count(1) as count from
       > (select explode(split(line,' '))as word from docs) w
       > group by word
       > order by word;
   Query ID = hadoop_20210309032835_83a2438d-09fc-4113-a4c2-b8c44821a377
   Total jobs = 2
   Launching Job 1 out of 2
   Number of reduce tasks not specified. Estimated from input data size: 1
   In order to change the average load for a reducer (in bytes):
     set hive.exec.reducers.bytes.per.reducer=<number>
   In order to limit the maximum number of reducers:
     set hive.exec.reducers.max=<number>
   In order to set a constant number of reducers:
     set mapreduce.job.reduces=<number>
   Job running in-process (local Hadoop)
   2021-03-09 03:28:46,340 Stage-1 map = 0%,  reduce = 0%
   2021-03-09 03:28:49,607 Stage-1 map = 100%,  reduce = 0%
   2021-03-09 03:28:51,715 Stage-1 map = 100%,  reduce = 100%
   Ended Job = job_local1002665161_0001
   Launching Job 2 out of 2
   Number of reduce tasks determined at compile time: 1
   In order to change the average load for a reducer (in bytes):
     set hive.exec.reducers.bytes.per.reducer=<number>
   In order to limit the maximum number of reducers:
     set hive.exec.reducers.max=<number>
   In order to set a constant number of reducers:
     set mapreduce.job.reduces=<number>
   Job running in-process (local Hadoop)
   2021-03-09 03:28:56,158 Stage-2 map = 0%,  reduce = 0%
   2021-03-09 03:28:57,209 Stage-2 map = 100%,  reduce = 100%
   Ended Job = job_local1026642352_0002
   MapReduce Jobs Launched:
   Stage-Stage-1:  HDFS Read: 2584 HDFS Write: 0 SUCCESS
   Stage-Stage-2:  HDFS Read: 2584 HDFS Write: 0 SUCCESS
   Total MapReduce CPU Time Spent: 0 msec
   OK
   Connected       1
   Hadoop  1
   Hello   4
   Map     1
   One     2
   Reduce  1
   dream   1
   world   3
   Time taken: 22.063 seconds, Fetched: 9 row(s)
   
   # 采用Hive实现最大的优势是，对于非程序员，不用学习编写Java MapReduce代码了，只需要用户学习使用HiveQL就可以了，而这对于有SQL基础的用户而言是非常容易的。
   ```

6. 练习

   usr用户表 

   | id（int） | name（string） | age（int） | hobby（string） |
   | --------- | -------------- | ---------- | --------------- |
   | 1         | liming         | 18         | basketball      |
   | 2         | liuhua         | 21         | running         |
   | 3         | hanmei         | 16         | singing         |

    

   在Hive Shell模式下，创建数据库hive，并根据上面给出的usr表格，在数据库hive下设计用户表usr。

   1．设计完后，用show命令查看hive数据库下包含的所有表，用describe命令查看表usr的基本信息，并给出截图。

   2．查询hanmei 的兴趣爱好，并给出截图。

   3．新建一个与usr表拥有相同列的空表new_usr，并把usr中数据插入到new_usr中，并给出截图。

   4．把文件usr_add.txt文件中内容增加到usr表中，并给出截图。其中，文件usr_add.txt中内容为：

   ```
   4，lily，35，singing
   5，xiaoli，28，running
   ```

   5.统计usr表中有相同兴趣爱好的人的个数。

