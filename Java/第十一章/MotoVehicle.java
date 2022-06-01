public class MotoVehicle {
    private String no;
    private String Brand;
    private String Color;
    private double Mileage;
    public MotoVehicle(String no,String Brand)
    {
        this.no=no;
        this.Brand=Brand;
    }
    public MotoVehicle(){};
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public double getMileage() {
        return Mileage;
    }

    public void setMileage(double mileage) {
        Mileage = mileage;
    }
    public int CalcRent(int days)
    {
        return 0;
    }
}
