package view;

import controller.TenderController;
import javafx.beans.InvalidationListener;
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

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;

public class TenderTabel extends TableView<TenderMember> {
    private final static int INDEX_COLUMN_SIZE = 20;
    private final static int NAME_COLUMN_SIZE = 100;
    private final static int POINT_COLUMN_SIZE = 30;
    private final static int CONDITION_K_COLUMN_SIZE = 50;

  public TenderTabel(TenderController tenderController) {
        super();
    this.initializeColumns();
        this.setEditable(true);
        ObservableList<TenderMember> list = tenderController.getTenderMemberList();
        this.setItems(list);
    }

    private void initializeColumns(){
        TableColumn<TenderMember,Integer> indexCol = new TableColumn<TenderMember,Integer>("Index");
        indexCol.setResizable(false);
        indexCol.setPrefWidth(INDEX_COLUMN_SIZE);
        indexCol.setCellValueFactory(new PropertyValueFactory<>("index"));

        TableColumn<TenderMember,String> nameCol = new TableColumn<TenderMember,String>("Name");
        nameCol.setPrefWidth(NAME_COLUMN_SIZE);
        nameCol.setEditable(true);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit((TableColumn.CellEditEvent<TenderMember,String> event) -> {
          TablePosition<TenderMember,String> pos = event.getTablePosition();
          String newName = event.getNewValue();
          int row = pos.getRow();
          TenderMember member = event.getTableView().getItems().get(row);
          member.setName(newName);

        });

        TableColumn<TenderMember,String> priceCol = new TableColumn<TenderMember,String>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<TenderMember,String>("price"));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        priceCol.setEditable(true);
        priceCol.setOnEditCommit((TableColumn.CellEditEvent<TenderMember,String> event) -> {
            TablePosition<TenderMember,String> pos = event.getTablePosition();
            double newPrice = Double.parseDouble(event.getNewValue());
            int row = pos.getRow();
            TenderMember member = event.getTableView().getItems().get(row);
            member.setPrice(newPrice);
        });

        TableColumn<TenderMember,Double> pricePointCol = new TableColumn<TenderMember,Double>(
               "Price Point");
        pricePointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(pricePointCol,"pricePoint");

        TableColumn<TenderMember,Double> priceKPointCol = new TableColumn<TenderMember,Double>(
               "Price KPoint");
        priceKPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(priceKPointCol,"priceKPoint");

        TableColumn<TenderMember,String> daysCol = new TableColumn<>("Days");
        daysCol.setCellValueFactory(new PropertyValueFactory<TenderMember,String>("days"));
        daysCol.setCellFactory(TextFieldTableCell.forTableColumn());
        daysCol.setEditable(true);
        daysCol.setOnEditCommit((TableColumn.CellEditEvent<TenderMember,String> event) -> {
        TablePosition<TenderMember,String> pos = event.getTablePosition();
        int newDays = Integer.parseInt(event.getNewValue());
        int row = pos.getRow();
        TenderMember member = event.getTableView().getItems().get(row);
        member.setDays(newDays);

      });

        TableColumn<TenderMember,Double> daysPointCol = new  TableColumn<TenderMember,Double>(
               "Days Point");
        daysPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        daysPointCol.setEditable(true);
        //setPointFactory(daysPointCol,"daysPoint");
      daysPointCol.setCellValueFactory(new PropertyValueFactory<TenderMember,Double>("daysPoint"));


        TableColumn<TenderMember,Double> daysKPointCol = new TableColumn<TenderMember,Double>(
               "KPoint");
        daysKPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(daysKPointCol,"daysKPoint");

        TableColumn<TenderMember,String> conditionCol = new TableColumn<TenderMember,String>(
               "Condition");
        TableColumn<TenderMember,Integer> prePayPrecentCol =
                new TableColumn<TenderMember,Integer>("preP prec");
        TableColumn<TenderMember,Integer> prePayDaysCol =
                new TableColumn<TenderMember,Integer>("preP days");
        conditionCol.getColumns().addAll(prePayDaysCol,prePayPrecentCol);

        TableColumn<TenderMember,Double> conditionPointCol = new TableColumn<TenderMember,Double>(
               "Con po");
        conditionPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(conditionPointCol,"conditionPoint");

        TableColumn<TenderMember,Double> conditionKPointCol =
               new TableColumn<TenderMember,Double>("con poK");
        conditionKPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(conditionKPointCol,"conditionKPoint");

        TableColumn<TenderMember,Double> generalPointCol = new TableColumn<TenderMember,Double>(
               "General");
        generalPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(generalPointCol,"generalPoint");

        this.getColumns().addAll(indexCol,nameCol,priceCol,pricePointCol,priceKPointCol,daysCol,
              daysPointCol,daysKPointCol,conditionCol,conditionPointCol,conditionKPointCol,generalPointCol);

    }

    private void setPointFactory(TableColumn pointCol, String nameCol){
      pointCol.setCellValueFactory(new PropertyValueFactory<TenderMember,Double>(
              nameCol));
    }
}
