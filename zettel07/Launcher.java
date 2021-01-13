
public class Launcher
{


    private static void putEntries(WritableMap<String,Integer> wmap){
        wmap.put("sizeInMB", 42);
        wmap.put("version", 4);
        wmap.put("yearOfRelease", 2015);

    }

    private static void printEntries (ReadableMap<String, Integer> rmap){

        try{
            for (String key: rmap.keysAsSet()) {
                System.out.println(key + ": " + rmap.getOrThrow(key));
            }
        } catch(UnknownKeyException ue) {
            System.out.println(ue.getMessage());
        }
    }

    public static void main(String[] args){
        var map = new MutableMap <String, Integer>();

        putEntries(map);
        printEntries(map);

        ImmutableMap<String, Integer> immutableMap = map.asImmutableMap();

        printEntries(immutableMap);
    }
}
