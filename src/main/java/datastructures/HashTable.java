package datastructures;

public class HashTable {

  int ARRAY_SIZE = 30;
  HashEntry[] table = new HashEntry[ARRAY_SIZE];

  class HashEntry {

    String key;
    String value;
    HashEntry next;

    HashEntry(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  private int getHash(String key) {

    // hashing function performs bitwize operation to create positive int
    // 7 in hexadecimal = 0111 - 0 means positive int
    // modulus creates value between 0 and ARRAY_SIZE - 1
    int hash = (key.hashCode() & 0x7fffffff) % ARRAY_SIZE;

    // Specific to this repo - to force a collision between hashes
    if (key.equals("John Smith") || key.equals("Sandra Dee") || key.equals("Tim Lee")) {
      hash = 4;
    }
    return hash;
  }

  public void put(String key, String value) {
    int hash = getHash(key);
    HashEntry entry = new HashEntry(key, value);

    if (table[hash] == null) {
      table[hash] = entry;
      return;
    }

    HashEntry currentEntry = table[hash];
    while (currentEntry.next != null) {
      currentEntry = currentEntry.next;
    }

    currentEntry.next = entry;
    return;
  }

  public String get(String key) {
    int hash = getHash(key);

    HashEntry entry = table[hash];

    while (entry != null && !entry.key.equals(key)) {
      entry = entry.next;
    }

    if (entry == null) {
      return null;
    }

    return entry.value;
  }
}
