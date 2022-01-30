import calc.Calculator;
import calc.Parser;
import calc.Translator;
import calc.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);
    static Map <String, String> state = new HashMap<>();
    static String argument1;
    static String argument2;
    static int result = 0;

    public static void main(String[] args) throws Exception {


        System.out.print("Что нужно посчитать?: ");

        String str = in.nextLine();

        //очищаем строку от пробелов
        str = str.replaceAll("\\s","");
        //закончили очищать

        Parser sourceString = new Parser(str);

        // для тестов
        /*
        System.out.println("first arg is: " + sourceString.getFirstArg());
        System.out.println("second arg is: " + sourceString.getSecondArg());
        System.out.println("operator is: " + sourceString.getOperator());
         */

        state.put("argument1", sourceString.getFirstArg());
        state.put("argument2", sourceString.getSecondArg());
        state.put("operator", sourceString.getOperator());

        Validator validator = new Validator();

        argument1 = state.get("argument1");
        argument2 = state.get("argument2");

        Translator translator = new Translator();

        if (validator.isValidate(argument1, argument2 )){
            // если прошла проверка аргументов, проверяем аргументы римские ли они
            if (validator.isRoman) {
                // тут преобразование в десятичные
                argument1 = String.valueOf(translator.toDecimals(argument1));
                argument2 = String.valueOf(translator.toDecimals(argument2));
                state.put("isRoman", "true");
            }

            Calculator calc = new Calculator();
            result = calc.calculate(Integer.parseInt(argument1), Integer.parseInt(argument2), state.get("operator"));

            if (state.containsKey("isRoman")){
                state.put("result", translator.toRoman(result));

            }
            else
                state.put("result", String.valueOf(result));

        }
        else throw new Error("Можно вводить либо только римские цифры от I до X, либо только арабские от 1 до 10");

        try {
            System.out.println("Итого: " + state.get("result"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        in.close();

    }
}
