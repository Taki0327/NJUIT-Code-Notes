class BankCard {
    public BankCard(String id, String password, double banlance) {
        this.id = id;
        this.password = password;
        this.banlance = banlance;
    }

    private String id;
    private String password;
    private double banlance;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }

    public void withdraw(double money) {
        if (banlance >= money)
            banlance = banlance - money;
        else
            System.out.println("余额不足");
    }

    public void save(double money) {
        banlance = banlance + money;
    }

}
