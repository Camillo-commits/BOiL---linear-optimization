package DataParsers;


import Models.Functions;
import Models.Solver;

import java.util.ArrayList;

public class SolverParser {
    private static Solver solver;
    public static void setSolver(Solver solver){
        SolverParser.solver=solver;
    }
    public static Solver getSolver(){
        return solver;
    }
}
