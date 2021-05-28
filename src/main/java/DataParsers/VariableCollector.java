package DataParsers;

import Models.Variable;

import java.util.LinkedList;

public class VariableCollector {
    private static LinkedList<Variable> list;

    public static LinkedList<Variable> getList() {
        if(list == null){
            list = new LinkedList<>();
        }
        return list;
    }
}
