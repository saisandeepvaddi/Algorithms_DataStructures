package LearnCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface Test{
    public void print(int i);
    public void print(int a, int b);
}

public class LambdaExpressions {
    public static void main(String[] args) {
//        Test a = new Test(){
//            public void print(int i){
//                System.out.println("Hello "+i);
//            }
//        };
//
//        a.print(5);


      List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

//        list.forEach((k)->{
//            System.out.println(k);
//        });

//        list.forEach(System.out::println);

        list.parallelStream().forEach(i->{
            if(i%2 == 1){
                System.out.println(i);
            }
        });
        System.out.println("///////////////////");

        list.forEach(i->{
            if(i%2 == 1){
                System.out.println(i);
            }
        });

        System.out.println("///////////////////");
        Optional<Integer> a = Optional.ofNullable(list.parallelStream().filter(i -> i % 2 == 0).findFirst().orElse(0));
        System.out.println(a);

//        System.out.println(oddList);


    }
}
