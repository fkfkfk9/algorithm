package programmers.level1;

import java.util.regex.Pattern;

public class StringCheckInt {
    public static void main(String[] args) {
        StringCheckInt sci = new StringCheckInt();

        System.out.println(sci.stringToCharArrCheckInt("a234"));
        System.out.println(sci.stringToCharArrCheckInt("1234"));
    }

    public boolean stringToCharArrCheckInt(String s) {
        return (s.length() == 4 || s.length() == 6) && Pattern.matches("^[0-9]*$", s);
    }
}
