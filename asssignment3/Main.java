public class Main {
    static void test(MyList<?> list) {
        try {
            list.get(0);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Test completed");
        }
    }

    public static void main(String[] args) {
        MyList<Integer> a = new MyArrayList<>();
        MyList<String> b = new MyLinkedList<>();

        a.add(10);
        a.insert(20, 1);

        b.add("A");
        b.delete(0);

        test(a);
        test(b);
    }
}
