package hdfs;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class TestExists {
    public static void main(String[] args) {
        System.setProperty("HADOOP_USER_NAME","hadoop");
        try {
            String filename = "input";

            Configuration conf = new Configuration();
            conf.set("fs.defaultFS","hdfs://192.168.124.128:9000");
            conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fs = FileSystem.get(conf);
            if(fs.exists(new Path(filename))){
                System.out.println("文件存在");
            }else{
                System.out.println("文件不存在");
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
