public class Launcher {

    private static void putEntries(WritableMap<String, Integer> map) {
        map.put("sizeInMB", 42);
        map.put("version", 4);
        map.put("yearOfRelease", 2015);
    }

    private static void printEntries(ReadableMap<String, Integer> map) {
        try {
            for (String key : map.keysAsSet())
                System.out.println(key + ": " + map.getOrThrow(key));
        }
        catch (UnknownKeyException exp) {
            System.out.println(exp.getMessage());
        }
    }

    public static void main(String[] args) {

        var map = new MutableMap<String, Integer>();

        putEntries(map);
        printEntries(map);

        var immutableMap = map.asImmutableMap();

        printEntries(immutableMap);
    }
}

