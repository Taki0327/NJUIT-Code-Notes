# HDFS基本操作

1. 使用 hadoop 用户登录CentOS

   成功启动后，可以访问 Web 界面 http://IP:9870 查看 NameNode 和 Datanode 信息，还可以在线查看 HDFS 中的文件。

   ```shell
   # 启动HDFS
   [hadoop@192 hadoop-3.2.2]$ sbin/start-dfs.sh
   Starting namenodes on [localhost]
   Starting datanodes
   Starting secondary namenodes [192.168.0.104]

   # 查看有哪些文件操作命令
   [hadoop@localhost hadoop-3.2.2]$ ./bin/hadoop fs
   Usage: hadoop fs [generic options]
   
   # 查看具体某个命令的作用
   [hadoop@localhost hadoop-3.2.2]$ ./bin/hadoop fs -help put
   ```
   
   
   
2. 目录操作

   ```shell
   # 第一次使用HDFS时，需要首先在HDFS中创建用户目录。已经创建的话请忽略。
   # /user/hadoop为hadoop用户对应的home目录
   [hadoop@192 hadoop-3.2.2]$ bin/hdfs dfs -mkdir -p /user/hadoop
   
   # 列出 / 目录下的文件内容
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -ls /
   Found 1 items
   drwxr-xr-x   - hadoop supergroup          0 2021-02-26 00:03 /user
   
   # 列出 /user/hadoop 目录下的文件内容
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -ls .
   
   # 创建目录 ./input，即/user/hadoop/input
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -mkdir input
   mkdir: `input': File exists
   
   # 删除目录
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -rm -r input
   Deleted input
   ```

3. 文件操作

   ```shell
   # 上传文件
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -put README.txt .
   
   # cat文件内容
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -cat README.txt
   For the latest information about Hadoop, please visit our website at:
   
      http://hadoop.apache.org/
   
   and our wiki, at:
   
   # 下载文件
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -get README.txt README-get.txt
   
   # 复制文件
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -cp README.txt README-copy.txt
   
   # 移动文件
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -mv README.txt README-mv.txt
   
   # 删除文件
   [hadoop@10 hadoop-3.2.2]$ ./bin/hadoop fs -rm README-mv.txt
   Deleted README-mv.txt
   
   ```

# 练习内容

1. 阅读参考文档：https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/FileSystemShell.html
   
2. 练习如下HDFS命令，并解释各个命令的作用
   
   ```shell
   [-appendToFile <localsrc> ... <dst>]
   [-cat [-ignoreCrc] <src> ...]
   [-count [-q] [-h] [-v] [-t [<storage type>]] [-u] [-x] [-e] <path> ...]
   [-cp [-f] [-p | -p[topax]] [-d] <src> ... <dst>]
   [-df [-h] [<path> ...]]
   [-du [-s] [-h] [-v] [-x] <path> ...]
   [-find <path> ... <expression> ...]
   [-get [-f] [-p] [-ignoreCrc] [-crc] <src> ... <localdst>]
   [-head <file>]
   [-help [cmd ...]]
   [-ls [-C] [-d] [-h] [-q] [-R] [-t] [-S] [-r] [-u] [-e] [<path> ...]]
   [-mkdir [-p] <path> ...]
   [-mv <src> ... <dst>]
   [-put [-f] [-p] [-l] [-d] [-t <thread count>] <localsrc> ... <dst>]
   [-rm [-f] [-r|-R] [-skipTrash] [-safely] <src> ...]
   [-rmdir [--ignore-fail-on-non-empty] <dir> ...]
   [-tail [-f] [-s <sleep interval>] <file>]
   [-test -[defswrz] <path>]
   [-text [-ignoreCrc] <src> ...]
   [-touch [-a] [-m] [-t TIMESTAMP ] [-c] <path> ...]
   [-touchz <path> ...]
   [-truncate [-w] <length> <path> ...]
   [-usage [cmd ...]]
   ```

3. 重点：

   1. 理解HDFS操作原理，学会看帮助文档
   2. 目录查看、创建、删除
   3. 文件查看、创建、删除、重命名

