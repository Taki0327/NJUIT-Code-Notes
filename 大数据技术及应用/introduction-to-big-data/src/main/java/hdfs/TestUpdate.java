package hdfs;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class TestUpdate {
    public static void main(String[] args) {
        System.setProperty("HADOOP_USER_NAME","hadoop");
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS","hdfs://192.168.124.128:9000");
            conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fs = FileSystem.get(conf);
            Path HDFSPath = new Path("/user/hadoop/testmk/WordCount.java");
            Path localPath = new Path("/D:/Code/NUIT/2021.3/大数据/introduction-to-big-data/src/main/java/WordCount.java");
            fs.copyFromLocalFile(localPath,HDFSPath);
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}