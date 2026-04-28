import java.util.*;

public class ProductPriceHash {

    // Fields & Constants
    private LinkedList<Entry>[] buckets;
    private int size;

    private static final int START_SIZE = 8;

    // Constructor
    public ProductPriceHash() {
        this.buckets = new LinkedList[START_SIZE];
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new LinkedList<Entry>();
        }
    }

    // Public Methods

    /**
     * Returns the number of unique key-value pairs stored in this ProductPriceHash
     *
     * @return The number of unique key-values pairs stored within
     */
    public int size() {
        return this.size;
    }

    /**
     * Associates the given productName with its corresponding price
     *
     * @param productName  [Key] Name of the product to price
     * @param productPrice [Value] Price of the product
     */
    public void put(String productName, double productPrice) {
        LinkedList<Entry> targetBucket = this.buckets[getBucketIndex(productName, this.buckets.length)];
        Entry existing = findEntry(targetBucket, productName);

        if (existing != null) {
            existing.price = productPrice;
        } else {
            this.size++;
            targetBucket.add(new Entry(productName, productPrice));
            checkAndGrow();
        }
    }

    /**
     * Returns the price associated with the given productName, or throws
     * an IllegalArgumentException if the key does not exist
     *
     * @param productName [Key] Name of the product for which to query the table
     * @throws IllegalArgumentException if key not in table
     * @return the price associated with the given productName
     */
    public double getPrice(String productName) {
        LinkedList<Entry> targetBucket = this.buckets[this.getBucketIndex(productName, this.buckets.length)];

        Entry existing = findEntry(targetBucket, productName);

        if (existing != null) {
            return existing.price;
        }

        throw new IllegalArgumentException("Key does not exist in this table!");
    }

    private Entry findEntry(LinkedList<Entry> targetBucket, String productName) {
        for (Entry entry : targetBucket) {
            if (entry.name.equals(productName)) {
                return entry;
            }
        }
        return null;
    }

    private int getBucketIndex(String productName, int bucketsSize) {
        int rawHash = productName.hashCode();
        return Math.abs(rawHash) % bucketsSize;
    }

    private void checkAndGrow() {
        double loadFactor = (double) this.size / this.buckets.length;
        if (loadFactor < 0.75) {
            return;
        }

        LinkedList<Entry>[] newBuckets = new LinkedList[this.buckets.length * 2];
        for (int i = 0; i < newBuckets.length; i++) {
            newBuckets[i] = new LinkedList<Entry>();
        }
        for (int i = 0; i < this.buckets.length; i++) {
            LinkedList<Entry> bucket = this.buckets[i];
            for (Entry entry : bucket) {
                int bucketIndex = getBucketIndex(entry.name, newBuckets.length);
                LinkedList<Entry> targetBucket = newBuckets[bucketIndex];
                targetBucket.add(new Entry(entry.name, entry.price));
            }
        }

        this.buckets = newBuckets;
    }

    public static void main(String[] args) {
        ProductPriceHash pr = new ProductPriceHash();
        pr.put("Apples", 3.50);
        pr.put("Pears", 2.50);
        pr.put("Dragonfruit", 10.00);
        System.out.println(pr.size()); // 3
        pr.put("Pears", 4.50); // Note: duplicate key overwrites previous!
        System.out.println(pr.size()); // Still 3!
        System.out.println(pr.getPrice("Apples")); // 3.50
        System.out.println(pr.getPrice("Pears")); // 4.50

        // Try querying for a key not stored within...
        try {
            System.out.println(pr.getPrice("Guava"));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(pr);
        System.out.println(pr.hashCode());

        HashMap<String, Integer>
    }

    // Inner Classes
    // Object to hold Key:Value Pairs
    private class Entry {

        String name;
        double price;

        Entry(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public boolean equals(Object other) {
            if (this.getClass() != other.getClass()) {
                return false;
            }
            Entry otherEntry = (Entry) other;
            return this.name.equals(otherEntry.name);
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }
    }

}