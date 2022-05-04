package com.company;

import java.io.IOException;
import java.util.Arrays;
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

        //Filtering
        //필터는 스트림 내 요소들을 하나씩 평가해서 걸러냄
        //인자로 받는 Predicate 는 Boolean을 리턴하는 함수형 인터페이스로 평가식이 들어간다.
        Stream<String> streamFilterEaxm = names.stream().filter(name -> name.contains("a"));
        System.out.println(Arrays.toString(streamFilterEaxm.toArray()));

    }

}
