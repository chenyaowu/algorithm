package LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            System.out.println(list);
        }

        list.add(4,10);
        System.out.println(list);
        list.set(4,11);
        System.out.println(list);
        list.addLast(12);
        System.out.println(list);

        list.remove(4);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);

    }
}
