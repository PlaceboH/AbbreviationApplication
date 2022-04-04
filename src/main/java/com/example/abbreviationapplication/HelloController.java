package com.example.abbreviationapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.abbreviationlibrary.AbbreviationLibrary;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    AbbreviationLibrary myAbb;
    @FXML
    private TextArea inputText;
    @FXML
    private TextFlow outputText;
    @FXML
    private TextArea listInput;

    @FXML
    private CheckBox rozw;
    @FXML
    private CheckBox zw;

    @FXML
    public void changeText(MouseEvent mouseEvent) {
        Text text = new Text();

        outputText.getChildren().clear();
        if(zw.isSelected()){
            text.setText(myAbb.keyWordSearch(inputText.getText().toString()));
        }
        else{
            text.setText(myAbb.abbreviationSearch(inputText.getText().toString()));
        }
        outputText.getChildren().add(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myAbb = new AbbreviationLibrary();
    }

    public void setRozwiniecie(ActionEvent actionEvent) {
        zw.setSelected(false);
    }

    public void setZwiniecie(ActionEvent actionEvent) {
        rozw.setSelected(false);
    }

    public void setListAbb(MouseEvent mouseEvent) {
        HashMap<String, String> abbListMap = new HashMap<>();
        String[] abbList = listInput.getText().split("\\n+");
        for (String s : abbList){
            String abb[] = s.split(" ", 2);
            abbListMap.put(abb[0], abb[1]);
        }
        myAbb.setAbbMap(abbListMap);
    }
}