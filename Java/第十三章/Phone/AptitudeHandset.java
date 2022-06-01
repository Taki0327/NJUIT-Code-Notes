public class AptitudeHandset extends Handset implements Network,Theakepictures,PlayWiring{
    public void sendInfo() {
        System.out.println(this.getBrand()+this.getType()+"发信息");
    }
    public void call() {
        System.out.println(this.getBrand()+this.getType()+"打电话");
    }
    public void info() {
        System.out.println(this.getBrand()+this.getType()+"收信息");
    }
    public void netWorkConn() {
        System.out.println(this.getBrand()+this.getType()+"上网");
    }
    public void play() {
        System.out.println(this.getBrand()+this.getType()+"播放视频");
    }
    public void takePictures() {
        System.out.println(this.getBrand()+this.getType()+"照照片");
    }
    public void show(){
        this.netWorkConn();
        this.call();
        this.sendInfo();
        this.takePictures();
        this.play();
    }

    @Override
    public void takePictare() {
        // TODO Auto-generated method stub

    }

    @Override
    public void networkConn() {
        // TODO Auto-generated method stub

    }
}