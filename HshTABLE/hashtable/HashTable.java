public class HashTable implements Table {
    private String[] keys;
    private String[] values;
    private int size;

    public HashTable() {
        keys = new String[16];
        values = new String[16];
        size = 0;
    }

    private int computeIndex(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i); // Добавляем ASCII-код каждого символа
        }
        return sum % keys.length;

}

    @Override
    public void put(String key, String value) {
        int index = computeIndex(key);
        for (int i = 0; i < keys.length; i++) {
            if (keys[index] != null && keys[index].equals(key)) {
                values[index] = value;
                return;
            }
            if (keys[index] == null) {
                keys[index] = key;
                values[index] = value;
                size++;
                return;
            }
            index = (index + 1) % keys.length;
        }
    }

    @Override
    public String get(String key) {
        int index = computeIndex(key);
        for (int i = 0; i < keys.length; i++) {
            if (keys[index] != null && keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % keys.length;
        }
        return null;
    }

    @Override
    public void remove(String key) {
        int index = computeIndex(key);
        for (int i = 0; i < keys.length; i++) {
            if (keys[index] != null && keys[index].equals(key)) {
                keys[index] = null;
                values[index] = null;
                size--;
                return;
            }
            index = (index + 1) % keys.length;
        }
    }

    @Override
    public int size() {
        return size;
    }
}

