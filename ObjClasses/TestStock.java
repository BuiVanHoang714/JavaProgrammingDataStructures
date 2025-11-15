package ObjClasses;

public class TestStock

{
    public static void main(String[] args)

    {
        Stock s1 = new Stock("OTCL", "name");

        // Example: Assign grades based on scores

    }

}

class Stock

{
    String symbol;
    String name;

    double previousClosingPrice;
    double currentPrice;

    public Stock(String symbol, String name)

    {
        this.symbol = symbol;
        this.name = name;
    }

    public double getChangePercent() {

        return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
    }

}
