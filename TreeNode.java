import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x ;
    }

    static TreeNode build() {
        //通过build方法构建一棵树，返回树的根节点
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    boolean isCompleteTree(TreeNode root) {
        //判定一棵树是否为完全二叉树：
        //1.先针对这个树进行层序遍历：
        //每个访问到的节点必须具备两个子树
        //如果只有右子树，则不是完全二叉树
        //直到最后一层无子树，则遍历结束
        if(root == null) {
            return true;
        }
        boolean isFirstStep = true;
        //开始层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer((TreeNode) root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
        }
        return isFirstStep;
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        //判断两棵树是否相同
        if(s == null && t == null) {
            return true;
        }
        if(s == null ||t == null){
            return false;
        }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
        // s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
        // s 也可以看做它自身的一棵子树
        if(s == null) {
            return false;
        }
        //先序遍历 s :判定s是否包含t
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public int maxDepth(TreeNode root) {
        //给定一个二叉树，找出其最大深度
        //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
        //ps: 叶子节点是指没有子节点的节点

        //最大深度 = 1 + max（左子树深度， 右子树深度）
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
        //给定一个二叉树，判断它是否是高度平衡的二叉树.
        //一棵高度平衡二叉树定义为：
        //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1.
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left - right <= 1 && left - right >= -1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean isMirrow(TreeNode t1, TreeNode t2) {
        //判定一棵树是否对称：
        //对应节点的值相同，左右子树刚好相反(与根节点无关)
        //左右子树的根节点值相等
        //&& 左子树.left 和右子树.right 是对称的
        //&& 左子树.right 和右子树.left 是对称的
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirrow(t1.left, t2.right) && isMirrow(t1.right, t2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        //给定一个二叉树，检查它是否是镜像对称的
        if(root == null) {
            return true;
        }
        return isMirrow(root.left, root.right);
    }
}

