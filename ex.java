DFS(subsets numbers of Islands)
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
        if(nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums); 
        ArrayList<Integer> subsets = new ArrayList<>();
        subsetsHelper(nums, 0, subsets, results);
        return results;
    }
    private void subsetsHelper(int[] nums,
                               int startIndex,
                               ArrayList<Integer> subsets,
                               List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subsets));
        for(int i = startIndex; i < nums.length; i++){ 
            if(i != startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            subsets.add(nums[i]);
            subsetsHelper(nums, i + 1, subsets, results);
            subsets.remove(subsets.size() - 1);
        }                          
    }
}
public class Solution {
    private int m, n;
    public void dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j]) {
            grid[i][j] = false;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
    public int numIslands(boolean[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j]) continue;
                ans++;
                dfs(grid, i, j);
            }
        }
        return ans;
    }
}
二分法(BadVersion sqrt(x))
class Solution {
    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(SVNRepo.isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(SVNRepo.isBadVersion(start) ){
            return start;
        }else{
            return end;
        }
    }
}
public class Solution {
    public double sqrt(double x) {
        // Write your code here
        double left = 0.0;
        double right = x;
        double eps = 1e-12;

        if(right < 1.0) {
            right = 1.0;
        }

        while(right - left > eps) {
            // 二分浮点数 和二分整数不同
            // 一般都有一个精度的要求 譬如这题就是要求小数点后八位
            // 也就是只要我们二分的结果达到了这个精度的要求就可以
            // 所以 需要让 right 和 left 小于一个我们事先设定好的精度值 eps
            // 一般eps的设定1e-8,因为这题的要求是到1e-8,所以我把精度调到了1e-12
            // 最后 选择 left 或 right 作为一个结果即可 
            double mid = (right + left) / 2;
            if(mid * mid < x) {
                left = mid;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}

class ResultType {
    boolean is_bst;
    int maxValue, minValue;
    
    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}

Devide and Conquer(ValidBST)
public class Solution {
    public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }
    
    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        
        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }
        
        if (root.left != null && left.maxValue >= root.val || 
              root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        
        return new ResultType(true,
                              Math.max(root.val, right.maxValue),
                              Math.min(root.val, left.minValue));
    }
}

非递归 InorderTraverse
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
}

非递归 前序遍历
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();        
        if (root == null) {
            return preorder;
        }        
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }        
        return preorder;
    }
}

Devide and Conquer + Travese
public class Solution {
    private int longest;
    
    public int longestConsecutive(TreeNode root) {
        // write your code here
        longest = 0;
        helper(root);
        return longest;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int subLongest = 1;
        if(root.left != null && root.val + 1 == root.left.val){
            subLongest = Math.max(subLongest, left + 1);
        }
        
        if(root.right != null && root.val + 1 == root.right.val){
            subLongest = Math.max(subLongest, right + 1);
        }
        
        if(subLongest > longest){
            longest = subLongest;
        }
        
        return longest;
    }
}

Serialization and Deserialization
public class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node == null) {
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() -1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) != null) {
                sb.append(",");
                sb.append(list.get(i).val);
            }else{
                sb.append(",#");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }
        String[] list = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        ArrayList<TreeNode> listNode = new ArrayList<>();
        listNode.add(root);
        boolean isLeft = true;
        int index = 0;
        for (int i = 1; i < list.length; i++) {
            if (!list[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(list[i]));
                if (isLeft) {
                    listNode.get(index).left = node;
                }else{
                    listNode.get(index).right = node;
                }
                listNode.add(node);
            }
            if(!isLeft) {
            index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}

iterator 
public class BSTIterator {
    
    TreeNode node = null;
    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        node = root;
    }
    
    private Stack<TreeNode> stack = new Stack<TreeNode>();;
    
    
    //@return: True if there has next node, or false
    public boolean hasNext() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
            node = null;
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        if (!hasNext()) {
            return null;
        }
        TreeNode cur = stack.pop();
        node = cur.right;
        return cur;
    }
}

clone graph
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
            return node;
        }
        ArrayList<UndirectedGraphNode> nodes = getNode(node);
        //copy nodes into hashMap
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode n: nodes){
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        for(UndirectedGraphNode n: nodes){
            UndirectedGraphNode newNode = mapping.get(n);
            for(UndirectedGraphNode neighbor: n.neighbors){
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }     
        return mapping.get(node);
    }
    private ArrayList<UndirectedGraphNode> getNode(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();    
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode neighbor: head.neighbors){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}

minimum spinning tree
public class Solution {
    private class Coordinate{
        private int x;
        private int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;
        
    public int[] deltaX = {0, 1, 0, -1};
    public int[] deltaY = {1, 0, -1, 0};
    
    public int zombie(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
          return 0;
        }  
        int n = grid.length;
        int m = grid[0].length;
        int people = 0; 
       //寻找可以放入queue的点，将僵尸放入，统计人数
        Queue<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == PEOPLE){
                    people++;
                }else if(grid[i][j] == ZOMBIE){
                    queue.offer(new Coordinate(i, j));
                }
            }
        }
        if(people == 0){
          return 0;
        }
        int days = 0;
        while(!queue.isEmpty()){
            days++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Coordinate zb = queue.poll();
                for(int dir = 0; dir < 4; dir++){
                    Coordinate adj = new Coordinate(
                        zb.x + deltaX[dir],
                        zb.y + deltaY[dir]);
                    if(!isPeople(adj, grid)){
                        continue;
                    }
                    grid[adj.x][adj.y] = ZOMBIE;
                    people--;
                    if(people == 0){
                        return days;
                    }
                    queue.offer(adj);
                }
            }    
        }
        return -1;  
    } 
    private boolean isPeople(Coordinate coor, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        if(coor.x < 0 || coor.x >= n){
            return false;
        }
        if(coor.y < 0 || coor.y >= m){
            return false;
        }
        return grid[coor.x][coor.y] == PEOPLE;
    }
}
Expression Expand 
public class Solution {
    public String expressionExpand(String s) {
        // write your code here
        int number = 0;
        int count = 0;
        String subString = "";
        StringBuilder sb = new StringBuilder();
        
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (count == 0) {
                    number = number * 10 + c - '0';
                } else {
                    subString = subString + c;
                }
            } else if (c == '[') {
                if (count > 0) {
                    subString = subString + c;
                }
                count++;
            } else if (c == ']') {
                count--;
                if (count == 0) {
                    String expandedString = expressionExpand(subString);
                    for (int i = 0; i < number; i++) {
                        sb.append(expandedString);
                    }
                    number = 0;
                    subString = "";
                } else {
                    subString = subString + c;
                }
            } else {
                if (count == 0) {
                    sb.append(String.valueOf(c));
                } else {
                    subString = subString + c;
                }
            }
        }
        return sb.toString();
    }
}
