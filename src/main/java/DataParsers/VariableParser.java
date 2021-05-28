package DataParsers;

import Models.Variable;

public class VariableParser {
    public static Variable variable;

    public static Variable getVariable() {
        if(variable == null){
            variable = new Variable();
        }
        return variable;
    }


}
