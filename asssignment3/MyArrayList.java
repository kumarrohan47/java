class MyArrayList<T> implements MyList<T> {
    private Object[] data = new Object[1];
    private int size = 0;

    public void add(T e) {
        ensureCapacity();
        data[size++] = e;
    }

    public void insert(T e, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        for (int i = size; i > index; i--)
            data[i] = data[i - 1];
        data[index] = e;
        size++;
    }

    public T get(int index) {
        if (isEmpty()) throw new IllegalStateException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    public void delete(int index) {
        if (isEmpty()) throw new IllegalStateException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        size--;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newArr = new Object[data.length * 2];
            System.arraycopy(data, 0, newArr, 0, data.length);
            data = newArr;
        }
    }
}
