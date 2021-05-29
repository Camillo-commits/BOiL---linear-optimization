package DataParsers;

import Models.Functions;

import java.util.ArrayList;
import java.util.List;

public class FunctionParser {
    private static Functions function;
    public static Functions getFunction(){
        if(function==null){
            function=new Functions("", new ArrayList<>() {
            });
        }
        return function;
    }
}
