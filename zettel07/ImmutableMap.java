final public class ImmutableMap<K, V> extends AbstractReadableMap<K, V> {

    public ImmutableMap(final Entry<K, V>[] entries) {
        super(entries);
    }
}

