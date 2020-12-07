/** Launcher class for Testing {@link SeasonalCalendar}.
 *
 * @author Davide
 */
public class Launcher {
    public static void main(String args[]){
        SeasonalCalendar a = new SeasonalCalendar(new Product[] { new Product("Apfel",      "110011001100", "101010101010"),
                                                                  new Product("Banane",     "110011001100", "101010101010"),
                                                                  new Product("Kartoel",    "110011001100", "101010101010"),
                                                                  new Product("Blumenkohl", "110011001100", "101010101010") });

        System.out.println(a.stringify());
    }
}
