/**
 * Stores seasonal availibilty of a grocery product.
 *
 * Created for use in {@link SeasonalCalendar}
 *
 * @author Jannik Hiller
 */
public class Product {

    private String productName;
    private boolean[] regionalAvailibilty;
    private boolean[] importAvailibilty;

    public Product(String initName, boolean[] initLocalAvailibilty, boolean[] initImportAvailibilty) {
        productName = initName;
        regionalAvailibilty = initLocalAvailibilty;
        importAvailibilty = initImportAvailibilty;
    }

    public Product(String initName, String initLocalAvailibilty, String initImportAvailibilty) {
        this(initName,
             BooleanStringHelper.parse(initLocalAvailibilty, '1'),
             BooleanStringHelper.parse(initImportAvailibilty, '1'));
    }

    public String getName() {
        return productName;
    }

    public String stringifyIsRegional() {
        return BooleanStringHelper.stringify(regionalAvailibilty, 'R', ' ');
    }

    public String stringifyIsImported() {
        return BooleanStringHelper.stringify(importAvailibilty, 'I', ' ');
    }
}
