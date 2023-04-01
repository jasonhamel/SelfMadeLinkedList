public class NewLinkedList {

    Node head;
    Node tail;
    private int length = 0;

    public NewLinkedList(int data) {
        head = new Node(data);
        tail = head;
        length++;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void append(int data) {
        Node toInsert = new Node(data);
        tail.next = toInsert;
        tail = toInsert;
        length++;
    }

    public void prepend(int data) {
        Node toInsert = new Node(data);
        toInsert.next = this.head;
        this.head = toInsert;
        length++;
    }

    private Node traverse(int position) {
        Node trailer = head;
        for (int i = 0; i < position + 1; i++) {
            if (i == position - 1) {
                break;
            }
            trailer = trailer.next;
        }
        return trailer;
    }

    public void insert(int position, int data) {
        if (position > this.length) {
            System.out.println("Cannot add to this position as the list isn't that long.");
            return;
        } else if (position == 0) {
            prepend(data);
            return;
        } else if (position == this.length) {
            append(data);
            return;
        }

        Node trailer = traverse(position);
        Node toInsert = new Node(data);
        toInsert.next = trailer.next;
        trailer.next = toInsert;
        length++;
    }

    public void remove(int index) {
        if (index > this.length) {
            System.out.println("Cannot remove this item as its position is longer than the list");
            return;
        }

        Node trailer = traverse(index);
        trailer.next = trailer.next.next;
        length--;
    }

    public void reverse() {
        if (this.length == 1) {
            return;
        }
        tail = head;
        Node previous = null;

        while (head != null) {
            Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        head = previous;
    }
}