package Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Variable {
    private SimpleIntegerProperty begin;
    private SimpleIntegerProperty end;
    private SimpleStringProperty name;

    public Variable(){};
    public Variable(int begin, int end, String name){
        this.begin = new SimpleIntegerProperty(begin);
        this.end = new SimpleIntegerProperty(end);
        this.name = new SimpleStringProperty(name);
    }

    public SimpleIntegerProperty beginProperty(){
        if(begin == null){
            begin = new SimpleIntegerProperty(this,"begin");
        }
        return begin;
    }

    public SimpleIntegerProperty endProperty(){
        if(end == null){
            end = new SimpleIntegerProperty(this,"end");
        }
        return end;
    }

    public SimpleStringProperty nameProperty(){
        if(name == null){
            name = new SimpleStringProperty(this,"name");
        }
        return name;
    }

    public void setBegin(int begin){
        this.begin.set(begin);
    }

    public void setEnd(int end){
        this.end.set(end);
    }

    public void setName(String name){
        this.name.set(name);
    }

    public Integer getBegin(){
        return begin.get();
    }

    public int getEnd(){
        return end.get();
    }

    public String getName(){
        return name.get();
    }
}
