package queue;

public class Main {

    public static void main(String[] args) {
        LoopQuquq2<Integer> loopQuquq = new LoopQuquq2<>();

        for (int i = 0; i < 20; i++) {
            loopQuquq.enqueue(i);
            if(i %3 == 0){
                loopQuquq.dequeue();
            }
            System.out.println(loopQuquq);
        }

        for (int i = 0; i < 12; i++) {
            loopQuquq.dequeue();
            System.out.println(loopQuquq);
        }
    }
}
