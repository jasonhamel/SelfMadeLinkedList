
public class Main {
    public static void main(String[] args) {
        NewLinkedList nll = new NewLinkedList(45);
        nll.append(3);
        nll.append(900);
        nll.print();
        nll.prepend(100);
        System.out.println();
        nll.print();
        nll.insert(2, 99);
        System.out.println();
        nll.print();
        nll.remove(4);
        System.out.println();
        nll.print();
    }
}