package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Stream
public class StreamExample {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream2 = list.stream();
        Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림
    }
    }
}
