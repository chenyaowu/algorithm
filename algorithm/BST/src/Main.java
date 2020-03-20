import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 1000; i++) {
            bst.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(bst.removeMin());
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                System.out.println("Error");
            }
        }

    }
}
