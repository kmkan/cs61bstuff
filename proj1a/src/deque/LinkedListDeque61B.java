package deque;

import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    public class Node {
        Node prev;
        T item;
        Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    Node sentinel;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
    }

    @Override
    public void addFirst(T x) {
        if (sentinel.next == null) {
            Node firstNode = new Node(sentinel, x, sentinel);
            sentinel.prev = firstNode;
            sentinel.next = firstNode;
        } else {
            Node newNode = new Node(sentinel, x, sentinel.next);
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
        }
    }

    @Override
    public void addLast(T x) {
        if (sentinel.next == null) {
            Node firstNode = new Node(sentinel, x, sentinel);
            sentinel.prev = firstNode;
            sentinel.next = firstNode;
        } else {
            Node newNode = new Node(sentinel.prev, x, sentinel);
            sentinel.prev.next = newNode;
            sentinel.prev = newNode;
        }
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel.next;

        while (p.item != null) {
            returnList.add(p.item);
            p = p.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == null && sentinel.prev == null;
    }

    @Override
    public int size() {
        Node n = sentinel.next;
        int count = 0;
        while (n != null && n.item != null) {
            count++;
            n = n.next;
        }

        return count;
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }

        T item = sentinel.next.item;
        sentinel.next = sentinel.next.prev;

        return item;
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == null) {
            return null;
        }

        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.next;

        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }

        Node p = sentinel.next;
        int currentPosition = index;

        while (currentPosition != 0) {
            p = p.next;
            currentPosition--;
        }

        return p.item;
    }

    private T getRecursiveHelper(int index, Node n) {
        if (index == 0) {
            return n.item;
        }

        return getRecursiveHelper(index - 1, n.next);
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }

        return getRecursiveHelper(index, sentinel.next);
    }
}
