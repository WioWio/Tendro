package model;

import java.util.ArrayList;

public class Tender {
    static final double BEST_POINT = 10;
    static final double WORST_POINT = 1;

    private String name;
    private String product;
    private double kPrice;
    private double kDays;
    private double kCondition;
    private ArrayList<TenderMember> tenderMembers;
    private TenderMember winner1;
    private TenderMember winner2;

    public ArrayList<Double> countPricePoints() {
        ArrayList<Double> priceList = new ArrayList<>();
        for (TenderMember tM:tenderMembers){
            priceList.add(tM.getPrice());
        }
        double bestPrice = priceList.get(0);
        double worstPrice = bestPrice;
        for (double price:priceList){
            if (price<bestPrice) bestPrice = price;
            if (price>worstPrice) worstPrice = price;
        }
        ArrayList<Double> pointsList = new ArrayList<>();
        double delta = worstPrice - bestPrice;

        for (double price:priceList){
            if (price == bestPrice) pointsList.add(BEST_POINT);
            else if(price == worstPrice) pointsList.add(WORST_POINT);
            else {
                double point = ((worstPrice - price)/delta)*10 + WORST_POINT;
                pointsList.add(point);
            }
        }

        return pointsList;
    }

    public void countDaysPoints() {

    }

    public void countConditionPoints() {

    }

    public void countPriceK() {

    }

    public void countDaysK() {

    }

    public void countConditionK() {

    }
}
