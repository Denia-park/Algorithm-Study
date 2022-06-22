package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

//Stream
public class StreamExample {
    public static void main(String[] args) throws IOException {

        //가공하기
        //전체 요소 중에서 다음과 같은 API이용
        //내가 원하는 것만 뽑아낸다.
        //가공 단계 => 중간 작업 (intermediate operations) => 이런한 작업은 스트림을 리턴 ,
        // 여러 작업을 이어 붙여서 (chaining) 작성 가능
        List<String> names = Arrays.asList("Eric", "Elena", "Java");

        //Mapping
        //맵(map)은 스트림 내 요소들을 하나씩 특정값으로 변환

        //flatMap
        //return Type 이 Stream
        //즉, 새로운 스트림을 생성해서 리턴하는 람다를 넘겨야한다.
        //flatMap은 중첩 구조를 한단계 제거하고 단일 컬렉션으로 만들어주는 역할을 한다. = 플래트링 (flattening)
        List<List<String>> list =
                Arrays.asList(Arrays.asList("a","c"),
                        Arrays.asList("b","d"));// [[a,c], [b,d]]
//        List<String> flatList =
        Object[] flatList =
                list.stream()
//                        .map(String::toUpperCase)
                        .flatMap(Collection::stream)
                        .toArray();

        System.out.println(Arrays.toString(flatList)); // [a , c , b , d]

    }

}
