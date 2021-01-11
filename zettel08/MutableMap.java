
public class MutableMap <K, V> extends AbstractReadableMap <K, V> implements WritableMap <K, V>
{
    public void put (K key, V value){

        for(int i = 0; i< entries.length; i++){
            if (entries[i] == null || entries[i].getKey().equals(key)){
                entries[i] = new Entry <K, V>(key, value);
                return;
            }
        }
    }

}
