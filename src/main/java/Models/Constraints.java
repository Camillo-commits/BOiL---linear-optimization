package Models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Constraints {
    private SimpleStringProperty constraint;
    private SimpleStringProperty relation;
    private List<Integer> parameters;
    private SimpleDoubleProperty rightSide;
    private SimpleStringProperty name;

    public Constraints(){
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
        return constraint.get();
    }
    public String getRelation(){
        return relation.get();
    }
    public double getRightSide(){
        return rightSide.get();
    }
    public void setConstraint(String constraint){
        this.constraint.set(constraint);
    }
    public void setRelation(String relation){
        this.relation.set(relation);
    }
    public void setRightSide(double rightSide){
        this.rightSide.set(rightSide);
    }

    public List<Integer> getParameters() {
        return parameters;
    }

    public void setParameters(List<Integer> parameters) {
        this.parameters = parameters;
    }
    public String getName() {
        return name.get();
    }

}
