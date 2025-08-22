import java.util.*;

class Calculator {
    private double operand1;
    private double operand2;
    private char operation;
    
    // These fields are only used in complex calculations
    private double tempResult;
    private double intermediateValue;
    private boolean isComplexCalculation;
    private List<Double> calculationSteps;
    
    public Calculator() {
        this.calculationSteps = new ArrayList<>();
    }
    
    public double calculate(double a, double b, char op) {
        operand1 = a;
        operand2 = b;
        operation = op;
        
        if (op == '^') {
            // Only use these temporary fields during power operations
            isComplexCalculation = true;
            tempResult = 1;
            intermediateValue = a;
            calculationSteps.clear();
            
            for (int i = 0; i < b; i++) {
                tempResult *= intermediateValue;
                calculationSteps.add(tempResult);
            }
            return tempResult;
        } else {
            isComplexCalculation = false;
            // These fields are meaningless during simple operations
            tempResult = 0;
            intermediateValue = 0;
            calculationSteps.clear();
            
            switch (op) {
                case '+': return a + b;
                case '-': return a - b;
                case '*': return a * b;
                case '/': return a / b;
                default: return 0;
            }
        }
    }
    
    public List<Double> getCalculationSteps() {
        // This method only makes sense after complex calculations
        return new ArrayList<>(calculationSteps);
    }
    
    public double getTempResult() {
        // This field is only meaningful during complex calculations
        return tempResult;
    }
}
