package model;

import javafx.collections.ObservableList;

import java.util.ArrayList;


public class Tender {
    static final double BEST_POINT = 10;
    static final double WORST_POINT = 1;

    private String name;
    private String product;
    private double kPrice;
    private double kDays;
    private double kCondition;
    private ObservableList<TenderMember> tenderMembers;
    private TenderMember winner1;
    private TenderMember winner2;

    public Tender(ObservableList<TenderMember> tenderMembers){
        this.tenderMembers = tenderMembers;
    }

    public void countPricePoints() {
        if (tenderMembers==null) {
            System.out.print("no thing to count");
            return;
        }

        ArrayList<Double> priceList = new ArrayList<Double>();
        for (TenderMember tM:tenderMembers){
            priceList.add(Double.parseDouble(tM.getPrice()));
        }
        double bestPrice = priceList.get(0);
        double worstPrice = bestPrice;
        for (double price:priceList){
            if (price<bestPrice) bestPrice = price;
            if (price>worstPrice) worstPrice = price;
        }
        ArrayList<Double> pointsList = new ArrayList<>();
        double delta = worstPrice - bestPrice;
        int index=0;

        for (double price:priceList){
            if (price == bestPrice) tenderMembers.get(index++).setPricePoint(BEST_POINT);
            else if(price == worstPrice) tenderMembers.get(index++).setPricePoint(WORST_POINT);
            else {
                double point = ((worstPrice - price)/delta)*10 + WORST_POINT;
                tenderMembers.get(index++).setPricePoint(point);
            }
        }
        for (TenderMember tM:tenderMembers){
            System.out.print(tM.getPricePoint());

        }

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
