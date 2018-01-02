public class LongestPath {
    public int max;
    public int SameValue(int[] A, int[] E) {
        max = 0;
        int m = A.length;
        int n = E.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i =1; i <= m; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        int j = 0;
        while (j + 1 < n) {
            int u = E[j];
            int v = E[j + 1];
            j += 2;
            map.get(u).add(v);
            map.get(v).add(u);
        }

        helper(1, -1, A, map);

        return max;
    }

    public int helper (int rootNo, int parent, int[] node, HashMap<Integer, ArrayList<Integer>> map){
        int branch1 = 0, branch2 = 0, pathMax = 0;
        for (int k = 0; k < map.get(rootNo).size(); k++) {
            int j = map.get(rootNo).get(k);
            if (j == parent) continue;
            int path = helper(j, rootNo, node, map);
            int distance = node[rootNo - 1] == node[j - 1] ? path + 1 : 0;
            pathMax = Math. max(pathMax, distance);
            max = Math.max(max, path);
            if (node[rootNo - 1] == node[j - 1]){
                if (path + 1 > branch1){
                    branch2 = branch1;
                    branch1 = path + 1;
                }
                else if (path + 1 > branch2){
                    branch2 = path + 1;
                }
            }
        }
        max = Math.max(max, branch1 + branch2);
        return pathMax;
    }
}