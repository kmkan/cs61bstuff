import java.util.List;
import java.util.ArrayList;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] arr;
    private int front;
    private int back;
    private int size;

   public ArrayDeque61B() {
       arr = (T[]) new Object[8];
       size = 8;
       front = (int) Math.floor(size / 2);
       back = (int) Math.floor(size / 2);
   }

    private void resizeFront(int capacity) {
        T[] newArr = (T[]) new Object[capacity];
        System.arraycopy(arr, front - size + 1, newArr, front, back - front);
        arr = newArr;
    }

    @Override
    public void addFirst(T x) {
       if (front == back) {
           back++;
       }
        if (front < 0) {
            front += size;
            back += size;
            resizeFront(size * 2);
            size *= 2;
        }

        arr[front] = x;
        front--;
    }

    private void resizeBack(int capacity) {
        T[] newArr = (T[]) new Object[capacity];
        System.arraycopy(arr, front, newArr, front, back - front);
        arr = newArr;
    }

    @Override
    public void addLast(T x) {
       if (back == front) {
           front--;
       }
        if (back == size) {
            resizeBack(size * 2);
            size *= 2;
        }

        arr[back] = x;
        back++;
    }

    @Override
    public List<T> toList() {
       List<T> returnList = new ArrayList<>();

       for (int i = front + 1; i < back; i++) {
           returnList.add(arr[i]);
       }

       return returnList;
    }

    @Override
    public boolean isEmpty() {
       return arr[front] == null && arr[back] == null && back - front == 1;
    }

    @Override
    public int size() {
       if (back == front) {
           return 0;
       }

       return back - front - 1;
    }

    @Override
    public T removeFirst() {
       if (front == back) {
           return null;
       }

       T item = arr[front + 1];
       arr[front + 1] = null;
       front++;

       return item;
    }

    @Override
    public T removeLast() {
        if (back == front) {
            return null;
        }

        T item = arr[back - 1];
        arr[back - 1] = null;
        back--;

        return item;
    }

    @Override
    public T get(int index) {
       if (index < 0 || index >= size) {
           return null;
       }

       return arr[index];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }
}
