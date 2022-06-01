

public class E92 {
    public static void main(String[] args) {
        Stock stock=new Stock("0RCL","Oracle Corporation",34.5,34.35);
        System.out.println("市值变化的百分比是:"+stock.getChangePercent()*100+"%");
    }
}
class Stock{
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;
    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice)
    {
        this.symbol=symbol;
        this.name=name;
        this.currentPrice=currentPrice;
        this.previousClosingPrice=previousClosingPrice;
    }
    public double getChangePercent()
    {
        return (currentPrice-previousClosingPrice)/previousClosingPrice;
    }
}