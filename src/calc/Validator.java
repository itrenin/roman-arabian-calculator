package calc;

public class Validator {
    public boolean isRoman = false;

    private static boolean isDecimals(String s){

        try {
            int i = Integer.parseInt(s.trim());
            if (i < 1 || i > 10) return false;
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    };

    private static boolean isRomans(String s){
        return switch (s.toUpperCase()) {
            case "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" -> true;
            default -> false;
        };

    };

    public boolean isValidate (String firstArg, String secondArg){
        if (isDecimals(firstArg) && isDecimals(secondArg)) return true;
        else if (isRomans(firstArg) && isRomans(secondArg)) {
            isRoman = true;
            return true;
        }
        else return false;
    }
}
