package view;

import controller.TenderController;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
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
    private final static int NAME_COLUMN_SIZE = 200;
    private final static int POINT_COLUMN_SIZE = 50;
    private final static int CONDITION_COLUMN_SIZE = 170;

    private TenderController tenderController;

  public TenderTabel(TenderController tenderController) {
        super();
        this.tenderController = tenderController;
    this.initializeColumns();
        this.setEditable(true);
        ObservableList<TenderMember> list = tenderController.getTenderMemberList();
        this.setItems(list);
        tenderController.setTenderTabel(this);
    }

    private void initializeColumns(){
        TableColumn<TenderMember,Integer> indexCol = new TableColumn<TenderMember,Integer>("№");
        indexCol.setResizable(false);
        indexCol.setPrefWidth(INDEX_COLUMN_SIZE);
        indexCol.setCellValueFactory(new PropertyValueFactory<>("index"));

        TableColumn<TenderMember,String> nameCol = new TableColumn<TenderMember,String>("Название");
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

        TableColumn<TenderMember,String> priceCol = new TableColumn<TenderMember,String>("Цена");
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
               "балл");
        pricePointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(pricePointCol,"pricePoint");

        TableColumn<TenderMember,Double> priceKPointCol = new TableColumn<TenderMember,Double>(
               "уд.балл");
        priceKPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(priceKPointCol,"priceKPoint");

        TableColumn<TenderMember,String> daysCol = new TableColumn<>("Дни");
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


        TableColumn<TenderMember,Double> daysPointCol = new  TableColumn<>("балл");
        daysPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        daysPointCol.setEditable(true);
        setPointFactory(daysPointCol,"daysPoint");



        TableColumn<TenderMember,Double> daysKPointCol = new TableColumn<TenderMember,Double>(
               "уд.балл");
        daysKPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(daysKPointCol,"daysKPoint");

        TableColumn<TenderMember,String> conditionCol = new TableColumn<TenderMember,String>(
               "Условия оплаты");
        conditionCol.setPrefWidth(CONDITION_COLUMN_SIZE);
        conditionCol.setCellValueFactory(new PropertyValueFactory<TenderMember,String>(
                "condition")
        );


        TableColumn<TenderMember,Double> conditionPointCol = new TableColumn<TenderMember,Double>(
               "балл");
        conditionPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(conditionPointCol,"conditionPoint");

        TableColumn<TenderMember,Double> conditionKPointCol =
               new TableColumn<TenderMember,Double>("уд.балл");
        conditionKPointCol.setPrefWidth(POINT_COLUMN_SIZE);
        setPointFactory(conditionKPointCol,"conditionKPoint");

        TableColumn<TenderMember,Double> generalPointCol = new TableColumn<TenderMember,Double>(
               "Общий балл");
        generalPointCol.setPrefWidth(POINT_COLUMN_SIZE + 40);
        setPointFactory(generalPointCol,"generalPoint");

        this.getColumns().addAll(indexCol,nameCol,priceCol,pricePointCol,priceKPointCol,daysCol,
              daysPointCol,daysKPointCol,conditionCol,conditionPointCol,conditionKPointCol,generalPointCol);
    }

    private void setPointFactory(TableColumn pointCol, String nameCol){
      pointCol.setCellValueFactory(new PropertyValueFactory<TenderMember,Double>(
              nameCol));
    }

    public TenderMember getActiveMember(){
      return this.getSelectionModel().getSelectedItem();
    }
}
