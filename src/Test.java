import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        //String argument1;
        //String argument2;
        //String operator;

        String str = in.nextLine();
        TestParser tp = new TestParser(str);

        System.out.println("first arg is: " + tp.argument1);
        System.out.println("second arg is: " + tp.argument2);
        System.out.println("operator is: " + tp.operator);

        in.close();

    }

}

class TestParser{

    public String argument1;
    public String argument2;
    public String operator = "NONE";

    TestParser(String str) {
        int counter = 0;
        String[] args; // временный массив для парсинга операндов

        //перебираем массив из входящей строки на наличие операнда
        for (String s : str.split("")) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                this.operator = s;
                counter++;
            }
        }
        // если операция одна, то по ней разделяем операнды на первый и второй
        if (counter == 1) {

            args = str.split("[+-/*]");
            this.argument1 = args[0];
            this.argument2 = args[1];
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
