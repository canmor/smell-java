class Calculator {
private:
    double operand1;
    double operand2;
    char operation;
    
    // 这些字段只在复杂计算时使用
    double tempResult;
    double intermediateValue;
    bool isComplexCalculation;
    std::vector<double> calculationSteps;
    
public:
    double calculate(double a, double b, char op) {
        operand1 = a;
        operand2 = b;
        operation = op;
        
        if (op == '^') {
            // 只有在幂运算时才使用这些临时字段
            isComplexCalculation = true;
            tempResult = 1;
            intermediateValue = a;
            calculationSteps.clear();
            
            for (int i = 0; i < b; i++) {
                tempResult *= intermediateValue;
                calculationSteps.push_back(tempResult);
            }
            return tempResult;
        } else {
            isComplexCalculation = false;
            // 简单运算时这些字段都没有意义
            tempResult = 0;
            intermediateValue = 0;
            calculationSteps.clear();
            
            if (op == '+') return a + b;
            if (op == '-') return a - b;
            if (op == '*') return a * b;
            if (op == '/') return a / b;
            return 0;
        }
    }
};
