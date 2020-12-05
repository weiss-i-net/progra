/**
 * Helper class for converting between bool-arrays and strings.
 *
 * Created for use in {@link Product}
 *
 * @author Jannik Hiller
 */
public class BooleanStringHelper {

    public static boolean[] parse(String stringToCheck, char testChar) {
        boolean returnArray[] = new boolean[stringToCheck.length()]; // initializes to false

        for (int i = 0; i < stringToCheck.length(); ++i)
            if (stringToCheck.charAt(i) == testChar)
                returnArray[i] = true;

        return returnArray;
    }

    public static String stringify(boolean[] boolArray, char trueChar, char falseChar) {
        StringBuilder returnStringBuilder = new StringBuilder();

        for (boolean currBool : boolArray)
            returnStringBuilder.append(currBool ? trueChar : falseChar);

        return returnStringBuilder.toString();
    }
}
