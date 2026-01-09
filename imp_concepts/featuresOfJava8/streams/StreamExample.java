package imp_concepts.featuresOfJava8.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        Integer[] arr = {1,2,1,2};
        System.out.print(Arrays.stream(arr).filter(x -> x%2 == 0).collect(Collectors.toList()));
    }
}
