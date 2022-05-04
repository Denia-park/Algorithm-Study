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

        //iterate 메소드를 이용하면 초기값과 해당ㄱ밧을 다루는 람다를 이용하여 스트림에 들어갈 요소를 만든다.
        //예제는 30이 초기값이고 값이 2씩 증가하는 값들이 들어간다.
        //요소가 다음 요소의 인풋으로 들어간다.
        //이 방법도 스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야함
        Stream<Integer> iterateStream =
                Stream.iterate(30, n -> n + 2).limit(5);//[30,32,34,36,38]
    }

    public Stream<String> streamOf(List<String> list){
        return list == null || list.isEmpty()
                ? Stream.empty() // 비어있으면 empty Stream
                : list.stream(); // list 가 존재하면 Stream을 생성한다.
    }

}
