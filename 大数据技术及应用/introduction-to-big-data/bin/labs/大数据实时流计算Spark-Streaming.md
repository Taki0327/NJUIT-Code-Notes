# 大数据实时流计算Spark Streaming

1. 参考文档：

   http://spark.apache.org/docs/latest/streaming-programming-guide.html

2. 启动nc

   ```shell
   # TERMINAL 1:
   # Running Netcat
   
   $ nc -lk 9999
   
   hello world
   ...
   ```

3. 启动Spark Streaming

   ```scala
   // TERMINAL 2: RUNNING NetworkWordCount
   // The master requires 2 cores to prevent a starvation scenario.
   [hadoop@localhost spark-3.0.2-bin-hadoop3.2]$ bin/spark-shell --master local[2]
   
   import org.apache.spark._
   import org.apache.spark.streaming._
   
   // Create a local StreamingContext with  batch interval of 5 second.
   val ssc = new StreamingContext(sc, Seconds(5))
   
   // Create a DStream that will connect to hostname:port, like localhost:9999
   val lines = ssc.socketTextStream("localhost", 9999)
   
   // Split each line into words
   val words = lines.flatMap(_.split(" "))
   
   // Count each word in each batch
   val pairs = words.map(word => (word, 1))
   val wordCounts = pairs.reduceByKey(_ + _)
   
   // Print the first ten elements of each RDD generated in this DStream to the console
   wordCounts.print()
   
   ssc.start()             // Start the computation
   ssc.awaitTermination()  // Wait for the computation to terminate
   
   ```

4. 退出

   ```shell
   :quit
   ```

5. 累计

   ```scala
   // TERMINAL 2: RUNNING NetworkWordCount
   // The master requires 2 cores to prevent a starvation scenario.
   [hadoop@localhost spark-3.0.2-bin-hadoop3.2]$ bin/spark-shell --master local[2]
   
   import org.apache.spark._
   import org.apache.spark.streaming._
   
   val ssc = new StreamingContext(sc, Seconds(5))
   ssc.checkpoint(".")
   
   // Initial state RDD for mapWithState operation
   val initialRDD = ssc.sparkContext.parallelize(List(("hello", 1), ("world", 1)))
   
   // Create a ReceiverInputDStream on target ip:port and count the
   // words in input stream of \n delimited test (e.g. generated by 'nc')
   val lines = ssc.socketTextStream("localhost", 9999)
   val words = lines.flatMap(_.split(" "))
   val wordDstream = words.map(x => (x, 1))
   
   // Update the cumulative count using mapWithState
   // This will give a DStream made of state (which is the cumulative count of the words)
   val mappingFunc = (word: String, one: Option[Int], state: State[Int]) => {
       val sum = one.getOrElse(0) + state.getOption.getOrElse(0)
       val output = (word, sum)
       state.update(sum)
       output
   }
   
   val stateDstream = wordDstream.mapWithState(
       StateSpec.function(mappingFunc).initialState(initialRDD))
   stateDstream.print()
   ssc.start()
   ssc.awaitTermination()
   
   ```

   