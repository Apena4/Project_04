import java.util.ArrayList;

public class Iterator implements Iterable<Task>{
    private ArrayList<Task> myList = new ArrayList<>();

    @Override
    public String toString() {
        return "Iterator{" +
                "myList=" + myList +
                '}';
    }

    @Override
    public java.util.Iterator<Task> iterator() {
        return null;
    }
}
