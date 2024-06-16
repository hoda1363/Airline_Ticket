package mft.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.extern.log4j.Log4j;
import mft.model.entity.Person;

import java.net.URL;
import java.util.ResourceBundle;

@Log4j

public class PersonController implements Initializable {
    @FXML
    private TextField idTxt, nameTxt, famillyTxt, nationalcodTxt, findAllTxt, findByFamillyTxt, findByIdTxt;
    @FXML
    private DatePicker birthDatepeaker;
    @FXML
    private Button saveBtn, editBtn, removeBtn;
    @FXML
    private MenuItem closeMnu, newMnu;
    @FXML
    TableView personTbl;
    @FXML
    TableColumn idCol, nameCol, famillyCol, nationalcodCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("Person windows start");
        try {
            resetForm();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    " Person loud Error\n" + e.getMessage());
            alert.show();
        }
        newMnu.setOnAction(event -> {
            try {
                resetForm();
            } catch (Exception e) {
                Alert alert = new
                        Alert(Alert . AlertType.ERROR,"new person loud error\n" + e.getMessage());
                alert.show();

            }
        });
closeMnu.setOnAction(event -> {
    Alert alert = new
            Alert(Alert.AlertType.CONFIRMATION, "Are you shure ?");
    if (alert.showAndWait().get().equals(ButtonType.OK)) {
        Platform.exit();
    }
log . info("App Closed");

});
saveBtn . setOnAction(event -> {
}
    })