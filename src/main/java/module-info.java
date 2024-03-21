module example{
    requires javafx.controls;
    requires javafx.fxml;


    opens gui to javafx.fxml;
    exports gui;
    opens logic to javafx.fxml;
    exports logic;
    exports datamodels;
}