

# Hbase

1. 下载地址
   1. 下载地址： https://repo.huaweicloud.com/apache/hbase/2.4.1/hbase-2.4.1-bin.tar.gz
   2. 主页：http://hbase.apache.org/
   3. 参考：
      1. http://hbase.apache.org/book.html#quickstart
      2. https://www.w3cschool.cn/hbase_doc/
      3. https://www.yiibai.com/hbase
   
2. 安装

   使用 hadoop 用户登录CentOS
   
   hadoop处于启动状态
   
   上传安装文件，到/home/hadoop目录
   
   ```shell
   # 解压安装文件
   [hadoop@localhost ~]$ tar -xvf hbase-2.4.1-bin.tar.gz
   
   # cd到软件目录观察
   [hadoop@localhost ~]$ cd hbase-2.4.1
   [hadoop@localhost hbase-2.4.1]$ ll
   total 1804
   drwxr-xr-x.  4 hadoop hadoop    4096 Jan 22  2020 bin
   -rw-r--r--.  1 hadoop hadoop   52688 Jan 22  2020 CHANGES.md
   drwxr-xr-x.  2 hadoop hadoop     208 Jan 22  2020 conf
   drwxr-xr-x. 11 hadoop hadoop    4096 Jan 22  2020 docs
   drwxr-xr-x.  8 hadoop hadoop      94 Jan 22  2020 hbase-webapps
   -rw-r--r--.  1 hadoop hadoop     262 Jan 22  2020 LEGAL
   drwxrwxr-x.  7 hadoop hadoop    8192 Mar  4 16:33 lib
   -rw-r--r--.  1 hadoop hadoop  146512 Jan 22  2020 LICENSE.txt
   -rw-r--r--.  1 hadoop hadoop  574575 Jan 22  2020 NOTICE.txt
   -rw-r--r--.  1 hadoop hadoop    1477 Jan 22  2020 README.txt
   -rw-r--r--.  1 hadoop hadoop 1037623 Jan 22  2020 RELEASENOTES.md
   
   # 配置JAVA_HOME 环境变量
   [hadoop@localhost hbase-2.4.1]$ vi conf/hbase-env.sh
   export JAVA_HOME=/home/hadoop/jdk1.8.0_202
   
   
   # 查看版本信息
   [hadoop@localhost hbase-2.4.1]$ bin/hbase version
   
   # 查看hbase命令帮助
   [hadoop@localhost hbase-2.4.1]$ bin/hbase
   
   ```
   
3. 单机模式

   ```shell
   # 启动
   [hadoop@localhost hbase-2.4.1]$ bin/start-hbase.sh

   # Hbase管理页面
   http://192.168.56.100:16010/master-status
   
   # 观察进程，出现 HMaster，表示启动ok
   [hadoop@localhost hbase-2.4.1]$ jps
   1936 SecondaryNameNode
   6036 Jps
   1751 DataNode
   5639 HMaster
   1640 NameNode
   ```
   
