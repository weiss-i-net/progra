/** Stores {@link Product products} and creates a calendar displaying their availiblity.
 *
 * @author Jannik Hiller
 */
public class SeasonalCalendar {

    private Product[] productArray;

    public SeasonalCalendar(Product[] initProductArray) {
        productArray = initProductArray;
    }

    private int getLongestProductName() {
        int maxNameLen = 0;
        for (Product currProduct : productArray)
            if (currProduct.getName().length() > maxNameLen)
                maxNameLen = currProduct.getName().length();
        return maxNameLen;
    }

    private static String pad(String stringToPad, int padLen, char padChar) {
        return stringToPad + String.valueOf(padChar).repeat(stringToPad.length() >= padLen ?
                                                                0 :
                                                                padLen - stringToPad.length());
    }

    public String stringify() {
        final String monthChars = "JFMAMJJASOND";
        final int leftWhitespaceCount = getLongestProductName() + 2;
        final String leftPadding = " ".repeat(leftWhitespaceCount);

        StringBuilder returnStringBuilder = new StringBuilder();
        returnStringBuilder.append(leftPadding + monthChars + System.lineSeparator());

        for (Product currProduct : productArray)
            returnStringBuilder.append(pad(currProduct.getName() + ": ", leftWhitespaceCount, ' ')
                                                     + currProduct.stringifyIsRegional() + System.lineSeparator()
                                       + leftPadding + currProduct.stringifyIsImported() + System.lineSeparator());

        return returnStringBuilder.toString();
    }
}
