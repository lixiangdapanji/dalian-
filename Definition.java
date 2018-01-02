Undirected graph
class UndirectedGraphNode {
	int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { 
    	label = x;
    	neighbors = new ArrayList<UndirectedGraphNode>(); 
    }
}


ListNode
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

Doubly-ListNode
public class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int val) {
        this.val = val;
        his.next = this.prev = null;
    }
}

reumove dupicate from array


Graph 
public Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
           graph.put(i, new HashSet<Integer>()); 
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}

TreeNode:
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}


singly-linked list with a random pointer.
class RandomListNode {
    int label;
  	RandomListNode next, random;
    	RandomListNode(int x) { 
      	this.label = x;
    }
}

方向数组
private class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

int[] deltaX = {1, 0, 0, -1};
int[] deltaY = {0, 1, -1, 0};

Coordinate adj = new Coordinate(node.x + deltaX[i], node.y + deltaY[i]);
grid[adj.x][adj.y]

private boolean inBound(boolean[][] grid, Coordinate node){
        int m = grid.length;
        int n = grid[0].length;
        
        if(node.x < 0 || node.x >= m){
            return false;
        }
        
        if(node.y < 0 || node.y >= n){
            return false;
        }
        
        return true;
    }
