package hdfs;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
public class TestCreate {
    public static void main(String[] args) {
        System.setProperty("HADOOP_USER_NAME","hadoop");
        try {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS","hdfs://192.168.124.128:9000");
            conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fs = FileSystem.get(conf);
            byte[] buff = "HDFS-JAVA-CREATE".getBytes(); // 要写入的内容
            String filename = "/user/hadoop/testInput/TestFile4"; //要写入的文件名
            FSDataOutputStream os = fs.create(new Path(filename));
            os.write(buff,0,buff.length);
            System.out.println("Create:"+ filename);
            os.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}