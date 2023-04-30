public class NewLinkedList <T> {

    Node<T> head;
    Node<T> tail;
    private int length = 0;

    public NewLinkedList() {
        head = null;
        tail = null;
    }

    public void print() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void append(T data) {
        Node<T> toInsert = new Node<>(data);
        if (head == null) {
            head = toInsert;
        } else {
            tail.next = toInsert;
        }
        tail = toInsert;
        length++;
    }

    public void prepend(T data) {
        Node<T> toInsert = new Node<>(data);
        if (head == null) {
            this.head = toInsert;
            tail = toInsert;
        } else {
            toInsert.next = this.head;
            this.head = toInsert;
        }
        length++;
    }

    public T getData(int position) {
        if (position < 0) {
            System.out.println("Can't search for a negative number");
            return null;
        } else if (position == 1) {
            return head.getData();
        } else if (position == this.length) {
            return tail.getData();
        }
        Node<T> traversal = traverse(position);
        return traversal.getData();
    }

    private Node<T> traverse(int position) {
        Node<T> trailer = head;
        for (int i = 0; i < position + 1; i++) {
            if (i == position - 1) {
                break;
            }
            trailer = trailer.next;
        }
        return trailer;
    }

    public void insert(int position, T data) {
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

        Node<T> trailer = traverse(position);
        Node<T> toInsert = new Node<>(data);
        toInsert.next = trailer.next;
        trailer.next = toInsert;
        length++;
    }

    public void remove(int index) {
        if (index > this.length) {
            System.out.println("Cannot remove this item as its position is longer than the list");
            return;
        }

        Node<T> trailer = traverse(index);
        trailer.next = trailer.next.next;
        length--;
    }

    public void reverse() {
        if (this.length == 1) {
            return;
        }
        Node<T> previous = null;
        Node<T> current = this.head;
        this.tail = this.head;
        while (this.head != null) {
            this.head = current.next;
            current.next = previous;
            previous = current;
            current = this.head;
        }
        this.head = previous;
    }

    public static boolean checkPalindrome(String original, String newWord) {
        return original.equals(newWord);
    }

    public static NewLinkedList<String> loopingAppend(String toAdd) {
        NewLinkedList<String> nll = new NewLinkedList<>();
        for (int i = 0; i < toAdd.length(); i++) {
            nll.append(toAdd.substring(i, i + 1));
        }
        return nll;
    }

    public static String linkedListtoString(NewLinkedList<String> list, int length) {
        String reverse = "";
        for (int i = 1; i < length + 1; i++) {
            reverse += list.getData(i);
        }
        return reverse;
    }
}