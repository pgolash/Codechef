package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 11/01/16.
 */
public class CamelCaseToLowerCase {
    public static void main(String args[]) {
        String regex = "([a-z]+)([A-Z]+)";
        String replacement = "$1_$2";
        System.out.println("CamelCaseToSomethingElse".replaceAll(regex, replacement).toLowerCase());
    }
}