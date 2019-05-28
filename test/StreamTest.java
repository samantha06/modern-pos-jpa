import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);

//        Stream<Integer> newStream = list1.stream().map(new Function<Integer, Integer>() {
//
//            @Override
//            public Integer apply(Integer integer) {
//                return integer + 5;
//            }
//        });
//
//        List<Integer> collect = newStream.collect(Collectors.toList());
//
//        System.out.println(collect);

        Stream<Integer> secondStream = list1.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer.intValue() == 10 || integer.intValue() == 20) {
                    return true;
                }
                return false;
            }
        });

        List<Integer> collect = secondStream.collect(Collectors.toList());

        System.out.println(collect);

    }

}
