import calc.Calculator;
import calc.Parser;
import calc.Translator;
import calc.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);
    static String argument1;
    static String argument2;
    static String operator;
    static int result = 0;
    static String total = "";
    static boolean isRoman = false;


    public static void main(String[] args) throws Exception {


        System.out.print("Что нужно посчитать?: ");

        String str = in.nextLine();

        //очищаем строку от пробелов
        str = str.replaceAll("\\s","");
        //закончили очищать

        Parser sourceString = new Parser(str);

        argument1 = sourceString.getFirstArg();
        argument2 = sourceString.getSecondArg();
        operator = sourceString.getOperator();

        Validator validator = new Validator();

        Translator translator = new Translator();

        if (validator.isValidate(argument1, argument2 )){
            // если прошла проверка аргументов, проверяем аргументы римские ли они
            if (validator.isRoman) {
                // тут преобразование в десятичные
                argument1 = String.valueOf(translator.toDecimals(argument1));
                argument2 = String.valueOf(translator.toDecimals(argument2));
                isRoman = true;
            }

            Calculator calc = new Calculator();
            result = calc.calculate(Integer.parseInt(argument1), Integer.parseInt(argument2), operator);

            if (isRoman){

                total = translator.toRoman(result);

            }
            else
                total = String.valueOf(result);

        }
        else throw new Error("Можно вводить либо только римские цифры от I до X, либо только арабские от 1 до 10");

        try {
            System.out.println("Итого: " + total);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        in.close();

    }
}
