package Models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.LinkedList;
import java.util.List;

public class Constraints {
    private SimpleStringProperty constraint;
    private SimpleStringProperty relation;
    private LinkedList<Double> parameters;
    private SimpleDoubleProperty rightSide;
    private SimpleStringProperty name;

    public Constraints(){
    }
    public Constraints(String name,LinkedList<Double> parameters, String relation, Double rightSide){
        this.name = new SimpleStringProperty(name);
        this.parameters = parameters;
        this.relation = new SimpleStringProperty(relation);
        this.rightSide = new SimpleDoubleProperty(rightSide);
    }

    public Constraints(String name,LinkedList<Double> parameters, String relation, Double rightSide, LinkedList<Variable> variables){
        this.name = new SimpleStringProperty(name);
        this.parameters = parameters;
        this.relation = new SimpleStringProperty(relation);
        this.rightSide = new SimpleDoubleProperty(rightSide);
        setConstraint(variables);
    }

    public SimpleStringProperty constraintProperty(){
        if(constraint == null){
            constraint = new SimpleStringProperty(this,"constraint");
        }
        return constraint;
    }

    public SimpleStringProperty relationProperty(){
        if(relation == null){
            relation = new SimpleStringProperty(this,"relation");
        }
        return relation;
    }

    public SimpleStringProperty nameProperty(){
        if(name == null){
            name = new SimpleStringProperty(this,"name");
        }
        return name;
    }

    public SimpleDoubleProperty rightSideProperty(){
        if(rightSide == null){
            rightSide = new SimpleDoubleProperty(this,"rightSide");
        }
        return rightSide;
    }


    public String getConstraint(){
        if(constraint == null){
            constraint = new SimpleStringProperty();
        }
        return constraint.get();
    }
    public String getRelation(){
        return relation.get();
    }
    public double getRightSide(){
        return rightSide.get();
    }
    public String getName(){
        return name.get();
    }
    public void setName(String name){
        if(this.name == null){
            this.name = new SimpleStringProperty();
        }
        this.name.set(name);
    }
    public void setConstraint(String constraint){
        if(this.constraint == null){
            this.constraint = new SimpleStringProperty();
        }
        this.constraint.set(constraint);
    }
    public void setConstraint(LinkedList<Variable> variables){
        if(this.constraint == null){
            this.constraint = new SimpleStringProperty();
        }

        String tmp = "";
        if(variables.size() != 0 && parameters.size() != 0)
            tmp = parameters.get(0) + " * " + variables.get(0).getName();
        for(int i = 1; i < variables.size(); ++i){
            if(parameters.get(i) >= 0)
                tmp = tmp.concat(" + " + parameters.get(i) + " * " + variables.get(i).getName());
            else
                tmp = tmp.concat(" - " + parameters.get(i) + " * " + variables.get(i).getName());
        }
        this.constraint.set(tmp);
    }

    public void setRelation(String relation){
        if(this.relation == null){
            this.relation = new SimpleStringProperty();
        }
        this.relation.set(relation);
    }
    public void setRightSide(double rightSide){
        if(this.rightSide == null){
            this.rightSide = new SimpleDoubleProperty();
        }
        this.rightSide.set(rightSide);
    }

    public LinkedList<Double> getParameters() {
        if(parameters == null){
            parameters = new LinkedList<>();
        }
        return parameters;
    }

    public void setParameters(LinkedList<Double> parameters) {
        this.parameters = parameters;
    }
}
