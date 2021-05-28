import DataParsers.VariableParser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewVariableController implements Initializable {
    @FXML
    TextField from;
    @FXML
    TextField to;
    @FXML
    TextField name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert from != null : "Fail to inject";
        assert to != null : "Fail to inject";
        assert name != null : "Fail to inject";


    }

    @FXML
    private void submit(){
        try {
            Double begin = Double.valueOf(from.getText());
            Double end = Double.valueOf(to.getText());
            String nameString = name.getText();
            if (begin == null || end == null || nameString == null || begin > end || nameString.equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Data input incorrect");
                alert.showAndWait();
            } else {
                VariableParser.getVariable().setBegin(begin);
                VariableParser.getVariable().setEnd(end);
                VariableParser.getVariable().setName(nameString);
                Stage stage = (Stage) name.getScene().getWindow();
                stage.close();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Data input incorrect");

            alert.showAndWait();
        }
    }
    @FXML
    private void cancel(){
        VariableParser.getVariable().setName(null);

        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
    }
}
