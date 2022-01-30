package calc;
public class Calculator {

    public int calculate(int a, int b, String operator){
        int result = 0;

        switch (operator){
            case "+" : result = a + b; break;
            case "-" : result = a - b; break;
            case "*" : result = a * b; break;
            case "/" : result = a / b; break;
            default: throw new Error("Оператор может быть только: +, -, *, /. Введите правильный оператор");
        }

        return result;
    }
    
}
