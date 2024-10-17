import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedList<E extends Comparable<? super E>> extends List<E> {

    @Override
    public void insert(E data) {
        head = insertRecursive(head, data);
    }

    private Node<E> insertRecursive(Node<E> current, E data) {
        if (current == null || data.compareTo(current.data) < 0) {
            Node<E> newNode = new Node<>(data);
            newNode.next = current;
            return newNode;
        }
        current.next = insertRecursive(current.next, data);
        return current;
    }

    @Override
    public void remove(E data) {
        head = removeRecursive(head, data);
    }

    private Node<E> removeRecursive(Node<E> current, E data) {
        if (current == null) return null;
        if (data.compareTo(current.data) == 0) {
            return current.next;
        }
        current.next = removeRecursive(current.next, data);
        return current;
    }

    @Override
    public E retrieve(int index) {
        return retrieveRecursive(head, index);
    }

    private E retrieveRecursive(Node<E> current, int index) {
        if (current == null || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) return current.data;
        return retrieveRecursive(current.next, index - 1);
    }

    @Override
    public boolean search(E data) {
        return searchRecursive(head, data);
    }

    private boolean searchRecursive(Node<E> current, E data) {
        if (current == null) return false;
        if (data.compareTo(current.data) == 0) return true;
        return searchRecursive(current.next, data);
    }

    @Override
    public Iterator<E> iterator() {
        return new SortedListIterator();
    }

    private class SortedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}