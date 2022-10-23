package CollectionsEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class CollectionsEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(list);

        Collections.addAll(list, 1, 2, 3, 4, 5);
        System.out.println(list);

        Collections.rotate(list, 2); // 오른쪽으로 n칸씩 이동
        System.out.println(list);

        Collections.swap(list, 0, 2); // i 와 j 번째를 교환
        System.out.println(list);

        Collections.shuffle(list); //저장된 요소의 위치를 임의로 변경
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder()); // 역순 정렬 , reverse(list) 와 동일
        // Collections.reverse(list);
        // list.sort(Collections.reverseOrder());
        System.out.println(list);

        Collections.sort(list); //정렬
        System.out.println(list);

        int idx = Collections.binarySearch(list, 3); //3이 저장된 위치 (index)를 반환
        System.out.println("index of 3 = " + idx);

        System.out.println("max = " + Collections.max(list));
        System.out.println("min = " + Collections.min(list));
        System.out.println("min = " + Collections.max(list, Collections.reverseOrder()));

        Collections.fill(list, 9); // list를 9로 채운다.
        System.out.println("list = " + list);

        // list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
        List<Integer> newList = Collections.nCopies(list.size(), 2);
        System.out.println("newList=" + newList);

        System.out.println(Collections.disjoint(list, newList)); // 공통요소가 없으면 true

        Collections.copy(list, newList); // newList 를 list로 복사
        System.out.println("newList=" + newList);
        System.out.println("list = " + list);

        Collections.replaceAll(list, 2, 1);
        System.out.println("list = " + list);

        Enumeration<Integer> e = Collections.enumeration(list);
        ArrayList<Integer> list2 = Collections.list(e);

        System.out.println("list2 = " + list2);
    }
}
