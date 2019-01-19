import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("jamo2"));
        list.add(new Student("bert"));
        list.add(new Student("kees"));
        list.add(new Student("henk"));
        list.add(new Student("abel"));

        Collections.sort(list);
        System.out.println(list);
        // System.out.println(first.compareTo(second));
    }
}
