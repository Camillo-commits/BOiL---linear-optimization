package Models;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Functions {
    private SimpleStringProperty function;

    //to make function model for the api and from that create String representation
    private List<Integer> coefficientList;

    public SimpleStringProperty functionProperty(){
        if(function == null){
            function = new SimpleStringProperty(this,"function");
        }
        return function;
    }

    public void setFunction(String function){
        this.function.set(function);
    }

    public String getFunction(){
        return function.get();
    }

    public List<Integer> getCoefficientList() {
        return coefficientList;
    }

    public void setCoefficientList(List<Integer> coefficientList) {
        this.coefficientList = coefficientList;
    }
}
