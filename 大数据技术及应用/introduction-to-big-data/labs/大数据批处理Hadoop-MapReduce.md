# MapReduce

参考： https://hadoop.apache.org/docs/stable/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html

1. 数据准备

   ```shell
   # 启动DFS
   [hadoop@localhost hadoop-3.2.2]$ cd /home/hadoop/hadoop-3.2.2
   [hadoop@localhost hadoop-3.2.2]$ sbin/start-dfs.sh
   
   # 删除DFS上的output目录，如果output目录存在的话
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -rm -r -f output
   
   # 清空DFS上的input目录
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -rm -r -f input
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -mkdir input
   
   # 清空本地的输入输出目录
   [hadoop@localhost hadoop-3.2.2]$ rm -rf input/*
   [hadoop@localhost hadoop-3.2.2]$ rm -rf output/*
   
   # 本地input目录中，新建3个文件及内容如下
   file001：
   Hello world
   Connected world
   
   file002：
   One world
   One dream
   
   file003：
   Hello Hadoop
   Hello Map
   Hello Reduce
   
   # 查看本地输入目录内容
   [hadoop@localhost hadoop-3.2.2]$ ls input/
   file001  file002  file003
   
   [hadoop@localhost hadoop-3.2.2]$ cat input/*
   Hello world
   Connected world
   
   One world
   One dream
   
   Hello Hadoop
   Hello Map
   Hello Reduce
   
   # 上传input目录下3个文件到DFS
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -put -f input/* input/
   
   # 查看是否上传成功
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -ls input/
   Found 3 items
   -rw-r--r--   1 hadoop supergroup         29 2021-03-08 15:25 input/file001
   -rw-r--r--   1 hadoop supergroup         21 2021-03-08 15:25 input/file002
   -rw-r--r--   1 hadoop supergroup         37 2021-03-08 15:25 input/file003
   
   ```
   
   
   
2. 代码编辑

   ```java
   [hadoop@localhost hadoop-3.2.2]$ vi WordCount.java
   

   import java.io.IOException;
   import java.util.StringTokenizer;

   import org.apache.hadoop.conf.Configuration;
   import org.apache.hadoop.fs.Path;
   import org.apache.hadoop.io.IntWritable;
   import org.apache.hadoop.io.Text;
   import org.apache.hadoop.mapreduce.Job;
   import org.apache.hadoop.mapreduce.Mapper;
   import org.apache.hadoop.mapreduce.Reducer;
   import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
   import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

   public class WordCount {

     public static class TokenizerMapper
          extends Mapper<Object, Text, Text, IntWritable>{
       
       private final static IntWritable one = new IntWritable(1);
       private Text word = new Text();
       
       public void map(Object key, Text value, Context context
                       ) throws IOException, InterruptedException {
         StringTokenizer itr = new StringTokenizer(value.toString());
         while (itr.hasMoreTokens()) {
           word.set(itr.nextToken());
           context.write(word, one);
         }
       }
     }
       
     public static class IntSumReducer
          extends Reducer<Text,IntWritable,Text,IntWritable> {
       private IntWritable result = new IntWritable();
       
       public void reduce(Text key, Iterable<IntWritable> values,
                          Context context
                          ) throws IOException, InterruptedException {
         int sum = 0;
         for (IntWritable val : values) {
           sum += val.get();
         }
         result.set(sum);
         context.write(key, result);
       }
     }
       
     public static void main(String[] args) throws Exception {
       Configuration conf = new Configuration();
       Job job = Job.getInstance(conf, "word count");
       job.setJarByClass(WordCount.class);
       job.setMapperClass(TokenizerMapper.class);
       job.setCombinerClass(IntSumReducer.class);
       job.setReducerClass(IntSumReducer.class);
       job.setOutputKeyClass(Text.class);
       job.setOutputValueClass(IntWritable.class);
       FileInputFormat.addInputPath(job, new Path(args[0]));
       FileOutputFormat.setOutputPath(job, new Path(args[1]));
       System.exit(job.waitForCompletion(true) ? 0 : 1);
     }
   }
   ```
   
3. 执行

   ```shell
   # 环境变量配置 hadoop-env.sh 修改环境变量HADOOP_CLASSPATH
   [hadoop@localhost hadoop-3.2.2]$ vi etc/hadoop/hadoop-env.sh
   export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar
   
   # 编译
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop com.sun.tools.javac.Main WordCount.java
   
   # 打包
   [hadoop@localhost hadoop-3.2.2]$ jar cf wc.jar WordCount*.class
   
   # 执行
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop jar wc.jar WordCount input output
   
   # 查看结果
   [hadoop@localhost hadoop-3.2.2]$ bin/hadoop fs -cat output/*
   Connected       1
   Hadoop  1
   Hello   4
   Map     1
   One     2
   Reduce  1
   dream   1
   world   3
   
   ```

4. 练习

   以WordCount程序结果为样例，构造3个文件，形如：
   
   Connected  1
   Hadoop  1
   Hello   4
   Map     1
   One     2
   Reduce  1
   dream   1
   world   3
   
   ......
   
   
   
   分别编写MapReduce代码，计算：
   
   1. 出现次数最多的单词次数
   2. 出现次数最少的单词次数