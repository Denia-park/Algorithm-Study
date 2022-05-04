package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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

        //제네릭을 사용하지 않고 직접적으로 해당 타입의 스트림을 다룰수도 있다.
        //range 와 rangeClosed는 범위의 차이.
        //두번째 인자인 종료지점이 포함되느냐 안되느냐의 차이
        IntStream intStream = IntStream.range(1, 5);//[1,2,3,4]
        LongStream longStream = LongStream.rangeClosed(1, 5);//[1,2,3,4,5]
        //제네릭을 사용하지 않기 때문에 불필요한 오토박싱이 일어나짐 않음
        //필요한 경우 boxed 메소드를 이용해서 박싱할 수 있다.
        Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
        //Java 8의 Random 클래스는 난수를 가지고 세 가지 타입의 스트림을 만들어낼수있다. (IntStream, LongStream, DoubleStream)
        //쉽게 난수 스트림을 생성해서 여러가지 후속 작업을 취할 수 있어 유용함
        DoubleStream doubleStream = new Random().doubles(3);//난수 3개 생성

        //스트링을 이용해서 스트림 생성도 가능하다.
        //그래도 스트링의 각 문자 (char)를 IntStream으로 변환한 예제
        //char는 문자 but 본질적으로 숫자
        IntStream charStream = "Stream".chars(); // [83, 116, 114, 101, 97, 109]
        //정규표현식(RegEx)을 이용해서 문자열을 자르고, 각 요소들로 스트림을 만든 예제
        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
        // [Eric, Elena, Java]
    }

    public Stream<String> streamOf(List<String> list){
        return list == null || list.isEmpty()
                ? Stream.empty() // 비어있으면 empty Stream
                : list.stream(); // list 가 존재하면 Stream을 생성한다.
    }

}
