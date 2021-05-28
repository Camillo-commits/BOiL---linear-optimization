package Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Variable {
    private SimpleDoubleProperty begin;
    private SimpleDoubleProperty end;
    private SimpleStringProperty name;

    public Variable(){};
    public Variable(int begin, int end, String name){
        this.begin = new SimpleDoubleProperty(begin);
        this.end = new SimpleDoubleProperty(end);
        this.name = new SimpleStringProperty(name);
    }

    public SimpleDoubleProperty beginProperty(){
        if(begin == null){
            begin = new SimpleDoubleProperty(this,"begin");
        }
        return begin;
    }

    public SimpleDoubleProperty endProperty(){
        if(end == null){
            end = new SimpleDoubleProperty(this,"end");
        }
        return end;
    }

    public SimpleStringProperty nameProperty(){
        if(name == null){
            name = new SimpleStringProperty(this,"name");
        }
        return name;
    }

    public void setBegin(double begin){
        this.begin.set(begin);
    }

    public void setEnd(double end){
        this.end.set(end);
    }

    public void setName(String name){
        this.name.set(name);
    }

    public Double getBegin(){
        return begin.get();
    }

    public Double getEnd(){
        return end.get();
    }

    public String getName(){
        return name.get();
    }
}
