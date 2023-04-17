package JavaAlgorithmRef.Heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
    private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기
    private final Comparator<? super E> comparator;
    private int size; // 요소 개수
    private Object[] array; // 요소를 담을 배열

    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // 생성자 Type 2 (초기 공간 할당 O)
    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    public void add(E value) {
        siftUp(size + 1, value);
        size++;
    }

    /**
     * @param idx    추가할 노드의 인덱스
     * @param target 재배치 할 노드
     */
    private void siftUp(int idx, E target) {
        if (comparator != null) {
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if (comp.compare((E) parentVal, target) <= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = target;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target) {
        while (idx > 1) {
            int parent = getParent(idx);

            Object parentVal = array[parent];
            Comparable<? super E> comp = (Comparable<? super E>) parentVal;

            if (comp.compareTo(target) <= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = target;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if (array[1] == null) {    // 만약 root가 비어있을경우 예외를 던지도록 함
            throw new NoSuchElementException();
        }

        E result = (E) array[1];    // 삭제된 요소를 반환하기 위한 임시 변수
        E target = (E) array[size];    // 타겟이 될 요소
        array[size] = null;    // 타겟 노드를 비운다.

        // 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
        siftDown(1, target);    // 루트 노드가 삭제되므로 1을 넘겨준다.

        return result;
    }


    /**
     * @param idx    삭제할 노드의 인덱스
     * @param target 재배치 할 노드
     */
    private void siftDown(int idx, E target) {
        // comparator가 존재할 경우 comparator 을 인자로 넘겨준다.
        if (comparator != null) {
            siftDownComparator(idx, target, comparator);
        } else {
            siftDownComparable(idx, target);
        }
    }

    // Comparator을 이용한 sift-down
    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {

        array[idx] = null;    // 삭제 할 인덱스의 노드를 삭제
        size--;

        int parent = idx;    // 삭제노드부터 시작 할 부모를 가리키는 변수
        int child;    // 교환 될 자식을 가리키는 변수

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while ((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);    // 오른쪽 자식 인덱스

            Object childVal = array[child];    // 왼쪽 자식의 값 (교환 될 값)

            /*
             *  오른쪽 자식 인덱스가 size를 넘지 않으면서
             *  왼쪽 자식이 오른쪽 자식보다 큰 경우
             *  재배치 할 노드는 작은 자식과 비교해야하므로 child와 childVal을
             *  오른쪽 자식으로 바꿔준다.
             */
            if (right <= size && comp.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            // 재배치 할 노드가 자식 노드보다 작을경우 반복문을 종료한다.
            if (comp.compare(target, (E) childVal) <= 0) {
                break;
            }

            /*
             *  현재 부모 인덱스에 자식 노드 값을 대체해주고
             *  부모 인덱스를 자식 인덱스로 교체
             */
            array[parent] = childVal;
            parent = child;
        }

        // 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
        array[parent] = target;
    }

    // Comparable을 이용한 sift-down
    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target) {

        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while ((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);

            Object childVal = array[child];

            if (right <= size && ((Comparable<? super E>) childVal).compareTo((E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if (comp.compareTo((E) childVal) <= 0) {
                break;
            }
            array[parent] = childVal;
            parent = child;

        }
        array[parent] = comp;
    }
}
