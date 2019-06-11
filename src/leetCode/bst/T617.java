package leetCode.bst;

public class T617 {
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		return merge(t1, t2);

	}

	public static TreeNode merge(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		t1.val = t1.val + t2.val;
		t1.left = merge(t1.left, t2.left);
		t1.right = merge(t1.right, t2.right);
		return t1;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode rootLeft = root.left = new TreeNode(3);

		root.right = new TreeNode(2);

		rootLeft.left = new TreeNode(5);

		TreeNode root2 = new TreeNode(2);

		TreeNode root2Left = root2.left = new TreeNode(1);

		TreeNode root2Right = root2.right = new TreeNode(3);

		root2Left.right = new TreeNode(4);

		root2Right.right = new TreeNode(7);

		System.out.println(mergeTrees(root, root2).val);
	}
}