4. 基本命令

   ```shell
   # 打开shell。这一步比较慢。
   [hadoop@localhost hbase-2.4.1]$ bin/hbase shell
   hbase(main):001:0>
   
   # 获取帮助
   hbase:006:0> help
   hbase:003:0> help 'create'
   
   # 状态信息 版本信息
   hbase:007:0> status
   1 active master, 0 backup masters, 1 servers, 0 dead, 2.0000 average load
   Took 3.1238 seconds
   hbase:008:0> version
   2.4.1, rb4d9639f66fccdb45fea0244202ffbd755341260, Fri Jan 15 10:58:57 PST 2021
   Took 0.0006 seconds
   
   # DDL
   # create
   hbase:010:0> create 'table','column_family','column_family1','column_family2'
   Created table table
   Took 2.7149 seconds
   => Hbase::Table - table
   
   # list
   hbase:011:0> list
   TABLE
   table
   1 row(s)
   Took 0.0432 seconds
   => ["table"]
   
   # describe
   hbase:012:0> describe 'table'
   Table table is ENABLED
   table
   COLUMN FAMILIES DESCRIPTION
   {NAME => 'column_family', BLOOMFILTER => 'ROW', IN_MEMORY => 'false', VERSIONS => '1', KEEP_DELETED_CELLS => 'FALSE', DATA_BLOCK_ENCODING => 'NONE', COMPRESSION => 'NONE', TTL =>
    'FOREVER', MIN_VERSIONS => '0', BLOCKCACHE => 'true', BLOCKSIZE => '65536', REPLICATION_SCOPE => '0'}
   
   {NAME => 'column_family1', BLOOMFILTER => 'ROW', IN_MEMORY => 'false', VERSIONS => '1', KEEP_DELETED_CELLS => 'FALSE', DATA_BLOCK_ENCODING => 'NONE', COMPRESSION => 'NONE', TTL =
   > 'FOREVER', MIN_VERSIONS => '0', BLOCKCACHE => 'true', BLOCKSIZE => '65536', REPLICATION_SCOPE => '0'}
   
   {NAME => 'column_family2', BLOOMFILTER => 'ROW', IN_MEMORY => 'false', VERSIONS => '1', KEEP_DELETED_CELLS => 'FALSE', DATA_BLOCK_ENCODING => 'NONE', COMPRESSION => 'NONE', TTL =
   > 'FOREVER', MIN_VERSIONS => '0', BLOCKCACHE => 'true', BLOCKSIZE => '65536', REPLICATION_SCOPE => '0'}
   
   3 row(s)
   Quota is disabled
   Took 0.6369 seconds
   
   # alter
   hbase:013:0> alter 'table',{NAME=>'column_family',METHOD=>'delete'}
   Updating all regions with the new schema...
   1/1 regions updated.
   Done.
   Took 2.6042 seconds
   
   # describe
   hbase:014:0> describe 'table'
   Table table is ENABLED
   table
   COLUMN FAMILIES DESCRIPTION
   {NAME => 'column_family1', BLOOMFILTER => 'ROW', IN_MEMORY => 'false', VERSIONS => '1', KEEP_DELETED_CELLS => 'FALSE', DATA_BLOCK_ENCODING => 'NONE', COMPRESSION => 'NONE', TTL =
   > 'FOREVER', MIN_VERSIONS => '0', BLOCKCACHE => 'true', BLOCKSIZE => '65536', REPLICATION_SCOPE => '0'}
   
   {NAME => 'column_family2', BLOOMFILTER => 'ROW', IN_MEMORY => 'false', VERSIONS => '1', KEEP_DELETED_CELLS => 'FALSE', DATA_BLOCK_ENCODING => 'NONE', COMPRESSION => 'NONE', TTL =
   > 'FOREVER', MIN_VERSIONS => '0', BLOCKCACHE => 'true', BLOCKSIZE => '65536', REPLICATION_SCOPE => '0'}
   
   2 row(s)
   Quota is disabled
   Took 0.1159 seconds
   
   # disable enable exists
   hbase:017:0> disable 'table'
   Took 0.9201 seconds
   hbase:018:0> is_enabled 'table'
   false
   Took 0.0427 seconds
   => false
   hbase:019:0> enable 'table'
   Took 1.2812 seconds
   hbase:020:0> is_enabled 'table'
   true
   Took 0.0398 seconds
   => true
   hbase:022:0> exists 'table'
   Table table does exist
   Took 0.0764 seconds
   => true
   
   # DML
   
   # 插入数据
   hbase:023:0> put 'table','id','column_family1:name','tanggao'
   Took 0.6273 seconds
   hbase:024:0> put 'table','id','column_family1:age','20'
   Took 0.0222 seconds
   hbase:025:0> put 'table','id','column_family1:sex','boy'
   Took 0.0221 seconds
   
   # 根据id获取数据
   hbase:026:0> get 'table','id'
   COLUMN                                        CELL
    column_family1:age                           timestamp=2021-03-04T17:09:50.697, value=20
    column_family1:name                          timestamp=2021-03-04T17:09:37.832, value=tanggao
    column_family1:sex                           timestamp=2021-03-04T17:09:57.790, value=boy
   1 row(s)
   Took 0.4363 seconds
   # 一个列族的所有数据
   hbase:027:0> get 'table','id','column_family1'
   COLUMN                                        CELL
    column_family1:age                           timestamp=2021-03-04T17:09:50.697, value=20
    column_family1:name                          timestamp=2021-03-04T17:09:37.832, value=tanggao
    column_family1:sex                           timestamp=2021-03-04T17:09:57.790, value=boy
   1 row(s)
   Took 0.0351 seconds
   # 一个列族中一个列的所有数据
   hbase:028:0> get 'table','id','column_family1:name'
   COLUMN                                        CELL
    column_family1:name                          timestamp=2021-03-04T17:09:37.832, value=tanggao
   1 row(s)
   Took 0.0808 seconds
   # 全表扫描
   hbase:022:0> scan 'table'
   
   # 把id的age修改为22
   hbase:029:0> put 'table','id','column_family1:age','22'
   Took 0.0588 seconds
   hbase:030:0> get 'table','id','column_family1:age'
   COLUMN                                        CELL
    column_family1:age                           timestamp=2021-03-04T17:12:39.333, value=22
   1 row(s)
   Took 0.0282 seconds
   
   # 删除
   hbase:052:0> delete 'table','id', 'column_family1:age'
   # delete 操作并不会马上删除数据，只会将对应的数据打上删除标记（tombstone），只有在合并数据时，数据才会被删除。
   hbase:007:0> compact 'table'
   Took 0.2165 seconds
   hbase:053:0> get 'table','id'
   COLUMN                                        CELL
    column_family1:name                          timestamp=2021-03-04T20:38:17.958, value=tanggao
    column_family1:sex                           timestamp=2021-03-04T20:38:29.885, value=boy
   1 row(s)
   Took 0.0109 seconds
   # 删除行
   hbase:008:0> deleteall 'table','id'
   Took 0.3576 seconds
   hbase:009:0> count 'table'
   0 row(s)
   Took 0.2193 seconds
   => 0
   
   # 删除表
   hbase:010:0> disable 'table'
   Took 4.4794 seconds
   hbase:011:0> drop 'table'
   Took 0.7852 seconds
   
   # 退出shell
   hbase:012:0> exit
   
   # 停止Hbase数据库
   [hadoop@localhost hbase-2.4.1]$ bin/stop-hbase.sh
   stopping hbase....................
   ```

