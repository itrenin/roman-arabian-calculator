package calc;

public class Parser {

    public String argument1;
    public String argument2;
    public String operator = "NONE";

    public Parser(String str) {
        int counter = 0;
        String tmpString = "";

        //перебираем массив из входящей строки на наличие операнда
        for (String s : str.split("")) {
            tmpString = tmpString + s;
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                this.operator = s;
                counter++;
                this.argument1 = tmpString.replace(s,"");
                tmpString = "";
            }
        }
        // если операция одна, то получаем второй операнд
        if (counter == 1) {
            this.argument2 = tmpString;
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
