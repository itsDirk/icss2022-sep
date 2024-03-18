package nl.han.ica.datastructures;

public class HANStack<T> implements IHANStack<T>{
    private Node<T> first;
//    private int size;

    public HANStack() {
        first = null;
//        size = 0;
    }

    @Override
    public void push(T value){
        Node<T> oldFirst = first;
        first = new Node<T>(value);
        first.next = oldFirst;
//        size++;
    }

    @Override
    public T pop(){
        T value = first.value;
        first = first.next;
//        size--;
        return value;
    }

    @Override
    public T peek(){
        return first.value;
    }

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
