package DataParsers;

import Models.Constraints;

public class ConstraintParser {
    private static Constraints constraints;
    public static Constraints getConstraints(){
        if(constraints == null){
            constraints = new Constraints();
        }
        return constraints;
    }
}
