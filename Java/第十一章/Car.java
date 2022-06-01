public final class Car extends MotoVehicle{
    private String Type;
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    public Car(String no,String brand,String type)
    {
        super(no,brand);
        this.Type=type;
   }
   public Car(String type,String no)
   {
        super();
        super.setNo(no);
        this.Type=type;
   }
   public int CalcRent(int days)
   {
       int rent=0;
       if(Type.equals("别克商务"))
       {
           rent=600*days;
       }
       if(Type.equals("宝马550i"))
       {
           rent=500*days;
       }
       if(Type.equals("别克林荫大道"))
       {
           rent=300*days;
       }
       return rent;
   }
}
