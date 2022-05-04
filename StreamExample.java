package com.company;

import java.util.Arrays;
import java.util.stream.Stream;

//Stream
public class StreamExample {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
    }
}
