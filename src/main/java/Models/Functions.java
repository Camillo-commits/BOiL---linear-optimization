package Models;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Functions {
    private SimpleStringProperty function;

    //to make function model for the api and from that create String representation
    private List<Double> coefficientList;
    public Functions(String function,List<Double>coefficientList){
        this.function=new SimpleStringProperty(function);
        this.coefficientList=coefficientList;

    }
    public SimpleStringProperty functionProperty(){
        if(function == null){
            function = new SimpleStringProperty(this,"function");
        }
        return function;
    }

    public void setFunction(List<Variable> variables){
        if(this.function == null){
            this.function = new SimpleStringProperty();
        }

        String tmp = "fx=";
        if(variables.size() != 0 && coefficientList.size() != 0)
            tmp = tmp.concat(coefficientList.get(0) + " * " + variables.get(0).getName());
        for(int i = 1; i < variables.size(); ++i){
            if(coefficientList.get(i) >= 0)
                tmp = tmp.concat(" + " + coefficientList.get(i) + " * " + variables.get(i).getName());
            else
                tmp = tmp.concat(" - " + Math.abs(coefficientList.get(i)) + " * " + variables.get(i).getName());
        }
        this.function.set(tmp);
    }

    public String getFunction(){
        return function.get();
    }

    public List<Double> getCoefficientList() {
        return coefficientList;
    }

    public void setCoefficientList(List<Double> coefficientList) {
        this.coefficientList = coefficientList;
    }
}
