import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

public class MainFormController {
    public TableView<CustomerTM> tblCustomer;
    public TableColumn<CustomerTM,String> colNic;
    public TableColumn<CustomerTM,String> colName;
    public TableColumn<CustomerTM,String> colAddress;
    public TableColumn<CustomerTM,Double> colSalary;
    public TableColumn<CustomerTM, Button> colDelete;

    public void initialize() {
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadData();

    }

    ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();

    private void loadData(){
        observableList.clear();
        for (Customer c : Database.customerDataList) {
            Button btn = new Button("Delete");
            observableList.add(new CustomerTM(c.getNic(), c.getName(), c.getAddress(), c.getSalary(), btn));

            btn.setOnAction((event -> {
                Alert conf = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = conf.showAndWait();
                if(buttonType.get()==ButtonType.YES){
                    Database.customerDataList.remove(c);
                    loadData();
                }

            }));
        }

        tblCustomer.setItems(observableList);

        // Set custom cell factory for the Delete Button column
        colDelete.setCellFactory(column -> new TableCell<CustomerTM, Button>() {
            @Override
            protected void updateItem(Button button, boolean empty) {
                super.updateItem(button, empty);
                if (empty || button == null) {
                    setGraphic(null);
                } else {
                    // Create a StackPane to center the button
                    StackPane stackPane = new StackPane(button);
                    stackPane.setAlignment(javafx.geometry.Pos.CENTER);
                    setGraphic(stackPane);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                }
            }
        });
    }

}
