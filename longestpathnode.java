class UndirectedGraphNode {
	int val;
	ArrayList<UndirectedGraphNode> children;
	public UndirectedGraphNode (int val) {
		this.val = val;
		children = new ArrayList<UndirectedGraphNode>();
	}
}
class Solution {
	public int longestPath(int[] node, int[] edge) {
		int m = node.length;
		int n = edge.length;
		UndirectedGraphNode[] uNode = new UndirectedGraphNode[m];
		for (int i = 0; i < m; i++) {
			uNode[i] = new UndirectedGraphNode(node[i]);
		}
		int j = 0;
		while (j + 1 < n) {
			if(i == edge[j]) {
				uNode[i].children.add(j + 1);
			}	
			j = j + 2;
		}

		helper(0, uNode);

		return max；
	}
	public void helper (int rootNo, UndirectedGraphNode[] uNode){
		int max1 = 0, int max2 = 0, pathMax = 0;
		for (int i = 0; i < uNode[rootNo].children.size(); i++) {
			int j = uNode[rootNo].children.get(i);
			int path = helper(j, uNode);
			int distance = uNode[rootNo].val == uNode[j].val ? distance + 1 : 0;
			pathMax = Math.max(pathMax, distance);
			max = Math.max(max, path);

			if (uNode[rootNo].val == uNode[j].val) {
				if (path + 1 > max1){
                    max2 = max1;
                    max1 = path + 1;
                } else if (path + 1 > max2){
                    max2 = path + 1;
                }
			}
			max = Math.max(max, max1 + max2);
			return pathMax;
		}	
	}
}