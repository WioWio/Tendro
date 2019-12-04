package model;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class Tender {
  private static final double BEST_POINT = 10;
  private static final double WORST_POINT = 1;
  private static final double REFINANCING_STATE_NATIONAL_BANK = 0.9;

  private Calendar openingTime;
  private String name="unnamed";
  private String product;
  private double kPrice;
  private double kDays;
  private double kCondition;
  private ObservableList<TenderMember> tenderMembers;
  private TenderMember winner1;
  private TenderMember winner2;

  public Tender(ObservableList<TenderMember> tenderMembers) {
    this.tenderMembers = tenderMembers;
  }

  public void setkPrice(double kPrice){ this.kPrice = kPrice; }
  public void setkDays(double kDays) { this.kDays = kDays; }
  public void setkCondition(double kCondition) { this.kCondition = kCondition; }
  public void setName(String name) { this.name=name; }

  public void countPricePoints() {
    if (tenderMembers == null) {
      System.out.print("nothing to count");
      return;
    }

    ArrayList<Double> priceList = new ArrayList<Double>();
    for (TenderMember tM : tenderMembers) {
      priceList.add(Double.parseDouble(tM.getPrice()));
    }
    double bestPrice = priceList.get(0);
    double worstPrice = bestPrice;
    for (double price : priceList) {
      if (price < bestPrice) bestPrice = price;
      if (price > worstPrice) worstPrice = price;
    }
    ArrayList<Double> pointsList = new ArrayList<>();
    double delta = worstPrice - bestPrice;
    int index = 0;

    for (double price : priceList) {
      if (price == bestPrice) tenderMembers.get(index++).setPricePoint(BEST_POINT);
      else if (price == worstPrice) tenderMembers.get(index++).setPricePoint(WORST_POINT);
      else {
        double point = ((worstPrice - price) / delta) * 9 + WORST_POINT;
        tenderMembers.get(index++).setPricePoint(point);
      }
    }
  }

  public void countDaysPoints() {
    if (tenderMembers == null) {
      return;
    }

    ArrayList<Integer> daysList = new ArrayList<Integer>();
    for (TenderMember tM : tenderMembers) {
      daysList.add(Integer.parseInt(tM.getDays()));
    }
    int bestDays = daysList.get(0);
    int worstDays = bestDays;
    for (int days : daysList) {
      if (days < bestDays) bestDays = days;
      if (days > worstDays) worstDays = days;
    }
    ArrayList<Double> pointsList = new ArrayList<>();
    int delta = worstDays - bestDays;
    int index = 0;

    for (int days : daysList) {
      if (days == bestDays) tenderMembers.get(index++).setDaysPoint(BEST_POINT);
      else if (days == worstDays) tenderMembers.get(index++).setDaysPoint(WORST_POINT);
      else {
        double point = ((worstDays - days) / delta) * 9 + WORST_POINT;
        tenderMembers.get(index++).setDaysPoint(point);
      }
      System.out.print(tenderMembers.get(index - 1).getDaysPoint());
    }
  }

  public void countConditionPoints() {
    ArrayList<Double> conditionPriceList = new ArrayList();
    for (TenderMember tM : tenderMembers) {
      double prePayPrice =
              Double.parseDouble(tM.getPrice()) * tM.getPayCondition().getPrePayPrecent()
                      * REFINANCING_STATE_NATIONAL_BANK * tM.getPayCondition().getPrePayDays();
      double factPayPrice =
              Double.parseDouble(tM.getPrice()) * tM.getPayCondition().getFactPayPrecent()
                      * REFINANCING_STATE_NATIONAL_BANK * tM.getPayCondition().getFactPayDays();
      conditionPriceList.add(factPayPrice-prePayPrice);
    }

    double bestPrice = conditionPriceList.get(0);
    double worstPrice = bestPrice;
    for (double price : conditionPriceList) {
      if (price > bestPrice) bestPrice = price;
      if (price < worstPrice) worstPrice = price;
    }
    ArrayList<Double> pointsList = new ArrayList<>();
    double delta = bestPrice - worstPrice;
    int index = 0;

    for (double price : conditionPriceList) {
      if (price == bestPrice) tenderMembers.get(index++).setConditionPoint(BEST_POINT);
      else if (price == worstPrice) tenderMembers.get(index++).setConditionPoint(WORST_POINT);
      else {
        double point = ((price - worstPrice) / delta) * 9 + WORST_POINT;
        tenderMembers.get(index++).setConditionPoint(point);
      }
    }
  }

  public void countPriceK() {
    if (tenderMembers == null) {
      return;
    }
    for (int i = 0; i < tenderMembers.size(); i++) {
      tenderMembers.get(i).setPriceKPoint(tenderMembers.get(i).getPricePoint() * kPrice);
    }
  }

  public void countDaysK() {
    for (TenderMember tM : tenderMembers) {
      tM.setDaysKPoint(tM.getDaysPoint() * kDays);
    }
  }

  public void countConditionK() {
    for (TenderMember tM : tenderMembers) {
      tM.setConditionKPoint(tM.getConditionPoint() * kCondition);
    }
  }

  public void countGeneralPoints() {
    for (TenderMember tM : tenderMembers) {
      tM.setGeneralPoint(tM.getPriceKPoint() + tM.getDaysKPoint() + tM.getConditionKPoint());
    }
  }
}
