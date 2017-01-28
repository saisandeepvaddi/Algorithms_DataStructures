package LearnGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * About the code :
 */

class GenericTaker<T extends Number> {
    T value;

    public void printType() {
        System.out.println(value.getClass().getName());
    }

    public void takeSubType(List<? extends T> list) {
        System.out.println(list.getClass().getName());
    }

    public void takeSuperType(List<? super T> list) {
        System.out.println(list.getClass().getName());
    }
}

public class GenericsProgram {
    public static void main(String[] args) {
        GenericTaker<Number> test = new GenericTaker<>();
        test.value = 10;
        test.printType();
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList() {{
            add(1);
            add(2);
        }};
        test.takeSubType(list);
    }
}
