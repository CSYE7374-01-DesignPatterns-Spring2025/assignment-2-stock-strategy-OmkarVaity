package edu.neu.csye7374;
import java.util.List;

public class BearMarketStrategyEagerSingleton implements CalculateStockPriceStrategy{

    private static BearMarketStrategyEagerSingleton instance = new BearMarketStrategyEagerSingleton();
    private BearMarketStrategyEagerSingleton() {

    }

    public static BearMarketStrategyEagerSingleton getInstance() {
        return instance;
    }
    @Override
    public double calculatePrice(List<Double> bid) {
        double avg = 0.0;
        for(double p : bid) {
            avg+= p;
        }
        avg = avg/bid.size() * 0.7;
        return avg;
    }
}
