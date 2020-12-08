package data_structures;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyUnionFind {

    int size;
    int[] parentPointer; // parentPointer[i] points to the parent of i
    int numComponents;

    public MyUnionFind(int size) {
        if (size <= 0) throw new IllegalArgumentException("make greater than 0");

        this.size = numComponents = size;
        parentPointer = new int[size];

        for (int i = 0; i < size; i ++) {
            parentPointer[i] = i;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != parentPointer[root]) {
            root = parentPointer[root];
            while (p != root) {
                int next = parentPointer[p];
                parentPointer[p] = root;
                p = next;
            }
        }
        return root;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int size() {
        return size;
    }

    public int getNumComponents() {
        return numComponents;
    }

    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        if (root1 == root2) return;

        parentPointer[root2] = root1;
        numComponents --;
    }

}
