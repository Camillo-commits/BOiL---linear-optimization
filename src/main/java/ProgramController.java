import Models.Constraints;
import Models.Functions;
import Models.Variable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;


public class ProgramController implements Initializable {
    @FXML
    MenuItem addVariable;
    @FXML
    MenuItem addConstraint;
    @FXML
    MenuItem addFunction;

    @FXML
    MenuItem clearVariables;
    @FXML
    MenuItem clearConstraints;
    @FXML
    MenuItem clearFunctions;

    @FXML
    MenuItem solveMinimization;
    @FXML
    MenuItem solveMaximization;

    @FXML
    TableView<Variable> variableTableView;
    @FXML
    TableColumn<Variable,String> beginColumn;
    @FXML
    TableColumn<Variable,String> endColumn;
    @FXML
    TableColumn<Variable,String> nameColumn;

    @FXML
    TableView<Constraints> constraintsTableView;
    @FXML
    TableColumn<Constraints,String> constraintNameColumn;
    @FXML
    TableColumn<Constraints,String> constraintColumn;
    @FXML
    TableColumn<Constraints,String> relationColumn;
    @FXML
    TableColumn<Constraints,String> rightSideColumn;

    @FXML
    TableView<Functions> functionsTableView;
    @FXML
    TableColumn<Functions,String> functionColumn;

    //add rest column objects and create valueFactories for them

    //

    private ObservableList<Variable> variableObservableList =  FXCollections.observableArrayList();
    private ObservableList<Constraints> constraintObservableList =  FXCollections.observableArrayList();
    private ObservableList<Functions> functionsObservableList =  FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert addVariable != null : "Fail to inject";
        assert addConstraint != null : "Fail to inject";
        assert addFunction != null : "Fail to inject";

        assert clearVariables != null : "Fail to inject";
        assert clearConstraints != null : "Fail to inject";
        assert clearFunctions != null : "Fail to inject";

        assert solveMinimization != null : "Fail to inject";
        assert solveMaximization != null : "Fail to inject";

        assert variableTableView != null : "Fail to inject";
        assert beginColumn != null : "Fail to inject";
        assert endColumn != null : "Fail to inject";
        assert nameColumn != null : "Fail to inject";

        assert constraintsTableView != null : "Fail to inject";
        assert constraintNameColumn != null : "Fail to inject";
        assert constraintColumn != null : "Fail to inject";
        assert relationColumn != null : "Fail to inject";
        assert rightSideColumn != null : "Fail to inject";

        assert functionsTableView != null : "Fail to inject";
        assert functionColumn != null : "Fail to inject";

        setCellValueFactories();
        variableTableView.setItems(variableObservableList);
        constraintsTableView.setItems(constraintObservableList);
        functionsTableView.setItems(functionsObservableList);
    }

    private void setCellValueFactories(){
        beginColumn.setCellValueFactory(cvf -> new SimpleStringProperty(String.valueOf(cvf.getValue().getBegin())));
        endColumn.setCellValueFactory(cvf -> new SimpleStringProperty(String.valueOf(cvf.getValue().getEnd())));
        nameColumn.setCellValueFactory(cvf -> new SimpleStringProperty(cvf.getValue().getName()));

        constraintNameColumn.setCellValueFactory(cvf -> new SimpleStringProperty(cvf.getValue().getName()));
        constraintColumn.setCellValueFactory(cvf -> new SimpleStringProperty(cvf.getValue().getConstraint()));
        relationColumn.setCellValueFactory(cvf -> new SimpleStringProperty(cvf.getValue().getRelation()));
        rightSideColumn.setCellValueFactory(cvf -> new SimpleStringProperty(String.valueOf(cvf.getValue().getRightSide())));

        functionColumn.setCellValueFactory(cvf -> new SimpleStringProperty(cvf.getValue().getFunction()));
    }
}
