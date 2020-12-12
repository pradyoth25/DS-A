package data_structures;

public class MyEntry<K, V> {

    int hash;
    K key;
    V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    public boolean equals(MyEntry<K, V> other) {
        if (this.hash != other.hash) return false;
        return this.key.equals(other.key);
    }

    @Override
    public String toString() {
        return key + " =>" + value;
    }

}
