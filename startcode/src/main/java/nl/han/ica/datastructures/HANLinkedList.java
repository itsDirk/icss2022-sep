package nl.han.ica.datastructures;

public class HANLinkedList<T> implements IHANLinkedList<T> {
    private Node<T> first;
    private int size;

    @Override
    public void addFirst(T value){
        Node<T> oldFirst = first;
        first = new Node<T>(value);
        first.next = oldFirst;
        size++;
    }

    @Override
    public void clear(){
        first = null;
        size = 0;
    }

    @Override
    public void insert(int index, T value){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node<T> current = first;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
        Node<T> newNode = new Node<T>(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    @Override
    public void delete(int pos){
        if(pos == 0){
            removeFirst();
            return;
        }
        Node<T> current = first;
        for(int i = 0; i < pos - 1; i++){
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    @Override
    public T get(int pos){
        Node<T> current = first;
        for(int i = 0; i < pos; i++){
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void removeFirst(){
        first = first.next;
        size--;
    }

    @Override
    public T getFirst(){
        return first.value;
    }

    @Override
    public int getSize(){
        return size;
    }

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
