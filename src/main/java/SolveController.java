import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SolveController implements Initializable {
    Solver solver;
    @FXML
    TextArea text1;

    @FXML
    TextArea text2;

    public void getData(Solver solver){
        this.solver=solver;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setText1(){
       text1.setText(solver.variablesToString());
    }
    public void setText2(){
        text2.setText(solver.functionToString());
    }
}
