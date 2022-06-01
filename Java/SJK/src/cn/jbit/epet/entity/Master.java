package cn.jbit.epet.entity;
public class Master {
    private String id;
    private String loginid;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Master(String id, String loginid, String password) {
        this.id = id;
        this.loginid = loginid;
        this.password = password;
    }

    public Master() {
    }
}
