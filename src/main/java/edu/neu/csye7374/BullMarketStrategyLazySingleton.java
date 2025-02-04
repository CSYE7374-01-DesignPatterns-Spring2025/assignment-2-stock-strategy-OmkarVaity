package edu.neu.csye7374;
import java.util.List;

public class BullMarketStrategyLazySingleton implements CalculateStockPriceStrategy {

    private static BullMarketStrategyLazySingleton instance = null;

    private BullMarketStrategyLazySingleton() {

    }
    public static BullMarketStrategyLazySingleton getInstance() {
        if(instance == null) {
            instance = new BullMarketStrategyLazySingleton();
        }
        return instance;

    }
    @Override
    public double calculatePrice(List<Double> bid) {

        double avg = 0.0;
        for(double b : bid) {
            avg+= b;
        }
        avg = avg/bid.size() * 1.3;
        return avg;
    }
}
