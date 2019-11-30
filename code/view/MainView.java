package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class MainView {
    VBox mainLayout = new VBox();

    static final double STANDART_WIDTH = 250;
    static final double STANDART_HEIGHT = 350;

    private Scene scene;
    private VBox mainLayout;
    private Label product;
    private Label dateOpening;
    private Label ratios;
    private Label price;
    private Label dateDelivery;
    private Label payConditions;

    private TableView tableView;
}
