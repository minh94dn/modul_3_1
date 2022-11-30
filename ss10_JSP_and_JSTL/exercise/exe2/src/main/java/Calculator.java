public class Calculator {
    public static double calculate(double firstOperand, double secondOperand, String operator){
        switch (operator){
            case "+":
            return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new ArithmeticException("cannot be divided by 0");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
