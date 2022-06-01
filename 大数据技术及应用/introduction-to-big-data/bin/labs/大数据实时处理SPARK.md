# Spark

1. 下载地址

   1. 下载地址： https://mirrors.bfsu.edu.cn/apache/spark/spark-3.0.2/spark-3.0.2-bin-hadoop3.2.tgz
   2. 主页：http://spark.apache.org/
   3. 参考：
      1. http://spark.apache.org/docs/latest/quick-start.html
      2. http://spark.apache.org/docs/latest/api/scala/org/apache/spark/index.html
      3. https://www.w3cschool.cn/spark/

2. 安装

   使用 hadoop 用户登录CentOS

   上传安装文件，到/home/hadoop目录

   ```shell
   # 解压安装文件
   [hadoop@localhost ~]$ tar -xvf spark-3.0.2-bin-hadoop3.2.tgz
   
   # 观察目录结构
   [hadoop@localhost ~]$ cd spark-3.0.2-bin-hadoop3.2
   [hadoop@localhost spark-3.0.2-bin-hadoop3.2]$ ll
   total 124
   drwxr-xr-x. 2 hadoop hadoop  4096 Feb 16 14:32 bin
   drwxr-xr-x. 2 hadoop hadoop   196 Feb 16 14:32 conf
   drwxr-xr-x. 5 hadoop hadoop    50 Feb 16 14:32 data
   drwxr-xr-x. 4 hadoop hadoop    29 Feb 16 14:32 examples
   drwxr-xr-x. 2 hadoop hadoop 12288 Feb 16 14:32 jars
   drwxr-xr-x. 4 hadoop hadoop    38 Feb 16 14:32 kubernetes
   -rw-r--r--. 1 hadoop hadoop 23312 Feb 16 14:32 LICENSE
   drwxr-xr-x. 2 hadoop hadoop  4096 Feb 16 14:32 licenses
   -rw-r--r--. 1 hadoop hadoop 57677 Feb 16 14:32 NOTICE
   drwxr-xr-x. 7 hadoop hadoop   275 Feb 16 14:32 python
   drwxr-xr-x. 3 hadoop hadoop    17 Feb 16 14:32 R
   -rw-r--r--. 1 hadoop hadoop  4488 Feb 16 14:32 README.md
   -rw-r--r--. 1 hadoop hadoop   183 Feb 16 14:32 RELEASE
   drwxr-xr-x. 2 hadoop hadoop  4096 Feb 16 14:32 sbin
   drwxr-xr-x. 2 hadoop hadoop    42 Feb 16 14:32 yarn
   
   # 启动
   [hadoop@localhost spark-3.0.2-bin-hadoop3.2]$ bin/spark-shell
   21/03/15 15:36:39 WARN Utils: Your hostname, localhost.localdomain resolves to a loopback address: 127.0.0.1; using 192.168.56.100 instead (on interface enp0s3)
   21/03/15 15:36:39 WARN Utils: Set SPARK_LOCAL_IP if you need to bind to another address
   21/03/15 15:36:41 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
   Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
   Setting default log level to "WARN".
   To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
   Spark context Web UI available at http://192.168.56.100:4040
   Spark context available as 'sc' (master = local[*], app id = local-1615793836594).
   Spark session available as 'spark'.
   Welcome to
         ____              __
        / __/__  ___ _____/ /__
       _\ \/ _ \/ _ `/ __/  '_/
      /___/ .__/\_,_/_/ /_/\_\   version 3.0.2
         /_/
   
   Using Scala version 2.12.10 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_202)
   Type in expressions to have them evaluated.
   Type :help for more information.
   
   # 根据提示，可以打开spark任务监控网址
   http://192.168.56.100:4040/
   
   # Spark Shell提供了一个名为“sc”的SparkContext，和一个名为“spark”的SparkSession
   # 参考：http://spark.apache.org/docs/latest/api/scala/org/apache/spark/SparkContext.html
   # 参考：http://spark.apache.org/docs/latest/api/scala/org/apache/spark/sql/SparkSession.html
   scala> sc
   res1: org.apache.spark.SparkContext = org.apache.spark.SparkContext@5f51f320
   scala> spark
   res8: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@10990a32
   
   # 获取帮助
   scala> :help
   All commands can be abbreviated, e.g., :he instead of :help.
   :completions <string>    output completions for the given string
   :edit <id>|<line>        edit history
   :help [command]          print this summary or command-specific help
   :history [num]           show the history (optional num is commands to show)
   :h? <string>             search the history
   :imports [name name ...] show import history, identifying sources of names
   :implicits [-v]          show the implicits in scope
   :javap <path|class>      disassemble a file or class name
   :line <id>|<line>        place line(s) at the end of history
   :load <path>             interpret lines in a file
   :paste [-raw] [path]     enter paste mode or paste a file
   :power                   enable power user mode
   :quit                    exit the interpreter
   :replay [options]        reset the repl and replay all previous commands
   :require <path>          add a jar to the classpath
   :reset [options]         reset the repl to its initial state, forgetting all session entries
   :save <path>             save replayable session to a file
   :sh <command line>       run a shell command (result is implicitly => List[String])
   :settings <options>      update compiler options, if possible; see reset
   :silent                  disable/enable automatic printing of results
   :type [-v] <expr>        display the type of an expression without evaluating it
   :kind [-v] <type>        display the kind of a type. see also :help kind
   :warnings                show the suppressed warnings from the most recent line which had any
   
   # 退出命令。退出的话，必须使用这个命令，否则进程还在
   scala> :quit
   
   # Spark自带的例子，计算pi
   [hadoop@localhost spark-3.0.2-bin-hadoop3.2]$ bin/run-example SparkPi 10
   Pi is roughly 3.141875141875142
   ```
   
3. Spark Dataset

   参考文档：

   1. http://spark.apache.org/docs/latest/api/scala/org/apache/spark/sql/Dataset.html

   ```shell
   # 读取spark自带的文件，创建Dataset
   scala> val textFile = spark.read.textFile("README.md")
   textFile: org.apache.spark.sql.Dataset[String] = [value: string]
   
   # Number of items in this Dataset
   scala> textFile.count()
   res9: Long = 108
   
   # First item in this Dataset
   scala> textFile.first()
   res10: String = # Apache Spark
   
   # filter
   scala> val linesWithSpark = textFile.filter(line => line.contains("Spark"))
   linesWithSpark: org.apache.spark.sql.Dataset[String] = [value: string]
   
   scala> linesWithSpark.count()
   res11: Long = 19
   
   # foreach
   scala> textFile.foreach((arg :String) => println(arg))
   
   # map 计算每行单词数目
   scala> textFile.map(line => line.split(" ").size)
   res14: org.apache.spark.sql.Dataset[Int] = [value: int]
   
   scala> textFile.map(line => line.split(" ").size).collect()
   res7: Array[Int] = Array(3, 1, 12, 13, 11, 12, 8, 6, 1, 1, 1, 2, 2, 2, 1, 1, 3, 1, 10, 6, 8, 1, 3, 1, 6, 8, 1, 8, 1, 13, 1, 10, 2, 1, 16, 1, 4, 1, 12, 1, 5, 1, 8, 1, 10, 1, 4, 1, 11, 1, 5, 1, 10, 1, 10, 1, 3, 1, 11, 11, 1, 6, 1, 6, 1, 12, 12, 9, 13, 14, 3, 1, 7, 1, 13, 1, 3, 1, 10, 4, 1, 5, 1, 7, 8, 1, 9, 1, 6, 1, 13, 11, 13, 1, 7, 7, 12, 8, 1, 2, 1, 6, 12, 1, 2, 1, 7, 11)
   
   # reduce 单词数最多的行
   scala> textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)
   res4: Int = 16
   
   # 使用java max函数
   scala> import java.lang.Math
   import java.lang.Math
   
   scala> textFile.map(line => line.split(" ").size).reduce((a, b) => Math.max(a, b))
   res5: Int = 16
   
   # Dataset wordCount
   # we call flatMap to transform a Dataset of lines to a Dataset of words, and then combine groupByKey and count to compute the per-word counts in the file as a Dataset of (String, Long) pairs. 
   scala> val wordCounts = textFile.flatMap(line => line.split(" ")).groupByKey(identity).count()
   wordCounts: org.apache.spark.sql.Dataset[(String, Long)] = [key: string, count(1): bigint]
   
   scala> wordCounts.collect()
   res6: Array[(String, Long)] = Array(([![PySpark,1), (online,1), (graphs,1), (["Building,1), (documentation,3), (command,,2), (abbreviated,1), (overview,1), (rich,1), (set,2), (-DskipTests,1), (1,000,000,000:,2), (name,1), (["Specifying,1), (stream,1), (run:,1), (not,1), (programs,2), (tests,2), (./dev/run-tests,1), (will,1), ([run,1), (particular,2), (Alternatively,,1), (must,1), (using,3), (./build/mvn,1), (you,4), (MLlib,1), (DataFrames,,1), (variable,1), (Note,1), (core,1), (protocols,1), (Guide](https://spark.apache.org/docs/latest/configuration.html),1), (guidance,2), (shell:,2), (can,6), (site,,1), (*,4), (systems.,1), ([building,1), (configure,1), (for,12), (README,1), (Interactive,2), (how,3), ([Configuration,1), (Hive,2), (provides,1), (Hadoop-supporte...
   ```

4. 独立应用Self-Contained Applications

   ```
   
   ```
   

   
5. Spark RDD

   1. 参考文档：
      1. http://spark.apache.org/docs/latest/rdd-programming-guide.html
      2. http://spark.apache.org/docs/latest/api/scala/org/apache/spark/rdd/RDD.html
      3. http://spark.apache.org/docs/latest/api/scala/org/apache/spark/rdd/PairRDDFunctions.html

   2. RDD Operations: build

      ```shell
      # 由Collections构建
      scala> val data = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 6, 8, 5)
      data: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 6, 8, 5)
      scala> val distData = sc.parallelize(data)
      distData: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[0] at parallelize at <console>:26
      scala> distData.collect()
      res0: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 6, 8, 5)
      
      # 由本地文件构建
      scala> val localFile = sc.textFile("README.md")
      localFile: org.apache.spark.rdd.RDD[String] = README.md MapPartitionsRDD[2] at textFile at <console>:24
      
      # 由HDFS构建，前提：HDFS文件目录存在
      scala> val hdfsFile = sc.textFile("hdfs://localhost:9000/user/hadoop/input")
      hdfsFile: org.apache.spark.rdd.RDD[String] = hdfs://localhost:9000/user/hadoop/input MapPartitionsRDD[6] at textFile at <console>:24
      
      scala> hdfsFile.collect()
      res5: Array[String] = Array(Hello world, Connected world, One world, One dream, Hello Hadoop, Hello Map, Hello Reduce)
      ```

   3. RDD Operations: transformations

      ```shell
      #　filter(func)	Return a new dataset formed by selecting those elements of the source on which func returns true.
      scala> val linesWithHello = hdfsFile.filter(line => line.contains("Hello"))
      linesWithSpark: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[2] at filter at <console>:25
      
      scala> linesWithHello.collect()
      res12: Array[String] = Array(Hello world, Hello Hadoop, Hello Map, Hello Reduce)
      
      scala> linesWithHello.count()
      res1: Long = 4
      
      #　distinct([numPartitions]))	Return a new dataset that contains the distinct elements of the source dataset.
      scala> distData.collect()
      res5: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 6, 8, 5)
      
      scala> val distDataDistinct = distData.distinct()
      distDataDistinct: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[10] at distinct at <console>:25
      
      scala> distDataDistinct.collect()
      res4: Array[Int] = Array(4, 1, 6, 3, 7, 9, 8, 10, 5, 2)
      
      #　map(func)	Return a new distributed dataset formed by passing each element of the source through a function func.
      scala> val hdfsFileMap = hdfsFile.map(line => line.split(" "))
      hdfsFileMap: org.apache.spark.rdd.RDD[Array[String]] = MapPartitionsRDD[6] at map at <console>:25
      
      scala> hdfsFileMap.collect()
      res2: Array[Array[String]] = Array(Array(Hello, world), Array(Connected, world), Array(One, world), Array(One, dream), Array(Hello, Hadoop), Array(Hello, Map), Array(Hello, Reduce))
      
      #　flatMap(func)	Similar to map, but each input item can be mapped to 0 or more output items (so func should return a Seq rather than a single item).
      scala> val hdfsFileFlatMap = hdfsFile.flatMap(line => line.split(" "))
      hdfsFileFlatMap: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[7] at flatMap at <console>:25
      
      scala> hdfsFileFlatMap.collect()
      res3: Array[String] = Array(Hello, world, Connected, world, One, world, One, dream, Hello, Hadoop, Hello, Map, Hello, Reduce)
      
      #　groupByKey([numPartitions])	When called on a dataset of (K, V) pairs, returns a dataset of (K, Iterable<V>) pairs.Note: If you are grouping in order to perform an aggregation (such as a sum or average) over each key, using reduceByKey or #　aggregateByKey will yield much better performance.Note: By default, the level of parallelism in the output depends on the number of partitions of the parent RDD. You can pass an optional numPartitions argument to set a different number of tasks.
      scala> val hdfsPairMap = hdfsFileFlatMap.map(word => (word, 1))
      hdfsPairMap: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[11] at map at <console>:25
      
      scala> hdfsPairMap.collect
      res7: Array[(String, Int)] = Array((Hello,1), (world,1), (Connected,1), (world,1), (One,1), (world,1), (One,1), (dream,1), (Hello,1), (Hadoop,1), (Hello,1), (Map,1), (Hello,1), (Reduce,1))
      
      scala> hdfsPairMap.groupByKey().collect
      res8: Array[(String, Iterable[Int])] = Array((world,CompactBuffer(1, 1, 1)), (Map,CompactBuffer(1)), (Connected,CompactBuffer(1)), (Hello,CompactBuffer(1, 1, 1, 1)), (One,CompactBuffer(1, 1)), (dream,CompactBuffer(1)), (Reduce,CompactBuffer(1)), (Hadoop,CompactBuffer(1)))
      
      #　reduceByKey(func, [numPartitions])	When called on a dataset of (K, V) pairs, returns a dataset of (K, V) pairs where the values for each key are aggregated using the given reduce function func, which must be of type (V,V) => V. Like in groupByKey, the number of reduce tasks is configurable through an optional second argument.
      scala> hdfsPairMap.reduceByKey((v1, v2) => v1 + v2).collect
      res11: Array[(String, Int)] = Array((world,3), (Map,1), (Connected,1), (Hello,4), (One,2), (dream,1), (Reduce,1), (Hadoop,1))
      
      #　mapPartitions(func)	Similar to map, but runs separately on each partition (block) of the RDD, so func must be of type Iterator<T> => Iterator<U> when running on an RDD of type T.
      #　mapPartitionsWithIndex(func)	Similar to mapPartitions, but also provides func with an integer value representing the index of the partition, so func must be of type (Int, Iterator<T>) => Iterator<U> when running on an RDD of type T.
      #　sample(withReplacement, fraction, seed)	Sample a fraction fraction of the data, with or without replacement, using a given random number generator seed.
      #　union(otherDataset)	Return a new dataset that contains the union of the elements in the source dataset and the argument.
      #　intersection(otherDataset)	Return a new RDD that contains the intersection of elements in the source dataset and the argument.
      #　aggregateByKey(zeroValue)(seqOp, combOp, [numPartitions])	When called on a dataset of (K, V) pairs, returns a dataset of (K, U) pairs where the values for each key are aggregated using the given combine functions and a neutral "zero" value. Allows an aggregated value type that is different than the input value type, while avoiding unnecessary allocations. Like in groupByKey, the number of reduce tasks is configurable through an optional second argument.
      #　sortByKey([ascending], [numPartitions])	When called on a dataset of (K, V) pairs where K implements Ordered, returns a dataset of (K, V) pairs sorted by keys in ascending or descending order, as specified in the boolean ascending argument.
      #　join(otherDataset, [numPartitions])	When called on datasets of type (K, V) and (K, W), returns a dataset of (K, (V, W)) pairs with all pairs of elements for each key. Outer joins are supported through leftOuterJoin, rightOuterJoin, and fullOuterJoin.
      #　cogroup(otherDataset, [numPartitions])	When called on datasets of type (K, V) and (K, W), returns a dataset of (K, (Iterable<V>, Iterable<W>)) tuples. This operation is also called groupWith.
      #　cartesian(otherDataset)	When called on datasets of types T and U, returns a dataset of (T, U) pairs (all pairs of elements).
      #　pipe(command, [envVars])	Pipe each partition of the RDD through a shell command, e.g. a Perl or bash script. RDD elements are written to the process's stdin and lines output to its stdout are returned as an RDD of strings.
      #　coalesce(numPartitions)	Decrease the number of partitions in the RDD to numPartitions. Useful for running operations more efficiently after filtering down a large dataset.
      #　repartition(numPartitions)	Reshuffle the data in the RDD randomly to create either more or fewer partitions and balance it across them. This always shuffles all data over the network.
      #　repartitionAndSortWithinPartitions(partitioner)	Repartition the RDD according to the given partitioner and, within each resulting partition, sort records by their keys. This is more efficient than calling repartition and then sorting within each partition because it can push the sorting down into the shuffle machinery.
      ```

      

   4. RDD Operations: actions

      ```shell
      # collect()	Return all the elements of the dataset as an array at the driver program. This is usually useful after a filter or other operation that returns a sufficiently small subset of the data.
      scala> localFile.collect()
      res1: Array[String] = Array(...
      
      # count()	Return the number of elements in the dataset.
      scala> localFile.count()
      res2: Long = 108
      
      # first()	Return the first element of the dataset (similar to take(1)).
      scala> localFile.first()
      res6: String = # Apache Spark
      
      # take(n)	Return an array with the first n elements of the dataset.
      scala> localFile.take(5)
      res7: Array[String] = Array(# Apache Spark, "", Spark is a unified analytics engine for large-scale data processing. It provides, high-level APIs in Scala, Java, Python, and R, and an optimized engine that, supports general computation graphs for data analysis. It also supports a)
      
      # takeSample(withReplacement, num, [seed])	Return an array with a random sample of num elements of the dataset, with or without replacement, optionally pre-specifying a random number generator seed.
      scala> distData.takeSample(false, 3)
      res26: Array[Int] = Array(4, 5, 8)
      
      # takeOrdered(n, [ordering])	Return the first n elements of the RDD using either their natural order or a custom comparator.
      scala> distData.takeOrdered(3)
      res27: Array[Int] = Array(1, 2, 3)
      
      scala> distData.takeOrdered(3)(Ordering[Int].reverse)
      res28: Array[Int] = Array(10, 9, 8)
      
      # countByValue()	Only available on RDDs of type (K, V). Returns a hashmap of (K, Int) pairs with the count of each key.
      scala> distData.countByValue()
      res16: scala.collection.Map[Int,Long] = Map(5 -> 3, 10 -> 1, 1 -> 1, 6 -> 2, 9 -> 1, 2 -> 1, 7 -> 1, 3 -> 1, 8 -> 2, 4 -> 2)
      
      # foreach(func)	Run a function func on each element of the dataset. This is usually done for side effects such as updating an Accumulator or interacting with external storage systems.Note: modifying variables other than Accumulators outside of the foreach() may result in undefined behavior. See Understanding closures for more details.
      scala> distData.foreach((arg:Int) => println(arg))
      1
      2
      3
      4
      5
      6
      7
      8
      9
      10
      5
      4
      6
      8
      5
      # reduce(func)	Aggregate the elements of the dataset using a function func (which takes two arguments and returns one). The function should be commutative and associative so that it can be computed correctly in parallel.
      scala> val lineLengths = localFile.map(s => s.length)
      lineLengths: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[21] at map at <console>:25
      
      scala> lineLengths.collect()
      res24: Array[Int] = Array(14, 0, 80, 75, 73, 74, 56, 47, 0, 27, 0, 201, 189, 292, 0, 0, 23, 0, 68, 78, 56, 0, 17, 0, 63, 45, 0, 41, 0, 67, 0, 66, 77, 0, 157, 0, 26, 0, 64, 0, 21, 0, 61, 0, 50, 0, 27, 0, 66, 0, 17, 0, 70, 0, 47, 0, 19, 0, 74, 74, 0, 29, 0, 32, 0, 75, 62, 41, 73, 72, 22, 0, 54, 0, 69, 0, 16, 0, 84, 17, 0, 19, 0, 33, 110, 0, 105, 0, 31, 0, 77, 76, 77, 0, 42, 157, 84, 65, 0, 16, 0, 98, 70, 0, 15, 0, 91, 66)
      
      scala> val totalLength = lineLengths.reduce((a, b) => a + b)
      totalLength: Int = 4380
      
      # saveAsTextFile(path)	Write the elements of the dataset as a text file (or set of text files) in a given directory in the local filesystem, HDFS or any other Hadoop-supported file system. Spark will call toString on each element to convert it to a line of text in the file.
      
      # saveAsSequenceFile(path) (Java and Scala)	Write the elements of the dataset as a Hadoop SequenceFile in a given path in the local filesystem, HDFS or any other Hadoop-supported file system. This is available on RDDs of key-value pairs that implement Hadoop's Writable interface. In Scala, it is also available on types that are implicitly convertible to Writable (Spark includes conversions for basic types like Int, Double, String, etc).
      
      # saveAsObjectFile(path) (Java and Scala)	Write the elements of the dataset in a simple format using Java serialization, which can then be loaded using SparkContext.objectFile().
      ```

   5. RDD wordCount

      ```shell
      scala> sc.textFile("hdfs://localhost:9000/user/hadoop/input").flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((v1, v2) => v1 + v2).collect
      res14: Array[(String, Int)] = Array((world,3), (Map,1), (Connected,1), (Hello,4), (One,2), (dream,1), (Reduce,1), (Hadoop,1))
      
      ```

      