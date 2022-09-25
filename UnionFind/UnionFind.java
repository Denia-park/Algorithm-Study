package UnionFind;

public class UnionFind {
    public static void main(String[] args) {
        int[] parents = new int[11];
        for (int i = 1; i < 11; i++) {
            parents[i] = i;
        }

        unionParent(parents, 1, 2);
        unionParent(parents, 2, 3);
        unionParent(parents, 3, 4);
        unionParent(parents, 5, 6);

        System.out.printf("1 과 4는 연결되어 있나요? %s \n", findParent(parents,1,4));
        System.out.printf("1 과 6는 연결되어 있나요? %s \n", findParent(parents,1,6));

        unionParent(parents,1,6);

        System.out.printf("1 과 6는 연결되어 있나요? %s \n", findParent(parents,1,6));
    }

    //두 부모 노드를 합치는 함수
    private static void unionParent(int[] parents, int element1, int element2) {
        int parentOfElem1 = getParent(parents, element1);
        int parentOfElem2 = getParent(parents, element2);

        if(parentOfElem1 == parentOfElem2) return;

        if(parentOfElem1 < parentOfElem2) parents[parentOfElem2] = parentOfElem1;
        else parents[parentOfElem1] = parentOfElem2;
    }

    //부모 노드를 찾는 함수
    private static int getParent(int[] parents, int element) {
        int myParent = parents[element];

        if(myParent == element) return element;

        return parents[element] = getParent(parents, myParent);
    }
    //같은 부모를 가지는지 확인
    private static boolean findParent(int[] parents, int element1, int element2) {
        int parentOfElem1 = getParent(parents, element1);
        int parentOfElem2 = getParent(parents, element2);

        return parentOfElem1 == parentOfElem2;
    }
}
