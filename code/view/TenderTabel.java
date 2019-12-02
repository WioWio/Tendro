package view;

import controller.TenderController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Tender;
import model.TenderMember;

import java.util.ArrayList;

public class TenderTabel extends TableView {
    final static int INDEX_COLUMN_SIZE = 20;
    final static int NAME_COLUMN_SIZE = 100;
    final static int POINT_COLUMN_SIZE = 30;
    final static int CONDITION_K_COLUMN_SIZE = 50;

    TenderController tenderController;
    ObservableList<TenderMember> list;
    //private TableColumn<TenderMember,Integer> indexCol;
    private TableColumn<TenderMember,String> nameCol;
    private TableColumn<TenderMember,String> priceCol;
    private TableColumn<TenderMember,Double> pricePointCol;
    private TableColumn<TenderMember,Double> priceKPointCol;
    private TableColumn<TenderMember,Integer> daysCol;
    private TableColumn<TenderMember,Double> daysPointCol;
    private TableColumn<TenderMember,Double> daysKPointCol;
    private TableColumn<TenderMember,String> conditionCol;
    private TableColumn<TenderMember,Double> conditionPointCol;
    private TableColumn<TenderMember,Double> conditionKPointCol;
    private TableColumn<TenderMember,Double> generalPointCol;

    public TenderTabel(TenderController tenderController) {
        super();
        this.tenderController = tenderController;
        this.initializeColumns();
        this.setEditable(true);


    }

    private void initializeColumns(){
        TableColumn<TenderMember,Integer> indexCol = new TableColumn<TenderMember,Integer>("Index");
        indexCol.setResizable(false);
        indexCol.setPrefWidth(INDEX_COLUMN_SIZE);
        nameCol = new TableColumn<TenderMember,String>("Name");
        nameCol.setPrefWidth(NAME_COLUMN_SIZE);
        nameCol.setEditable(true);
        priceCol = new TableColumn<TenderMember,String>("Price");

        priceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        priceCol.setEditable(true);
        priceCol.setOnEditCommit((TableColumn.CellEditEvent<TenderMember,String> event) -> {
            TablePosition<TenderMember,String> pos = event.getTablePosition();
            double newPrice = Double.parseDouble(event.getNewValue());
            int row = pos.getRow();
            TenderMember member = event.getTableView().getItems().get(row);
            member.setPrice(newPrice);
        });

        pricePointCol = new TableColumn<TenderMember,Double>("Price Point");
        pricePointCol.setPrefWidth(POINT_COLUMN_SIZE);
        priceKPointCol = new  TableColumn<TenderMember,Double>("Price PointK");
        daysCol = new TableColumn<TenderMember,Integer>("Days");
        daysPointCol = new  TableColumn<TenderMember,Double>("Days Point");
        daysKPointCol = new TableColumn<TenderMember,Double>("KPoint");
        conditionCol = new TableColumn<TenderMember,String>("Condition");
        TableColumn<TenderMember,Integer> prePayPrecentCol =
                new TableColumn<TenderMember,Integer>("preP prec");
        TableColumn<TenderMember,Integer> prePayDaysCol =
                new TableColumn<TenderMember,Integer>("preP days");
        conditionCol.getColumns().addAll(prePayDaysCol,prePayPrecentCol);
        conditionPointCol = new TableColumn<TenderMember,Double>("Con po");
        conditionKPointCol = new TableColumn<TenderMember,Double>("con poK");
        generalPointCol = new TableColumn<TenderMember,Double>("General");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        indexCol.setCellValueFactory(new PropertyValueFactory<>("index"));
        //priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        pricePointCol.setCellValueFactory(new PropertyValueFactory<>("pricePoint"));

        this.getColumns().addAll(indexCol,nameCol,priceCol,pricePointCol,priceKPointCol,daysCol,
                daysPointCol,daysKPointCol,conditionCol,conditionPointCol,conditionKPointCol,generalPointCol);

        refresh();
    }

    public void refresh(){
        list = tenderController.getTenderMemberList();
        this.setItems(list);
    }

}
