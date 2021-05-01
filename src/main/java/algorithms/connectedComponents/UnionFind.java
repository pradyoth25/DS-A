package algorithms.connectedComponents;

public class UnionFind {

//    Complexity:
//
//    Time: O(n+mlogn), where m is the number of connections, n is the number of nodes.
//    Space: O(n)

    public int connectedComponents(int[][] edges, int n) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i ++) roots[i] = i;
        for (int[] edge : edges) {
            int root1 = find(roots, edge[0]);
            int root2 = find(roots, edge[1]);
            if (root1 != root2) {
                roots[root2] = root1;
                n --;
            }
        }
        return n;
    }
    private int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
