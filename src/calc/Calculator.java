package calc;
public class Calculator {

    public int calculate(int a, int b, String operator){
        int result;

        switch (operator){
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
            default -> throw new Error("Оператор может быть только: +, -, *, /. Введите правильный оператор");
        }


        return result;
    }
    
}
