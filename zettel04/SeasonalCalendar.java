public class SeasonalCalendar
{
    private Product [] infoproducts;

    public SeasonalCalendar(Product [] ip){
        infoproducts = ip;
    }

    public int getLongestProductName(){
        String s_temp;
        Product p_temp;
        int [] infword_length = new int [infoproducts.length];
        int inkrfor = 0;
        int tempresult=0;
        int result = 0;

        for(int i = 0; i<infoproducts.length; i++ ){
            p_temp = infoproducts[i];               // save Product in p_temp
            s_temp= p_temp.getName();                    // get name of product and save (String)
            infword_length[i] = s_temp.length();    // get length and save

            if(inkrfor>0){                                              // vergl. vorherige mit jetzige Stelle 
                if(infword_length[i]>infword_length[i-1])
                    tempresult = infword_length[i];
                tempresult = infword_length[i-1];
            }
            if (tempresult>result)                                    // temporärer speicher mit speicher vergl.
                result = tempresult;
            inkrfor++;
        }
        return result;
    }

    public static String pad (String s, int i, char c){

        StringBuilder builder = new StringBuilder(s);

        if (s.length() >= i )
            return s;

        for(int j=0; j < i - s.length(); j++)
            builder.append(c);
        return builder.toString();
    }

    public String stringify(){
        StringBuilder calendar = new StringBuilder();
        int anzahlleerz = getLongestProductName()+2;

        calendar.append(" ".repeat(anzahlleerz));
        calendar.append("JFMAMJJASOND" + System.lineSeparator());

        for(int k = 0; k<infoproducts.length; k++)
            calendar.append(SeasonalCalendar.pad(infoproducts[k].getName() + ": ", anzahlleerz, ' ')
                                                      + infoproducts[k].stringifyIsRegional() + System.lineSeparator()
                            + " ".repeat(anzahlleerz) + infoproducts[k].stringifyIsImported() + System.lineSeparator());

        return calendar.toString();
    }

}
