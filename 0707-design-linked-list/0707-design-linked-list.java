 class MyLinkedList {
 class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

      private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            // throw new IndexOutOfBoundsException("Index is not in range");
            return -1;
        }
        return getNode(index).val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        } else {
            Node newNode = new Node(val);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
            // throw new IndexOutOfBoundsException("Index is not in range");
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node prevNode = getNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            // throw new IndexOutOfBoundsException("Index is not in range");
            return;
        }
        if (index == 0) {
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        } else {
            Node prevNode = getNode(index - 1);
            prevNode.next = prevNode.next.next;
            if (index == size - 1) {
                tail = prevNode;
            }
        }
        size--;
    }

    private Node getNode(int index) {
        // if (index < 0 || index >= size) {
        //     return;
        //     // throw new IndexOutOfBoundsException("Index is not in range");
        // }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
 }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */