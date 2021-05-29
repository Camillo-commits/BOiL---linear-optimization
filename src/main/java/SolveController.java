import DataParsers.SolverParser;
import Models.Solver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class SolveController implements Initializable {

    @FXML
    TextArea text1;

    @FXML
    TextArea text2;

    @FXML
    Button button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void setText1(){
        text1.setText(SolverParser.getSolver().variablesToString());
    }
    @FXML
    public void setText2(){
        text2.setText(SolverParser.getSolver().functionToString());
    }
    @FXML
    public void solve(){
        setText1();
        setText2();
    }
}