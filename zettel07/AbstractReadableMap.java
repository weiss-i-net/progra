import java.util.*;

abstract class AbstractReadableMap<K, V> implements ReadableMap<K, V> {

    protected Entry<K, V>[] entries;

    protected AbstractReadableMap(final Entry<K, V>[] entriesToCopy) {
        entries = GenericArrayHelper.copyArray(entriesToCopy);
    }

    protected AbstractReadableMap() {
        entries = GenericArrayHelper.newEntryArrayOfSize(10);
    }

    @Override
    public V getOrThrow(K key) throws UnknownKeyException {
        for (var entry : entries)
            if (entry != null && entry.getKey().equals(key))
                return entry.getValue();
        throw new UnknownKeyException("Key " + key + " was not found.");
    }

    @Override
    public ImmutableMap<K, V> asImmutableMap() {
        return new ImmutableMap<K, V>(entries);
    }

    @Override
    public Set<K> keysAsSet() {
        Set<K> keySet = new HashSet<K>();
        for (var entry : entries)
            if (entry != null)
                keySet.add(entry.getKey());
        return keySet;
    }

}
