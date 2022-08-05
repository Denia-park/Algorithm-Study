package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args){
        Set<String> setExample = new HashSet<String>();
        setExample.add("One");
        setExample.add("Two");
        System.out.println(setExample.size());

        Iterator<String> it = setExample.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(setExample.remove("1"));

        System.out.println("--------------------------------");
        
        it = setExample.iterator(); // 반복자를 재생성한다. 왜 ? 위의 반복문에서 next 메서드를 통해서 데이터를
        // 다 가져왔기 때문에 내부 인덱스는 초기화가 안되서 ? 그런거 같다.
        
        //TresSet : 중복 데이터 X, 기본적으로 오름차순으로 데이터를 정렬
        //LinkedHashSet : 중복 데이터 X, 입력된 순서대로 데이터를 관리
    }
}
