package Heap;

import java.util.ArrayList;

public class HeapStudy2_ArrayList {
    private ArrayList<Integer> heap;

    public HeapStudy2_ArrayList() {
        this.heap = new ArrayList<Integer>();
        this.heap.add(0); // 0번째 인덱스는 사용하지 않음.
    }

    //삽입
    public void insert(int val) {
        this.heap.add(val);
        int p = heap.size() - 1; //p는 새로 삽입한 노드의 인덱스
        //새로 삽입한 노드의 위치가 1 초과 , 부모가 자식보다 크면 실행
        // -> 새로 삽인한 노드의 위치가 루트까지 가거나 , 새로 삽입한 노드가 부모보다 클때까지 진행
        while (p > 1 && heap.get(p / 2) > heap.get(p)) {
            int temp = heap.get(p / 2); // 부모 노드의 값
            heap.set(p / 2, val); // 부모노드에 새로 들어온 값을 넣는다
            heap.set(p, temp); // 새로 삽입한 노드의 인덱스에 부모노드의 값을 넣는다.

            p = p / 2; // 새로 삽입한 노드가 한 레벨 상승 -> 인덱스도 부모 노드 인덱스 값으로 변경해줘야함.
        }
    }

    public int delete() {
        //힙이 비어있으면 0 리턴
        if (heap.size() < 2) { // size가 1이면 0만 들어있는 경우임 , 0을 항상 고려
            return 0;
        }

        //삭제할 노드 = 루트 노드
        int deleteitem = heap.get(1);

        //마지막 노드를 root에 삽입 , 마지막 노드 삭제
        int lastNodeIndex = heap.size() - 1;
        heap.set(1, heap.get(lastNodeIndex));
        heap.remove(lastNodeIndex);

        int index = 1; // 루트에 새로 삽입한 노드의 인덱스 정보

        //pos*2 = 왼쪽 자식의 인덱스 값 ,
        int leftChildNodeIndex = index * 2;
        int rightChildNodeIndex = index * 2 + 1;
        //자식의 인덱스 값이 힙의 사이즈 값보다 크다는 것은 더 이상 삽입할 위치를 벗어났다는 뜻
        //(★여기서 size는 0번 인덱스를 포함하기 때문에 우리가 생각하는 element 개수보다 1개 많다 주의 !!!★)
        while (leftChildNodeIndex < heap.size()) {
            int leftChildNodeValue = heap.get(leftChildNodeIndex); //왼쪽 자식의 값
            int rightChildNodeValue = heap.get(rightChildNodeIndex); //오른쪽 자식의 값

            int min = leftChildNodeValue;
            int minIndex = leftChildNodeIndex;

            //오른쪽 자식의 인덱스가 사이즈 보다 작고,
            //(★여기서 size는 0번 인덱스를 포함하기 때문에 우리가 생각하는 element 개수보다 1개 많다 주의 !!!★)
            //오른쪽 자식의 값이 왼쪽 자식 값보다 더 작을때 오른쪽 자식을 부모와 바꿔줄 자식으로 지정
            if (rightChildNodeIndex < heap.size() && leftChildNodeValue > rightChildNodeValue) {
                min = rightChildNodeValue;
                minIndex = rightChildNodeIndex;
            }

            //부모가 더 작으면 그만
            if (min > heap.get(index)) {
                break;
            }

            //부모 자식 교환
            int temp = heap.get(index);
            heap.set(index, heap.get(minIndex));
            heap.set(minIndex, temp);
            index = minIndex;
        }

        return deleteitem;
    }
}
