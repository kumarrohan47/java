class MyLinkedList<T> implements MyList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T d) { data = d; }
    }

    private Node<T> head;
    private int size;

    public void add(T e) {
        if (head == null) head = new Node<>(e);
        else {
            Node<T> cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = new Node<>(e);
        }
        size++;
    }

    public void insert(T e, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            Node<T> n = new Node<>(e);
            n.next = head;
            head = n;
        } else {
            Node<T> cur = head;
            for (int i = 0; i < index - 1; i++) cur = cur.next;
            Node<T> n = new Node<>(e);
            n.next = cur.next;
            cur.next = n;
        }
        size++;
    }

    public T get(int index) {
        if (isEmpty()) throw new IllegalStateException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.data;
    }

    public void delete(int index) {
        if (isEmpty()) throw new IllegalStateException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) head = head.next;
        else {
            Node<T> cur = head;
            for (int i = 0; i < index - 1; i++) cur = cur.next;
            cur.next = cur.next.next;
        }
        size--;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
