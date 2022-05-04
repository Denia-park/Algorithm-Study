package com.company;

import java.util.ArrayList;
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

        Stream<String> builderStream = Stream.<String>builder()
                .add("Eric")
                .add("Elena")
                .add("Java")
                .build(); // [Eric, Elena, Java]
    }

    public Stream<String> streamOf(List<String> list){
        return list == null || list.isEmpty()
                ? Stream.empty() // 비어있으면 empty Stream
                : list.stream(); // list 가 존재하면 Stream을 생성한다.
    }

}
