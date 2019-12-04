package model;

import javafx.collections.ObservableList;
import view.TenderTabel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class Tender {
  private static final double BEST_POINT = 10.0;
  private static final double WORST_POINT = 1.0;
  private static final double REFINANCING_STATE_NATIONAL_BANK = 0.9;

  private Calendar openingTime;
  private String name="unnamed";
  private String product;
  private double kPrice=0;
  private double kDays=0;
  private double kCondition=0;
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
  public TenderMember getWinner1() { return this.winner1; }
  public TenderMember getWinner2() {return this.winner2; }

  public void countPricePoints() {


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
        double point = ((worstPrice - price) / delta) * 9.0 + WORST_POINT;
        tenderMembers.get(index++).setPricePoint(point);
      }
    }
  }

  public void countDaysPoints() {
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
    double delta = worstDays - bestDays;
    int index = 0;

    for (int days : daysList) {
      if (days == bestDays) tenderMembers.get(index++).setDaysPoint(BEST_POINT);
      else if (days == worstDays) tenderMembers.get(index++).setDaysPoint(WORST_POINT);
      else {
        double point = (((double)(worstDays - days) / delta) * 9.0) + WORST_POINT;
        tenderMembers.get(index++).setDaysPoint(point);
      }
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

  public void countWinners(){
    double bestPoint = tenderMembers.get(0).getGeneralPoint();
    TenderMember winner1 = tenderMembers.get(0);
    TenderMember winner2= null;
    for (TenderMember tM:tenderMembers){
      if (tM.getGeneralPoint()>bestPoint) {
        bestPoint = tM.getGeneralPoint();
        winner1 = tM;
      }
    }
    if (tenderMembers.size()>1){
      if (tenderMembers.get(0).equals(winner1)){
        winner2 = tenderMembers.get(1);
        bestPoint = winner2.getGeneralPoint();
      } else{
        winner2 = tenderMembers.get(0);
        bestPoint = winner2.getGeneralPoint();
      }
      for (TenderMember tM:tenderMembers){
        if (!tM.equals(winner1) && tM.getGeneralPoint()>bestPoint) {
          winner2 = tM;
          bestPoint = tM.getGeneralPoint();
        }
      }
    }

    this.winner1 = winner1;
    this.winner2 = winner2;
  }
}
