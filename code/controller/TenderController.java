package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Tender;
import model.TenderMember;
import view.TenderTabel;

import java.util.ArrayList;

public class TenderController {
    private Tender tender;
    private TenderTabel tenderTabel;
    private ObservableList<TenderMember> tenderMemberList;

    public TenderController(){
        tenderMemberList = FXCollections.observableArrayList();
        tender = new Tender(tenderMemberList);
    }

    public void addNewTenderMember(){
        tenderMemberList.add(new TenderMember());
    }

    public ObservableList<TenderMember> getTenderMemberList(){
        return tenderMemberList;
    }


    public void countWinner() {
      tender.countDaysPoints();
        tender.countPricePoints();
        tender.countPriceK();
        tender.countDaysK();
        tender.countGeneralPoints();
    }

}
