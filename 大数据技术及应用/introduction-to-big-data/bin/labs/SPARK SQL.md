# SPARK SQL

1. 参考文档：

   http://spark.apache.org/docs/latest/sql-programming-guide.html

2. Datasets and DataFrames

   A Dataset is a distributed collection of data. 

   A DataFrame is a *Dataset* organized into named columns.

   In the Scala API, DataFrame is simply a type alias of Dataset[Row]

3. Creating DataFrames

   ```scala
   [hadoop@localhost spark-3.0.2-bin-hadoop3.2]$ cat examples/src/main/resources/people.json
   {"name":"Michael"}
   {"name":"Andy", "age":30}
   {"name":"Justin", "age":19}
   
   val df = spark.read.json("examples/src/main/resources/people.json")
   
   // Displays the content of the DataFrame to stdout
   df.show()
   // +----+-------+
   // | age|   name|
   // +----+-------+
   // |null|Michael|
   // |  30|   Andy|
   // |  19| Justin|
   // +----+-------+
   ```

   

4. Untyped Dataset Operations

   ```scala
   // This import is needed to use the $-notation
   import spark.implicits._
   // Print the schema in a tree format
   df.printSchema()
   // root
   // |-- age: long (nullable = true)
   // |-- name: string (nullable = true)
   
   // Select only the "name" column
   df.select("name").show()
   // +-------+
   // |   name|
   // +-------+
   // |Michael|
   // |   Andy|
   // | Justin|
   // +-------+
   
   // Select everybody, but increment the age by 1
   df.select($"name", $"age" + 1).show()
   // +-------+---------+
   // |   name|(age + 1)|
   // +-------+---------+
   // |Michael|     null|
   // |   Andy|       31|
   // | Justin|       20|
   // +-------+---------+
   
   // Select people older than 21
   df.filter($"age" > 21).show()
   // +---+----+
   // |age|name|
   // +---+----+
   // | 30|Andy|
   // +---+----+
   
   // Count people by age
   df.groupBy("age").count().show()
   // +----+-----+
   // | age|count|
   // +----+-----+
   // |  19|    1|
   // |null|    1|
   // |  30|    1|
   // +----+-----+
   ```

5. Running SQL Queries Programmatically

   ```scala
   // Register the DataFrame as a SQL temporary view
   df.createOrReplaceTempView("people")
   
   val sqlDF = spark.sql("SELECT * FROM people")
   sqlDF.show()
   // +----+-------+
   // | age|   name|
   // +----+-------+
   // |null|Michael|
   // |  30|   Andy|
   // |  19| Justin|
   // +----+-------+
   ```

6. Global Temporary View

   ```scala
   // Register the DataFrame as a global temporary view
   df.createGlobalTempView("people")
   
   // Global temporary view is tied to a system preserved database `global_temp`
   spark.sql("SELECT * FROM global_temp.people").show()
   // +----+-------+
   // | age|   name|
   // +----+-------+
   // |null|Michael|
   // |  30|   Andy|
   // |  19| Justin|
   // +----+-------+
   
   // Global temporary view is cross-session
   spark.newSession().sql("SELECT * FROM global_temp.people").show()
   // +----+-------+
   // | age|   name|
   // +----+-------+
   // |null|Michael|
   // |  30|   Andy|
   // |  19| Justin|
   // +----+-------+
   ```

7. Creating Datasets

   ```scala
   case class Person(name: String, age: Long)
   
   // Encoders are created for case classes
   val caseClassDS = Seq(Person("Andy", 32)).toDS()
   caseClassDS.show()
   // +----+---+
   // |name|age|
   // +----+---+
   // |Andy| 32|
   // +----+---+
   
   // Encoders for most common types are automatically provided by importing spark.implicits._
   val primitiveDS = Seq(1, 2, 3).toDS()
   primitiveDS.map(_ + 1).collect() // Returns: Array(2, 3, 4)
   
   // DataFrames can be converted to a Dataset by providing a class. Mapping will be done by name
   val path = "examples/src/main/resources/people.json"
   val peopleDS = spark.read.json(path).as[Person]
   peopleDS.show()
   // +----+-------+
   // | age|   name|
   // +----+-------+
   // |null|Michael|
   // |  30|   Andy|
   // |  19| Justin|
   // +----+-------+
   ```

