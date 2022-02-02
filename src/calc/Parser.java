package calc;

public class Parser {

    public String argument1;
    public String argument2;
    public String operator = "NONE";

    public Parser(String str) {
        int counter = 0;
        // 02-02-2022 убрано за ненадобностью.
        // String[] args; // временный массив для парсинга операндов

        //перебираем массив из входящей строки на наличие операнда
        for (String s : str.split("")) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                this.operator = s;
                counter++;
            }
        }
        // если операция одна, то по ней разделяем операнды на первый и второй
        if (counter == 1) {

            this.argument1 = str.split("[+-/*]")[0];
            this.argument2 = str.split("[+-/*]")[1];
        }
        if (operator.equals("NONE")) {
            throw new Error("Оператор может быть только: +, -, *, /. Введите правильный оператор");
        }
        if (counter != 1) {
            throw new Error(
                    "формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *), число операторов:  " + counter);

        }
    }
}
