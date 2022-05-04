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

        //generate 메소드를 이용하면 supplier<T> 에 해당하는 람다로 값을 넣을 수 있다.
        //Supplier<T>는 인자는 없고 리턴값만 있는 함수형 인터페이스.
        //람다에서 리턴하는 값이 들어간다.
        //이때 생성되는 스트림은 크기가 정해짐 X [무한] -> 특정 사이즈로 최대 크기를 제한해야 한다.
        Stream<String> generateStream =
                Stream.generate(() -> "gen").limit(5); // 5개의 "gen"이 들어간 스트림 생성
    }

    public Stream<String> streamOf(List<String> list){
        return list == null || list.isEmpty()
                ? Stream.empty() // 비어있으면 empty Stream
                : list.stream(); // list 가 존재하면 Stream을 생성한다.
    }

}
