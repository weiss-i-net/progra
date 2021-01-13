import java.util.*;

public abstract class AbstractReadableMap <K, V> implements ReadableMap <K, V>
{
    protected Entry <K, V> [] entries;

    public AbstractReadableMap (Entry <K, V> [] copy_entries){   
        this.entries = GenericArrayHelper.copyArray(copy_entries);
    }

    public AbstractReadableMap (){
        this.entries = GenericArrayHelper.newEntryArrayOfSize(10);

    }

    @Override
    public V getOrThrow(K key) throws UnknownKeyException{
        for (Entry<K, V> elem : entries)
            if( elem != null && elem.getKey().equals(key))
                return elem.getValue();

        throw new UnknownKeyException();
    }

    @Override
    public ImmutableMap <K,V> asImmutableMap(){
        return new ImmutableMap<K, V>(this.entries);
    }

    @Override
    public Set <K> keysAsSet (){
        HashSet <K> keyHashSet = new HashSet<>();

        for(Entry<K, V> entry : entries) {
            if (entry != null) {
                keyHashSet.add(entry.getKey());
            }
        }

        return keyHashSet;
    }
}

