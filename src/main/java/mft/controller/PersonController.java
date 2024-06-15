package mft.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.extern.log4j.Log4j;

import java.net.URL;
import java.util.ResourceBundle;

@Log4j

public class PersonController implements Initializable {
    @FXML
    private TextField idTxt,nameTxt,famillyTxt,nationalcodTxt,findAllTxt,findByFamillyTxt,findByIdTxt;
    @FXML
    private DatePicker birthDatepeaker;
    @FXML
    private Button saveBtn,editBtn,removeBtn;
    @FXML
    private MenuItem closeMnu,newMnu;
    @FXML
    TableView personTbl;
    @FXML
    TableColumn idCol,nameCol,famillyCol,nationalcodCol;
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
