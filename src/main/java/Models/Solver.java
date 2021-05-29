package Models;

import Models.Constraints;
import Models.Functions;
import Models.Variable;
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    int variables,constraints;
    MPSolver solver;
    List<MPVariable> variablesList=new ArrayList<>();
    List<MPConstraint> constraintsList=new ArrayList<>();
    MPObjective function;

    public Solver(List<Constraints>constraintsList, Functions function, List<Variable>variablesList){
        Loader.loadNativeLibraries();
        solver = MPSolver.createSolver("GLOP");
        this.function= solver.objective();
        this.variables=variablesList.size();
        this.constraints=constraintsList.size();
        for(Variable v:variablesList){
            this.variablesList.add(solver.makeNumVar(v.getBegin(),v.getEnd(),v.getName()));
        }

        int j=0;
        for(Constraints c:constraintsList){
            int i=0;
            if(c.getRelation().equals("=")){
                this.constraintsList.add(solver.makeConstraint(c.getRightSide(),c.getRightSide(),c.getName()));
            }else if(c.getRelation().equals(">=")){
                this.constraintsList.add(solver.makeConstraint(c.getRightSide(),0,c.getName()));
            }else if (c.getRelation().equals("<=")){
                this.constraintsList.add(solver.makeConstraint(0,c.getRightSide(),c.getName()));
            }else if(c.getRelation().equals("<")){
                this.constraintsList.add(solver.makeConstraint(0,c.getRightSide()-1,c.getName()));
            }else {
                this.constraintsList.add(solver.makeConstraint(c.getRightSide()+1, 0, c.getName()));
            }
            System.out.println("Parameters "+c.getParameters().size());
            System.out.println("Variables "+this.variablesList.size());
            for(double a :c.getParameters()){
                this.constraintsList.get(j).setCoefficient(this.variablesList.get(i),a);
                i++;
            }
            j++;
        }
        int i=0;
        for(MPVariable v:this.variablesList){
            this.function.setCoefficient(v,function.getCoefficientList().get(i));
            i++;
        }
    }

    public void max(){
        function.setMaximization();
        solver.solve();
    }

    public void min(){
        function.setMinimization();
        solver.solve();
    }
    public String variablesToString(){
        String temp="";
        for(MPVariable v:variablesList){
            temp=temp+v.name() + " = "+v.solutionValue()+"\n";
        }
        return temp;
    }
    public String functionToString(){
        String temp="Wartość funkcji : ";
        temp=temp+function.value();
        return temp;
    }

}
