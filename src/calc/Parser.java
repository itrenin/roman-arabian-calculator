package calc;

public class Parser {
    private final String sourceString;
    private String firstArg;
    private String secondArg;
    private static String operator = "NONE";
    private static int counter = 0;

    public Parser(String inputString) {
        this.sourceString = inputString;
        String[] sourceArr = inputString.split("");
        inputParser(sourceArr, inputString);

    }

    // парсим входящую строку на операнды и операцию
    void inputParser(String[] array, String str) {


        String[] args; // временный массив для парсинга операндов

        for (String s : array) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                operator = s;
                counter++;
            }
        }
        // если операция одна, то по ней разделяем операнды на первый и второй
        if (counter == 1) {

            args = str.split("[+-/*]");
            this.firstArg = args[0];
            this.secondArg = args[1];
        }
        if (operator.equals("NONE")) {
            throw new Error("Оператор может быть только: +, -, *, /. Введите правильный оператор");
        }
        if (counter != 1) {
            throw new Error(
                    "формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *), число операторов:  " + counter);

        }
    }

    public String getFirstArg() {
        return firstArg;
    }
    public String getSecondArg() {
        return secondArg;
    }
    public String getOperator() {
        return operator;
    }

}
