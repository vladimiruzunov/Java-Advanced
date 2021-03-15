import java.util.function.Predicate;

public class MyStrings {
    public static Predicate<String> startWithUppercase
        = str -> str != null && !str.isEmpty()
            &&
           Character.isUpperCase(str.charAt(0));

}
