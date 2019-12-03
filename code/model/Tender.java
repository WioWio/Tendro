package model;

import javafx.collections.ObservableList;

import java.util.ArrayList;


public class Tender {
    static final double BEST_POINT = 10;
    static final double WORST_POINT = 1;

    private String name;
    private String product;
    private final double kPrice=0.7;
    private final double kDays=0.3;
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
    }

    public void countDaysPoints() {
        if (tenderMembers==null) {
            return;
        }

        ArrayList<Integer> daysList = new ArrayList<Integer>();
        for (TenderMember tM:tenderMembers){
            daysList.add(Integer.parseInt(tM.getDays()));
        }
        int bestDays = daysList.get(0);
        int worstDays = bestDays;
        for (int days:daysList){
            if (days<bestDays) bestDays = days;
            if (days>worstDays) worstDays = days;
        }
        ArrayList<Double> pointsList = new ArrayList<>();
        int delta = worstDays - bestDays;
        int index=0;

        for (int days:daysList){
            if (days == bestDays) tenderMembers.get(index++).setDaysPoint(BEST_POINT);
            else if(days == worstDays) tenderMembers.get(index++).setDaysPoint(WORST_POINT);
            else {
                double point = ((worstDays - days)/delta)*10 + WORST_POINT;
                tenderMembers.get(index++).setDaysPoint(point);
            }
        }
    }

    public void countConditionPoints() {

    }

    public void countPriceK() {
        if (tenderMembers==null) {return;}
        for (TenderMember tM:tenderMembers){
            double kPoint = tM.getPricePoint() * kPrice;
            tM.setPriceKPoint(kPoint);
        }
    }

    public void countDaysK() {
        for (TenderMember tM:tenderMembers){
            tM.setDaysKPoint(tM.getDaysPoint()*kDays);
        }
    }

    public void countConditionK() {
        for (TenderMember tM:tenderMembers){
            tM.setConditionKPoint(tM.getConditionPoint()*kCondition);
        }
    }

    public void countGeneralPoints(){
        for (TenderMember tM:tenderMembers){
            tM.setGeneralPoint(tM.getPriceKPoint()+tM.getDaysKPoint()+tM.getConditionKPoint());
        }
    }
}
