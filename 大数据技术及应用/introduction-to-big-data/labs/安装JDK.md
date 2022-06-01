# Java

1. 下载地址

   1. 下载地址： https://repo.huaweicloud.com/java/jdk/8u202-b08/jdk-8u202-linux-x64.tar.gz
   2. 主页：https://www.java.com/zh-CN/

2. 安装指导

   使用 hadoop 用户登录CentOS

   上传安装文件，到/home/hadoop目录

   ![image-20210225215010724](img/image-20210225215010724.png)

   解压安装文件

   ```shell
   $ tar -xvf jdk-8u202-linux-x64.tar.gz
   ```

   配置环境变量

   编辑hadoop用户的.bash_profile

   ```shell
   $ vi .bash_profile
   ```

   在文件末尾，添加如下内容

   ```shell
   #configuration java development enviroument
   export JAVA_HOME=/home/hadoop/jdk1.8.0_202
   export PATH=$JAVA_HOME/bin:$PATH
   export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
   ```

   使环境变量生效

   ```shell
   $ source .bash_profile
   ```

   验证java安装

   ```shell
   [hadoop@192 ~]$ java -version
   java version "1.8.0_202"
   Java(TM) SE Runtime Environment (build 1.8.0_202-b08)
   Java HotSpot(TM) 64-Bit Server VM (build 25.202-b08, mixed mode)
   
   ```

3. 编写Java HelloWorld程序，编译，执行

   ```shell
   [hadoop@localhost ~]$ vi HelloWorld.java
   
   public class HelloWorld {
       public static void main(String args[]) {
           System.out.println("HelloWorld!");
       }
   }
   
   [hadoop@localhost ~]$ javac HelloWorld.java
   [hadoop@localhost ~]$ java HelloWorld
   HelloWorld!
   
   ```

   