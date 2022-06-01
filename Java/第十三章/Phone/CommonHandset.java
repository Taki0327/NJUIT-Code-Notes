public class CommonHandset extends Handset implements PlayWiring {
    public void sendInfo() {
        System.out.println(this.getBrand()+this.getType()+"手机发信息");
    }
    public void call() {
        System.out.println(this.getBrand()+this.getType()+"手机打电话");
    }
    public void info() {
        System.out.println(this.getBrand()+this.getType()+"手机收信息");
    }
    public void play() {
        System.out.println(this.getBrand()+this.getType()+"手机播放视频");
    }
    public void show() {
        this.call();
        this.sendInfo();
        this.play();
    }
}