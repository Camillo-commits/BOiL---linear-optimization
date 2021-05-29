import DataParsers.ConstraintParser;
import DataParsers.FunctionParser;
import DataParsers.VariableCollector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static DataParsers.FunctionParser.getFunction;

public class NewFunctionController implements Initializable {
    @FXML
    Label variableName;
    @FXML
    TextField input;
    @FXML
    Button submit;
    private int counter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert variableName != null : "Fail to inject";
        assert input != null : "Fail to inject";
        assert submit != null : "Fail to inject";

        counter = 0;
        if(VariableCollector.getList().size() != 0) {
            variableName.setText("Variable name: " + VariableCollector.getList().get(counter).getName());
        }
    }
    @FXML
    private void submit(){
        try {
            if(counter < VariableCollector.getList().size()){
                Double variableParam = Double.valueOf(input.getText());
                getFunction().getCoefficientList().add(variableParam);
                if(counter + 1 != VariableCollector.getList().size())
                    variableName.setText("Variable name: " + VariableCollector.getList().get(counter + 1).getName());

            }
            counter++;
            if(counter == VariableCollector.getList().size()){
                getFunction().setFunction(VariableCollector.getList());
                Stage stage = (Stage) submit.getScene().getWindow();
                stage.close();
            }
            input.setText("");
        }catch (Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Data input incorrect");
            alert.showAndWait();
        }
    }
}
