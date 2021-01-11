
public class Launcher <K, V>
{

    private static void putEntries(WritableMap<String,Integer> wmap){
        wmap.put("sizeInMB", 42);
        wmap.put("version", 4);
        wmap.put("yearOfRelease", 2015);

    }

    private static void printEntries (ReadableMap<String, Integer> rmap){
        
        try{
        for (String key: rmap.keysAsSet())
        {
            System.out.println(key + ": " + rmap.getOrThrow(key));
            String s = key;
        }
    } catch(UnknownKeyException ue) {
            System.out.println("Key nicht gefunden.");
    }
    }

    public static void main(String[] args){
       var  map = new MutableMap <String, Integer>();
       
       putEntries(map);
       printEntries(map);
       
       var immutableMap = map.asImmutableMap();
       
       printEntries(immutableMap);
    }
}
