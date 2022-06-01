
public final class Bus extends MotoVehicle{
    private int SeatCount;
    public int getSeatCount() {
        return SeatCount;
    }

    public void setSeatCount(int seatCount) {
        SeatCount = seatCount;
    }
    public Bus(String no,String brand,int seatCount)
    {
        super(no,brand);
        this.SeatCount=seatCount;
   }
   public Bus(String brand,int seatCount)
    {
        super();
        super.setBrand(brand);
        SeatCount = seatCount;
   }
   public int CalcRent(int days)
   {
    int rent=0;
    if(SeatCount<=16)
    {
        rent=800*days;
    }
    if(SeatCount>16)
    {
        rent=1500*days;
    }
    return rent;
   }
}
