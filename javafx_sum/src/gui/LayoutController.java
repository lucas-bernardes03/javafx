package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LayoutController implements Initializable {
    @FXML
    private TextField txtN1;
    @FXML
    private TextField txtN2;
    @FXML
    private Label labelResult;
    @FXML
    private Button btSum;

    public void onBtSumAction(){
        try{
        Locale.setDefault(Locale.US);
        double num1 = Double.parseDouble(txtN1.getText());
        double num2 = Double.parseDouble(txtN2.getText());
        double sum = num1 + num2;
        labelResult.setText(String.format("%.2f", sum));
        }
        catch(NumberFormatException e){
            Alerts.showAlert("ERROR", null, e.getMessage(), AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Constraints.setTextFieldDouble(txtN1);
        Constraints.setTextFieldDouble(txtN2);
        Constraints.setTextFieldMaxLength(txtN1, 12);
        Constraints.setTextFieldMaxLength(txtN2, 12);
    }
}
