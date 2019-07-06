import java.util.Random;

public class Main {

    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0;
    }

    public static void main(String[] args) {
      int opCount = 10000000;

        ArrayStack<Integer> stack = new ArrayStack<>();

        LinkedListStack<Integer> stack2 = new LinkedListStack<>();

        System.out.println(testStack(stack,opCount));
        System.out.println(testStack(stack2,opCount));
    }
}
