import DataParsers.ConstraintParser;
import DataParsers.VariableCollector;
import Models.Constraints;
import Models.Variable;
import com.google.ortools.constraintsolver.Constraint;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ParameterInputController implements Initializable {
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
                ConstraintParser.getConstraints().getParameters().add(counter,variableParam);
                if(counter + 1 != VariableCollector.getList().size())
                    variableName.setText("Variable name: " + VariableCollector.getList().get(counter + 1).getName());
            }
            counter++;
            if(counter == VariableCollector.getList().size()){
                variableName.setText("Constraint name: ");
            }
            else if(counter == VariableCollector.getList().size() + 1){
                ConstraintParser.getConstraints().setName(input.getText());
                variableName.setText("Relation: ( available relations: =, <, <=,>,>= )");
            }
            else if(counter == VariableCollector.getList().size() + 2){
                ConstraintParser.getConstraints().setRelation(input.getText());
                variableName.setText("Add right side of the equation");
            }
            else if(counter == VariableCollector.getList().size() + 3){
                ConstraintParser.getConstraints().setRightSide(Double.valueOf(input.getText()));
                Stage stage = (Stage) submit.getScene().getWindow();
                stage.close();
            }
        }catch (Exception e){
            ConstraintParser.getConstraints().setName("");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Data input incorrect");
            alert.showAndWait();
        }
    }
}
