package array;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);

        int indexArr[] = arr.findAll(1);
        for (int i = 0; i < indexArr.length; i++) {
            System.out.print(indexArr[i] + " ");
        }
        System.out.println();
        System.out.println(arr);
        arr.removeAllElement(1000);
        System.out.println(arr);


    }
}
