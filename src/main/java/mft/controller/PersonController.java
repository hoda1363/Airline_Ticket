package mft.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.extern.log4j.Log4j;
import mft.model.bl.PersonBl;
import mft.model.entity.Person;

import java.net.URL;
import java.util.ResourceBundle;

@Log4j

public class PersonController implements Initializable {
    @FXML
    private TextField idTxt, nameTxt, famillyTxt, nationalcodTxt, findAllTxt, findByFamillyTxt, findByIdTxt;
    @FXML
    private DatePicker birthDate;
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
            hashCode();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, " Person loud Error\n" + e.getMessage());
            alert.show();
        }
        newMnu.setOnAction(event -> {
            try {
                hashCode();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "new person loud error\n" + e.getMessage());
                alert.show();

            }
        });
        closeMnu.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you shure ?");
            if (alert.showAndWait().get().equals(ButtonType.OK)) {
                Platform.exit();
            }
            log.info("App Closed");

        });
        saveBtn.setOnAction(event -> {


            try {
                Person person = new Person();
                        .builder()
                        .name(nameTxt.getText())
                        .family(famillyTxt.getText())
                        .nationalid(nationalcodTxt.getText())
                        .birthdate(birthDate.getValue())
                        .build();
                PersonBl.getPersonBl().save(person);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Person Save\n" + person);
                alert.show();
                hashCode();
                log.info("Person Save " + person);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Person Save Error\n" + e.getMessage());
                alert.show();
                log.error("Person Save Error" + e.getMessage());
            }
        });
        editBtn.setOnAction(event -> {

            try {
                Person person = new Person();
                        .builder()
                        .name(nameTxt.getText())
                        .family(famillyTxt.getText())
                        .nationalid(nationalcodTxt.getText())
                        .birthdate(birthDate.getValue())
                        .build();
                PersonBl.getPersonBl().save(person);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Person Updated\n" + person);
                alert.show();
                hashCode();
                log.info("Person Updated" + person);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Person Edit Error\n" + e.getMessage());
                alert.show();
                log.error("Person Edit Error" + e.getMessage());
            }
        });
        removeBtn.setOnAction(event -> {
            try {
                PersonBl.getPersonBl().remove(Integer.parseInt(idTxt.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Person Removed\n" + idTxt.getText());
                alert.show();
                log.info("person Remove" + idTxt.getText());
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "person Remove Error\n" + e.getMessage());
                alert.show();
                log.error("Person Remove Error" + e.getMessage());
            }
        });
        findByIdTxt.setOnKeyReleased(event -> {
            try {
                showDataOnTable(PersonBl.getPersonBl().findById(Integer.parseInt(findByIdTxt.getText())));
                log.info("Find By Person Id Succeed " + Integer.parseInt((findByIdTxt.getText())));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "search Person id Error\n" + e.getMessage());
                alert.show();
                log.error("Find By Prson Id Error" + e.getMessage());
            }
        });
        findByFamillyTxt.setOnKeyReleased(event -> {
            try {
                showDataOnTble(personBl.getPersonBL().findByFamiily(findByFamillyTxt, getText()));
                log.info("Find Familly" + findByFamillyTxt.getText());
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR."Search Familly Error\n" + e.getMessage());
                alert.show();
                log.error("Find By Familly Error " + e.getMessage());
            }
        });


