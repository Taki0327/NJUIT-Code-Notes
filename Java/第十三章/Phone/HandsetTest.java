public class HandsetTest {
    public static void main(String[] args) {
       Handset h1=new CommonHandset();
       h1.setBrand("华为");
       h1.setType("mate40pro");
       h1.show();
       Handset h2=new AptitudeHandset();
       h2.setBrand("诺基亚");
       h2.setType("7110");
       h2.show();
    }
}
