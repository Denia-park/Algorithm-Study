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

        //Mapping
        //맵(map)은 스트림 내 요소들을 하나씩 특정값으로 변환
        //이 때 값을 변환하기 위한 람다를 인자로 받는다.
        //스트림에 들어가 있는 값이 Input이 되어서 특정 로직을 거친 후 outptut이 되어 새로운 스트림에 담긴다. => 맵핑
        //스트림 내 String의 toUppterCase 메소드를 실행해서 대문자로 변환한 값들이 담긴 스트림을 리턴
        Stream<String> streamMappingEaxm =
                names.stream().map(name -> name.toUpperCase());

        System.out.println(Arrays.toString(streamMappingEaxm.toArray()));
    }

}
