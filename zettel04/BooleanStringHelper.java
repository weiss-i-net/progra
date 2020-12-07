

public class BooleanStringHelper
{

    public static boolean [] parse(String s, char c){
        boolean [] parsear = new boolean [s.length()];

        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)==c)
                parsear[i] = true;

        return  parsear;
    }

    public static String stringify (boolean [] b, char true_c, char false_c){
        StringBuilder res = new StringBuilder("");

        for (int i= 0; i<b.length;i++)
            res.append(b[i] ? true_c : false_c);

        return res.toString();

    }

    public static void main(String[] args){
        boolean [] be = BooleanStringHelper.parse("HHHHHHH", 'H');
        String test = BooleanStringHelper.stringify(new boolean []{true, false, true, false, false, true, false}, 'x', 'D');
        for(int h=0;h<2; h++){
            System.out.println(be[h]);}
        System.out.println(test);
    }

}
