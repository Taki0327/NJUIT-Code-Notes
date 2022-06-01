package hdfs;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class TestMkdir {
    public static void main(String[] args) {
        System.setProperty("HADOOP_USER_NAME","hadoop");
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS","hdfs://192.168.124.128:9000");
            conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fs = FileSystem.get(conf);
            Path path = new Path("/user/hadoop/testmk");
            fs.mkdirs(path);
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}