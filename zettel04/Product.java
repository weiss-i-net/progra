
public class Product
{
    private String name;
    private boolean [] av_regional;
    private boolean [] av_import;

    public Product(String n, boolean[]r, boolean[]i){
        name = n;
        av_regional= r;
        av_import = i;
    }

    public Product(String new_n, String m_regional, String m_import){
        this(new_n, BooleanStringHelper.parse(m_regional, '1'), BooleanStringHelper.parse(m_import, '1'));
    }

    public String getName(){
        return name;
    }

    public String stringifyIsRegional() {
        return BooleanStringHelper.stringify(av_regional, 'R', ' ');
    }

    public String stringifyIsImported() {
        return BooleanStringHelper.stringify(av_import, 'I', ' ');
    }
}
