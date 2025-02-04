package edu.neu.csye7374;
import java.util.List;

public class BearMarketStrategy implements CalculateStockPriceStrategy{
    @Override
    public double calculatePrice(List<Double> bid) {

        double avg = 0.0;
        for (double b : bid) {
            avg += b;
        }
        avg = avg / bid.size() * 0.7;
        return avg;
    }
}
