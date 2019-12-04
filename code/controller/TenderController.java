package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Tender;
import model.TenderMember;
import view.PayConditionSelector;
import view.RatiosInput;
import view.TenderTabel;

import java.util.ArrayList;
import java.util.Timer;

public class TenderController {
  private Tender tender;
  private TenderTabel tenderTabel;
  private ObservableList<TenderMember> tenderMemberList;
  private Timer timer;

  public TenderController() {
    tenderMemberList = FXCollections.observableArrayList();
    tender = new Tender(tenderMemberList);
    timer = new Timer(true);
  }

  public void setTenderTabel(TenderTabel tenderTabel) { this.tenderTabel = tenderTabel; }

  public void addNewTenderMember() {
    tenderMemberList.add(new TenderMember());
  }

  public ObservableList<TenderMember> getTenderMemberList() {
    return tenderMemberList;
  }

  public void setProductName(String name){
    tender.setName(name);
  }

  public void setRatio(RatiosInput ratiosInput) {
    tender.setkPrice(ratiosInput.getPriceK());
    tender.setkDays(ratiosInput.getDaysK());
    tender.setkCondition(ratiosInput.getConditionK());
  }

  public TenderMember getWinner1(){
    return tender.getWinner1();
  }

  public TenderMember getWinner2(){
    return tender.getWinner2();
  }

  public void countWinner() {
    tender.countDaysPoints();
    tender.countPricePoints();
    tender.countConditionPoints();
    tender.countPriceK();
    tender.countDaysK();
    tender.countConditionK();
    tender.countGeneralPoints();
    tender.countWinners();
  }

  public void conditionEdit() {
    TenderMember activeMember = tenderTabel.getActiveMember();
    if (activeMember == null) return;
    new PayConditionSelector(activeMember.getName(),
            activeMember.getPayCondition());
  }
}
