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
    private ArrayList<TenderMember> tenderMemberArrayList;

    public TenderController(){
        tenderMemberArrayList = new ArrayList<TenderMember>();
        tender = new Tender(tenderMemberArrayList);
    }

    public void addNewTenderMember(){
        tenderMemberArrayList.add(new TenderMember());
    }

    public ObservableList<TenderMember> getTenderMemberList(){
        return FXCollections.observableArrayList(tenderMemberArrayList);
    }


    public boolean countWinner() {
        tender.countPricePoints();
        tenderTabel.refresh();
        return true;
    }
}
