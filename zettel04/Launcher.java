/** Testing {@link SeasonalCalendar}
 *
 * @author Jannik Hiller
 */
public class Launcher {
    public static void main(String[] args) {
        Product[] testProducts = { new Product("Apfel",      "111111001111", "111111111111"),
                                   new Product("Banane",     "000000000000", "111111111111"), 
                                   new Product("Erdbeere",   "000011100000", "000110000000"), 
                                   new Product("Blumenkohl", "000001111100", "111100000011"), 
                                   new Product("Feldsalat",  "100011001111", "111100001111"), 
                                   new Product("Zwiebel",    "111110011111", "001111100000") };

        System.out.println(new SeasonalCalendar(testProducts).stringify());
    }
}
