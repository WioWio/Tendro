package view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import model.Tender;
import model.TenderMember;

public class TenderTabel extends TableView {
    private TableColumn<TenderMember,Integer> indexCol;
    private TableColumn<TenderMember,String> nameCol;
    private TableColumn<TenderMember,Double> priceCol;
    private TableColumn<TenderMember,Double> pricePointCol;
    private TableColumn<TenderMember,Double> priceKPointCol;
    private TableColumn<TenderMember,Integer> daysCol;
    private TableColumn<TenderMember,Double> daysPointCol;
    private TableColumn<TenderMember,Double> daysKPointCol;
    private TableColumn<TenderMember,String> conditionCol;
    private TableColumn<TenderMember,Double> conditionPointCol;
    private TableColumn<TenderMember,Double> conditionKPointCol;
    private TableColumn<TenderMember,Double> generalPointCol;

    public TenderTabel() {
        super();
        indexCol = new TableColumn<Tender,Integer>("Index");
        indexCol.setResizable(false);
        indexCol.setPrefWidth(20);
        nameCol = new TableColumn<TenderMember,String>("Name");
        priceCol = new TableColumn<TenderMember,Double>("Price");
        pricePointCol = new TableColumn<TenderMember,Double>("Price Point");
        priceKPointCol = new  TableColumn<TenderMember,Double>("Price PointK");
        daysCol = new TableColumn<TenderMember,Integer>("Days");
        daysPointCol = new  TableColumn<TenderMember,Double>("Days Point");
        daysKPointCol = new TableColumn<TenderMember,Double>("KPoint");
        conditionCol = new TableColumn<TenderMember,String>("Condition");
        conditionPointCol = new TableColumn<TenderMember,Double>("Con po");
        conditionKPointCol = new TableColumn<TenderMember,Double>("con poK");
        generalPointCol = new TableColumn<TenderMember,Double>("General");

        this.getColumns().addAll(indexCol,nameCol,priceCol,pricePointCol,priceKPointCol,daysCol,
                daysPointCol,daysKPointCol,conditionCol,conditionPointCol,conditionKPointCol,generalPointCol);


    }
}