8. Inferring the Schema Using Reflection

   ```scala
   [hadoop@localhost spark-3.0.2-bin-hadoop3.2]$ cat examples/src/main/resources/people.txt
   Michael, 29
   Andy, 30
   Justin, 19
   
   // For implicit conversions from RDDs to DataFrames
   import spark.implicits._
   
   // Create an RDD of Person objects from a text file, convert it to a Dataframe
   val peopleDF = spark.sparkContext.textFile("examples/src/main/resources/people.txt").map(_.split(",")).map(attributes => Person(attributes(0), attributes(1).trim.toInt)).toDF()
   
   // Register the DataFrame as a temporary view
   peopleDF.createOrReplaceTempView("people")
   
   // SQL statements can be run by using the sql methods provided by Spark
   val teenagersDF = spark.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19")
   teenagersDF.show()
   // +------+---+
   // |  name|age|
   // +------+---+
   // |Justin| 19|
   // +------+---+
   
   // The columns of a row in the result can be accessed by field index
   teenagersDF.map(teenager => "Name: " + teenager(0)).show()
   // +------------+
   // |       value|
   // +------------+
   // |Name: Justin|
   // +------------+
   
   // or by field name
   teenagersDF.map(teenager => "Name: " + teenager.getAs[String]("name")).show()
   // +------------+
   // |       value|
   // +------------+
   // |Name: Justin|
   // +------------+
   
   ```

   

9. Programmatically Specifying the Schema

   ```scala
   import org.apache.spark.sql.Row
   
   import org.apache.spark.sql.types._
   
   // Create an RDD
   val peopleRDD = spark.sparkContext.textFile("examples/src/main/resources/people.txt")
   
   // The schema is encoded in a string
   val schemaString = "name age"
   
   // Generate the schema based on the string of schema
   val fields = schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, nullable = true))
   val schema = StructType(fields)
   
   // Convert records of the RDD (people) to Rows
   val rowRDD = peopleRDD.map(_.split(",")).map(attributes => Row(attributes(0), attributes(1).trim))
   
   // Apply the schema to the RDD
   val peopleDF = spark.createDataFrame(rowRDD, schema)
   
   // Creates a temporary view using the DataFrame
   peopleDF.createOrReplaceTempView("people")
   
   // SQL can be run over a temporary view created using DataFrames
   val results = spark.sql("SELECT name FROM people")
   results.show()
   // The results of SQL queries are DataFrames and support all the normal RDD operations
   // The columns of a row in the result can be accessed by field index or by field name
   results.map(attributes => "Name: " + attributes(0)).show()
   // +-------------+
   // |        value|
   // +-------------+
   // |Name: Michael|
   // |   Name: Andy|
   // | Name: Justin|
   // +-------------+
   ```

10. wordCount

    ```shell
    # 读取HDFS文件到RDD
    scala> val hdfsFile = sc.textFile("hdfs://localhost:9000/user/hadoop/input")
hdfsFile: org.apache.spark.rdd.RDD[String] = hdfs://localhost:9000/user/hadoop/input MapPartitionsRDD[1] at textFile at <console>:24
    
    scala> hdfsFile.collect
    res0: Array[String] = Array(Hello world, Connected world, One world, One dream, Hello Hadoop, Hello Map, Hello Reduce)
    
    # flatMap 拍平
    scala> val hdfsFileFlatMap = hdfsFile.flatMap(_.split(" "))
    hdfsFileFlatMap: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[4] at flatMap at <console>:25
    
    scala> hdfsFileFlatMap.collect
    res10: Array[String] = Array(Hello, world, Connected, world, One, world, One, dream, Hello, Hadoop, Hello, Map, Hello, Reduce)
    
    # RDD转换为DataFrame
    scala> val hdfsFileDF = hdfsFileFlatMap.toDF()
    hdfsFileDF: org.apache.spark.sql.DataFrame = [value: string]
    
    scala> hdfsFileDF.show()
    +---------+
    |    value|
    +---------+
    |    Hello|
    |    world|
    |Connected|
    |    world|
    |      One|
    |    world|
    |      One|
    |    dream|
    |    Hello|
    |   Hadoop|
    |    Hello|
    |      Map|
    |    Hello|
    |   Reduce|
    +---------+
    
    # 创建TempView
    scala> hdfsFileDF.createOrReplaceTempView("wordcount")
    
    # 查询TempView所有记录
    scala> val sqlDF = spark.sql("SELECT * FROM wordcount")
    sqlDF: org.apache.spark.sql.DataFrame = [value: string]
    
    scala> sqlDF.show
    +---------+
    |    value|
    +---------+
    |    Hello|
    |    world|
    |Connected|
    |    world|
    |      One|
    |    world|
    |      One|
    |    dream|
    |    Hello|
    |   Hadoop|
    |    Hello|
    |      Map|
    |    Hello|
    |   Reduce|
    +---------+
    
    # 使用SparkSQL计算wordcount
    scala> val wordcountDF = spark.sql("select value,count(*) count from wordcount group by value order by count desc")
    wordcountDF: org.apache.spark.sql.DataFrame = [value: string, count: bigint]
    
    scala> wordcountDF.show
    +---------+-----+
    |    value|count|
    +---------+-----+
    |    Hello|    4|
    |    world|    3|
    |      One|    2|
    |    dream|    1|
    |   Reduce|    1|
    |   Hadoop|    1|
    |      Map|    1|
    |Connected|    1|
    +---------+-----+
    
    ```
    
    

