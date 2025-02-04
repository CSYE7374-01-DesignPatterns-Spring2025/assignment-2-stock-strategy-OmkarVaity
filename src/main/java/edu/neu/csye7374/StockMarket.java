package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;

    private List<StockAPI> stocks = new ArrayList<>();

    private StockMarket(){
        instance = null;
    }
    private static List<Double> bidList = new ArrayList<>();
    public static StockMarket getInstance(){
        if(instance == null){
            instance = new StockMarket();
        }
        return instance;
    }

    public StockAPI getStockItem(String name, double price, String description){
        return new StockAPI(name, price, description);
    }

    public void add(StockAPI stock){
        stocks.add(stock);
    }

    public void remove(StockAPI s){
        boolean removed = this.stocks.remove(s);

        if(!removed) {
            System.out.println("Stock not found");
        }
    }

    public void displayStocks(){
        for(StockAPI s : this.stocks){
            System.out.println(s.toString());
        }
    }

    public void updatePrice(StockAPI s, double price){
        if(this.stocks.contains(s)){
            s.setPrice(price);
            return;
        }
        System.out.println("Stock not found");
    }

    public static void demo(){
        System.out.println("");

        BearMarketStrategy bearMarketStrategy = new BearMarketStrategy();
        BullMarketStrategyLazySingleton bullMarketStrategyLazySingleton = BullMarketStrategyLazySingleton.getInstance();

//        GoogleStock googleStock = new GoogleStock(80);
//        MetaStock metaStock = new MetaStock(110);

//        StockMarket.getInstance().add(googleStock);
//        StockMarket.getInstance().add(metaStock);

        /*
         *
         * Stock Strategy Assignment
         */
        StockAPI metaStock1 = new MetaStockFactory().getObject(90.0);
        StockAPI googleStock1 = new GoogleStockFactory().getObject(80.0);
        StockMarket.getInstance().add(metaStock1);
        StockMarket.getInstance().add(googleStock1);
        System.out.println("\nStock Strategy demo...");
        System.out.println("\nBearish...");
        bidList.add(10.0);
        bidList.add(20.0);
        bidList.add(14.0);
        bidList.add(18.0);
        metaStock1.setBid(bidList, bearMarketStrategy);
        bidList.clear();
        bidList.add(15.0);
        bidList.add(35.0);
        bidList.add(55.0);
        bidList.add(47.0);
        googleStock1.setBid(bidList, bearMarketStrategy);

        StockMarket.getInstance().displayStocks();
        bidList.clear();
        System.out.println("\nBullish...");
        bidList.add(25.0);
        bidList.add(37.0);
        bidList.add(65.0);
        bidList.add(56.0);
        metaStock1.setBid(bidList, bullMarketStrategyLazySingleton);
        bidList.clear();
        bidList.add(60.0);
        bidList.add(80.0);
        bidList.add(74.0);
        bidList.add(65.0);
        googleStock1.setBid(bidList, bullMarketStrategyLazySingleton);
        StockMarket.getInstance().displayStocks();
        bidList.clear();

        /*
        googleStock.setBid(10);

        googleStock.setBid(40);

        googleStock.setBid(50);

        googleStock.setBid(60);

        googleStock.setBid(70);

        googleStock.setBid(75);

        googleStock.getMetric();

        //Meta Stocks//
        metaStock.setBid(80);

        metaStock.setBid(90);

        metaStock.setBid(100);

        metaStock.setBid(110);

        metaStock.setBid(120);

        metaStock.setBid(130);

        metaStock.getMetric();

        StockMarket.getInstance().displayStocks(); */


        /* Lazy and Eager Factory Pattern */
        System.out.println("\nLazy and Eager Factory demo...");
        StockAPI googleStock = MetaStockFactoryLazy.getInstance().getObject(80.00);
        StockAPI metaStock = GoogleStockFactoryEager.getInstance().getObject(90.00);

        StockMarket.getInstance().add(googleStock);
        StockMarket.getInstance().add(metaStock);

        googleStock.setBid(15);

        googleStock.setBid(30);

        googleStock.setBid(45);

        googleStock.setBid(60);

        googleStock.setBid(75);

        googleStock.setBid(90);

        googleStock.setBid(105);

        metaStock.setBid(85);

        metaStock.setBid(95);

        metaStock.setBid(105);

        metaStock.setBid(115);

        metaStock.setBid(125);

        metaStock.setBid(135);

        metaStock.getMetric();
        StockMarket.getInstance().displayStocks();

        /*  Factory Pattern */
        StockAPI googleStock2 = new GoogleStockFactory().getObject(80.00);
        StockAPI metaStock2 = new MetaStockFactory().getObject(90.00);

        StockMarket.getInstance().add(googleStock2);
        StockMarket.getInstance().add(metaStock2);

        googleStock2.setBid(15);

        googleStock2.setBid(30);

        googleStock2.setBid(45);

        googleStock2.setBid(60);

        googleStock2.setBid(75);

        googleStock2.setBid(90);

        googleStock2.setBid(105);

        metaStock2.setBid(85);

        metaStock2.setBid(95);

        metaStock2.setBid(105);

        metaStock2.setBid(115);

        metaStock2.setBid(125);

        metaStock2.setBid(135);

        metaStock2.getMetric();
        StockMarket.getInstance().displayStocks();


    }
}
