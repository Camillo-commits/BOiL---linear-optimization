import DataParsers.ConstraintParser;
import DataParsers.VariableCollector;
import DataParsers.VariableParser;
import Models.Constraints;
import Models.Functions;
import Models.Variable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
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

    private LinkedList<Variable> variableLinkedList = new LinkedList<>();
    private LinkedList<Constraints> constraintsLinkedList = new LinkedList<>();

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

    @FXML
    private void addVariable() throws IOException {
       Scene scene = new Scene(App.loadFXML("NewVariableWindow"));
       Stage stage = new Stage();

       stage.setScene(scene);
       stage.setResizable(false);
       //stage.setAlwaysOnTop(true);
       stage.showAndWait();
       if(VariableParser.getVariable().getName() != null){
           variableObservableList.add(new Variable(
                   VariableParser.getVariable().getBegin(),
                   VariableParser.getVariable().getEnd(),
                   VariableParser.getVariable().getName()
                   ));
           variableLinkedList.add(new Variable(
                   VariableParser.getVariable().getBegin(),
                   VariableParser.getVariable().getEnd(),
                   VariableParser.getVariable().getName()
           ));
       }
    }
    @FXML
    private void addConstraint() throws IOException {
        VariableCollector.getList().clear();
        VariableCollector.getList().addAll(variableLinkedList);
        Scene scene = new Scene(App.loadFXML("ParameterInputWindow"));
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.showAndWait();
        if(!ConstraintParser.getConstraints().getName().equals("")){
            constraintObservableList.add(new Constraints(
                    ConstraintParser.getConstraints().getName(),
                    ConstraintParser.getConstraints().getParameters(),
                    ConstraintParser.getConstraints().getRelation(),
                    ConstraintParser.getConstraints().getRightSide(),
                    VariableCollector.getList()
            ));
            constraintsLinkedList.add(new Constraints(
                    ConstraintParser.getConstraints().getName(),
                    ConstraintParser.getConstraints().getParameters(),
                    ConstraintParser.getConstraints().getRelation(),
                    ConstraintParser.getConstraints().getRightSide(),
                    VariableCollector.getList()
            ));

        }
    }
    @FXML
    private void addFunction(){

    }
    @FXML
    private void clearVariables(){

    }
    @FXML
    private void clearConstraints(){

    }
    @FXML
    private void clearFunctions(){

    }
    @FXML
    private void solveMinimization() throws IOException {
        Solver solver=new Solver(constraintObservableList,functionsObservableList.get(0),variableObservableList);
        solver.min();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SolveWindow.fxml"));
        Parent root =loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        SolveController cntr = loader.getController();
        cntr.getData(solver);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.showAndWait();

    }
    @FXML
    private void solveMaximization() throws IOException {

        Solver solver=new Solver(constraintObservableList,functionsObservableList.get(0),variableObservableList);
        solver.max();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SolveWindow.fxml"));
        Parent root =loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        SolveController cntr = loader.getController();
        cntr.getData(solver);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.showAndWait();
    }

}