5. 伪分布式

   ```shell
   # 修改配置文件内容如下，配置文件中原有的property注释掉
   [hadoop@localhost hbase-2.4.1]$ vi conf/hbase-site.xml
   
   <property>
     <name>hbase.cluster.distributed</name>
     <value>true</value>
   </property>
   
   <property>
     <name>hbase.rootdir</name>
     <value>hdfs://localhost:9000/hbase</value>
   </property>
   
   # 启动
   [hadoop@localhost hbase-2.4.1]$ bin/start-hbase.sh
   
   # 查看进程状态
   [hadoop@localhost hbase-2.4.1]$ jps
   1936 SecondaryNameNode
   12115 HRegionServer
   13093 Jps
   1751 DataNode
   1640 NameNode
   11897 HQuorumPeer
   12682 JarBootstrapMain
   11998 HMaster
   
   # 启动shell
   [hadoop@localhost hbase-2.4.1]$ bin/hbase shell
   ```
   
   Hbase信息已保存到HDFS
   
   http://192.168.56.100:9870/explorer.html#/hbase
   

![image-20210305144919185](img/image-20210305144919185.png)

   

   Hbase基本命令

   ```shell
   # create
   hbase:002:0> create 'test', 'cf'
   Created table test
   Took 6.7574 seconds
   => Hbase::Table - test
   
   # list
   hbase:003:0> list 'test'
   TABLE
   test
   1 row(s)
   Took 0.0941 seconds
   => ["test"]
   
   # describe
   hbase:004:0> describe 'test'
   Table test is ENABLED
   test
   COLUMN FAMILIES DESCRIPTION
   {NAME => 'cf', BLOOMFILTER => 'ROW', IN_MEMORY => 'false', VERSIONS => '1', KEEP_DELETED_CELLS => 'FALSE', DATA_BLOCK_ENCODING => 'NONE', COMPRESSION => 'NONE', TTL => 'FOREVER',
    MIN_VERSIONS => '0', BLOCKCACHE => 'true', BLOCKSIZE => '65536', REPLICATION_SCOPE => '0'}
   
   1 row(s)
   Quota is disabled
   Took 0.8296 seconds
   
   # put
   hbase:005:0> put 'test', 'row1', 'cf:a', 'value1'
   Took 0.7974 seconds
   hbase:006:0> put 'test', 'row2', 'cf:b', 'value2'
   Took 0.0519 seconds
   hbase:007:0> put 'test', 'row3', 'cf:c', 'value3'
   Took 0.0804 seconds
   
   # scan
   hbase:008:0> scan 'test'
   ROW                                           COLUMN+CELL
    row1                                         column=cf:a, timestamp=2021-03-04T23:21:52.514, value=value1
    row2                                         column=cf:b, timestamp=2021-03-04T23:21:56.874, value=value2
    row3                                         column=cf:c, timestamp=2021-03-04T23:22:01.847, value=value3
   3 row(s)
   Took 0.1587 seconds
   
   # get
hbase:009:0> get 'test', 'row1'
   COLUMN                                        CELL
    cf:a                                         timestamp=2021-03-04T23:21:52.514, value=value1
   1 row(s)
   Took 0.0222 seconds
   
   # disable enable drop
   hbase:010:0> disable 'test'
   Took 4.3581 seconds
   hbase:011:0> enable 'test'
   Took 1.3697 seconds
   hbase:012:0> disable 'test'
   Took 0.7614 seconds
   hbase:013:0> drop 'test'
   Took 2.4362 seconds
   
   # 退出shell
   hbase:012:0> exit
   
   ```

6. 练习

   1. 创建Hbase student表，结构如下

      ![image-20210305145507064](img/image-20210305145507064.png)

   2. 列出表的相关信息

   3. 在终端打印出指定的表的所有记录数据

   4. get命令获取一行数据

   5. 向已经创建好的表添加和删除指定的列族或列

   6. 统计表的行数

   7. 清空指定的表的所有记录数据

   8. 实现下述数据表
   
      ![image-20210420175112738](img/image-20210420175112738.png)
   
      