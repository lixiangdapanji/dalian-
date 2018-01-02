public class FindDistanceBST {
    public static class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val){
                    this.val=val;
            }
    }
    public static int minDis=Integer.MAX_VALUE;
        public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.right.left=new TreeNode(7);
        
        int dis=findMinDistance(root,root.left.left,root.right.right);
        System.out.println(dis);
        }

    public static int findMinDistance(TreeNode root,TreeNode p,TreeNode q){
        TreeNode parent=findCommonAncestor(root,p,q);
        int a = findDis(parent,p,0);
        int b = findDis(parent,q,0);
        return a+b;
        }
        
    public static int findDis(TreeNode parent,TreeNode child,int level){
        if(parent==null){
            return -1;
            }
        if(parent==child){
            return level;
            }
            int left = findDis(parent.left,child,level+1);
            if(left!=-1) return left;
            int right=findDis(parent.right,child,level+1);
            if(right!=-1) return right;
            return -1;
        }
        
        public static TreeNode findCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
                if(root == null){
                        return null;
                }
                if(root == p || root == q){
                        return root;
                }
                TreeNode left = findCommonAncestor(root.left,p,q);
                TreeNode right = findCommonAncestor(root.right,p,q);
                if(left != null && right != null){
                        return root;
                }
                return left==null ? right : left;
                
        } 

}
