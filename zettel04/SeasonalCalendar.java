

public class SeasonalCalendar
{
    public Product [] infoproducts;
    
   
    
    public SeasonalCalendar(Product [] ip){
        infoproducts = ip;
    }
    
    public static int getLongestProductName(Product [] infoproducts){
    String s_temp;
    Product p_temp;
    int [] infword_length = new int [infoproducts.length];
    int inkrfor = 0;
    int tempresult=0;
    int result = 0;
    
    for(int i = 0; i<infoproducts.length; i++ ){
    
        p_temp = infoproducts[i];               // save Product in p_temp
        
        s_temp= p_temp.name;                    // get name of product and save (String)
        
        infword_length[i] = s_temp.length();    // get length and save
        
        if(inkrfor>0){                                              // vergl. vorherige mit jetzige Stelle 
            if(infword_length[i]>infword_length[i-1]){
                tempresult = infword_length[i];
            }
            tempresult = infword_length[i-1];
        }   
        if (tempresult>result){                                         // temporärer speicher mit speicher vergl.
        result = tempresult;
        }
        inkrfor++;
    }
    return result;
    
    }
    
    public static String pad (String s, int i, char c){
        
        String [] str_a_temp = s.split("");
        StringBuilder builder = new StringBuilder(s);
        
        if (str_a_temp.length <= i ){
        return s;
        }
        
        for(int j=0; j < i - str_a_temp.length; j++){
        builder.append(c);
        }
        String resstr = builder.toString();
        return resstr;
    }
    
    public String stringify(Product [] infoproducts){
    StringBuilder calendar = new StringBuilder();
    int anzahlleerz = SeasonalCalendar.getLongestProductName(infoproducts)+2;
    String [] prodnames = new String [infoproducts.length];
    
    Product tempprod;
    
    
    calendar.append(SeasonalCalendar.pad("", anzahlleerz, ' '));   
    calendar.append("JFMAMJJASOND \n");
    
    for(int k = 0; k<infoproducts.length; k++){
    
        tempprod = infoproducts[k];
        prodnames [k] = SeasonalCalendar.pad(tempprod.name + ": ", anzahlleerz, ' ');
        calendar.append(prodnames[k]);
        
        
        tempprod.stringifyIsRegional();
        
        
        
        
        
    }
    
    
    
    }
    
}
